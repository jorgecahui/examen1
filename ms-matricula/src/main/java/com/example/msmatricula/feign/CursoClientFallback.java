package com.example.msmatricula.feign;

import org.springframework.stereotype.Component;

@Component
public class CursoClientFallback implements CursoClient {

    @Override
    public CursoDTO obtenerCurso(Long id) {
        return new CursoDTO(id, "Servicio no disponible", "N/A");
    }
}
