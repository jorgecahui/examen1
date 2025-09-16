package com.example.mscurso.controller;

import com.example.mscurso.entity.Curso;
import com.example.mscurso.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @GetMapping
    public List<Curso> listar() {
        return cursoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtener(@PathVariable Long id) {
        Curso curso = cursoService.obtenerPorId(id);
        return curso != null ? ResponseEntity.ok(curso) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Curso crear(@RequestBody Curso curso) {
        return cursoService.guardar(curso);
    }
}
