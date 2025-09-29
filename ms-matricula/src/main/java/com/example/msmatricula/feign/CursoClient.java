package com.example.msmatricula.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-curso", path = "/cursos", fallback = CursoClientFallback.class)
public interface CursoClient {

    @GetMapping("/{id}")
    CursoDTO obtenerCurso(@PathVariable("id") Long id);
}
