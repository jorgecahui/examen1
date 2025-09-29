package com.example.msmatricula.controller;

import com.example.msmatricula.entity.Matricula;
import com.example.msmatricula.feign.CursoClient;
import com.example.msmatricula.feign.CursoDTO;
import com.example.msmatricula.service.CursoIntegrationService;
import com.example.msmatricula.service.MatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/matriculas")
@RequiredArgsConstructor
public class MatriculaController {

    private final MatriculaService matriculaService;
    private final CursoIntegrationService cursoIntegrationService;

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

        List<CursoDTO> cursos = matricula.getCursoIds().stream()
                .map(cursoIntegrationService::obtenerCurso)
                .collect(Collectors.toList());

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("id", matricula.getId());
        response.put("nombreAlumno", matricula.getNombreAlumno());
        response.put("numeroMatricula", matricula.getNumeroMatricula());
        response.put("cursos", cursos);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public Matricula crear(@RequestBody Matricula matricula) {
        return matriculaService.guardar(matricula);
    }
}
