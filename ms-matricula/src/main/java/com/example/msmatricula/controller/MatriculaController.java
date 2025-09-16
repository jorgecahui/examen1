package com.example.msmatricula.controller;

import com.example.msmatricula.entity.Matricula;
import com.example.msmatricula.feign.CursoClient;
import com.example.msmatricula.feign.CursoDTO;
import com.example.msmatricula.service.MatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/matriculas")
@RequiredArgsConstructor
public class MatriculaController {

    private final MatriculaService matriculaService;
    private final CursoClient cursoClient;

    @GetMapping
    public List<Matricula> listar() {
        return matriculaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> obtener(@PathVariable Long id) {
        Matricula matricula = matriculaService.obtenerPorId(id);
        if (matricula == null) {
            return ResponseEntity.notFound().build();
        }

        // Feign llama al ms-curso
        CursoDTO curso = cursoClient.obtenerCurso(matricula.getCursoId());

        // Armar la respuesta combinada
        Map<String, Object> response = new HashMap<>();
        response.put("id", matricula.getId());
        response.put("nombreAlumno", matricula.getNombreAlumno());
        response.put("numeroMatricula", matricula.getNumeroMatricula());
        response.put("curso", curso);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public Matricula crear(@RequestBody Matricula matricula) {
        return matriculaService.guardar(matricula);
    }
}
