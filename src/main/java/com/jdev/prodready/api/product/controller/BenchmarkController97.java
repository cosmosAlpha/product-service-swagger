package com.jdev.prodready.api.product.controller;

import com.jdev.prodready.api.product.dto.SampleDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/benchmark97")
public class BenchmarkController97 {

    @GetMapping
    public List<String> getAll() {
        return List.of("data");
    }

    @PostMapping
    public String create(@RequestBody SampleDto dto) {
        return "ok";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable String id, @RequestBody SampleDto dto) {
        return id;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
    }
}
