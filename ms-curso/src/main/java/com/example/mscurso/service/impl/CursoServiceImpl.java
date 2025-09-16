package com.example.mscurso.service.impl;

import com.example.mscurso.entity.Curso;
import com.example.mscurso.repository.CursoRepository;
import com.example.mscurso.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    @Override
    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso obtenerPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public Curso guardar(Curso curso) {
        return cursoRepository.save(curso);
    }
}
