package com.example.mscurso.service;

import com.example.mscurso.entity.Curso;

import java.util.List;

public interface CursoService {
    List<Curso> listar();
    Curso obtenerPorId(Long id);
    Curso guardar(Curso curso);
}
