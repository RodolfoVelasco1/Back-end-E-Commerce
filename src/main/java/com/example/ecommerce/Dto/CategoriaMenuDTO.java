package com.example.ecommerce.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoriaMenuDTO {
    private String categoria;
    private List<SubcategoriaDTO> subcategorias;

}
