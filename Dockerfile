FROM eclipse-temurin:25-jre-alpine AS runner

WORKDIR /app

# Create non-root system group and user
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Create dedicated directory for static API contracts with proper ownership
RUN mkdir -p /app/static-docs && chown -R appuser:appgroup /app

# Copy compiled JAR artifact from builder stage
COPY --chown=appuser:appgroup target/*.jar /app/app.jar

# Copy static OpenAPI spec artifact from builder stage
COPY --chown=appuser:appgroup target/classes/static/openapi.json /app/static-docs/openapi.json

# Switch to non-privileged user context
USER appuser

# Expose standard HTTP application port
EXPOSE 8080

# Configure healthcheck to query Actuator endpoint
HEALTHCHECK --interval=30s --timeout=3s --retries=3 \
  CMD wget --quiet --tries=1 --spider http://localhost:8080/actuator/health || exit 1

# Define immutable entrypoint using shell exec form array
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]