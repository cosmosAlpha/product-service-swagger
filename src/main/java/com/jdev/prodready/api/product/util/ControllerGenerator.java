package com.jdev.prodready.api.product.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ControllerGenerator {

    public static void main(String[] args) throws IOException {
        Path outputDir = Paths.get("src/main/java/com/jdev/prodready/api/product/controller");
        Files.createDirectories(outputDir);

        for (int i = 1; i <= 100; i++) {
            String className = "BenchmarkController" + i;
            String content = """
                    package com.jdev.prodready.api.product.controller;
                    
                    import org.springframework.web.bind.annotation.*;
                    import java.util.List;
                    import com.jdev.prodready.api.product.dto.*;
                    
                    @RestController
                    @RequestMapping("/api/v1/benchmark%d")
                    public class %s {
                    
                        @GetMapping
                        public List<String> getAll() { return List.of("data"); }
                    
                        @PostMapping
                        public String create(@RequestBody SampleDto dto) { return "ok"; }
                    
                        @PutMapping("/{id}")
                        public String update(@PathVariable String id, @RequestBody SampleDto dto) { return id; }
                    
                        @DeleteMapping("/{id}")
                        public void delete(@PathVariable String id) {}
                    }
                    """.formatted(i, className, className);

            Files.writeString(outputDir.resolve(className + ".java"), content);
        }
    }
}
