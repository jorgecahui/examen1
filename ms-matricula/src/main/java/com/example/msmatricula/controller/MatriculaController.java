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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/matriculas")
@RequiredArgsConstructor
public class MatriculaController {

    private final MatriculaService matriculaService;
    private final CursoClient cursoClient;

    // Listar todas las matrículas
    @GetMapping
    public List<Matricula> listar() {
        return matriculaService.listar();
    }

    // Obtener matrícula por ID con todos los cursos
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> obtener(@PathVariable Long id) {
        Matricula matricula = matriculaService.obtenerPorId(id);
        if (matricula == null) {
            return ResponseEntity.notFound().build();
        }

        // Llamar a ms-curso vía Feign para cada cursoId
        List<CursoDTO> cursos = matricula.getCursoIds().stream()
                .map(cursoClient::obtenerCurso)
                .collect(Collectors.toList());

        // Armar la respuesta combinada
        Map<String, Object> response = new HashMap<>();
        response.put("id", matricula.getId());
        response.put("nombreAlumno", matricula.getNombreAlumno());
        response.put("numeroMatricula", matricula.getNumeroMatricula());
        response.put("cursos", cursos);

        return ResponseEntity.ok(response);
    }

    // Crear matrícula con varios cursos
    @PostMapping
    public Matricula crear(@RequestBody Matricula matricula) {
        return matriculaService.guardar(matricula);
    }
}
