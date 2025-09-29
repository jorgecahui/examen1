package com.example.msmatricula.service;

import com.example.msmatricula.feign.CursoClient;
import com.example.msmatricula.feign.CursoDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoIntegrationService {

    private final CursoClient cursoClient;

    @CircuitBreaker(name = "cursoService", fallbackMethod = "fallbackObtenerCurso")
    @Retry(name = "cursoService")
    public CursoDTO obtenerCurso(Long id) {
        return cursoClient.obtenerCurso(id);
    }

    public CursoDTO fallbackObtenerCurso(Long id, Throwable t) {
        return new CursoDTO(id, "Servicio no disponible", "N/A");
    }
}
