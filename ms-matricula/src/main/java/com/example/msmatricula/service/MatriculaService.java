package com.example.msmatricula.service;

import com.example.msmatricula.entity.Matricula;

import java.util.List;

public interface MatriculaService {
    List<Matricula> listar();
    Matricula obtenerPorId(Long id);
    Matricula guardar(Matricula matricula);
}
