package com.example.msmatricula.service.impl;

import com.example.msmatricula.entity.Matricula;
import com.example.msmatricula.repository.MatriculaRepository;
import com.example.msmatricula.service.MatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaRepository matriculaRepository;

    @Override
    public List<Matricula> listar() {
        return matriculaRepository.findAll();
    }

    @Override
    public Matricula obtenerPorId(Long id) {
        return matriculaRepository.findById(id).orElse(null);
    }

    @Override
    public Matricula guardar(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }
}
