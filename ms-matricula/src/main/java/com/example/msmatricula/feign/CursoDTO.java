package com.example.msmatricula.feign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CursoDTO {
    private Long id;
    private String nombre;
    private String codigo;
}
