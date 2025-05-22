package com.example.ecommerce.Dto;

import com.example.ecommerce.Models.Enums.Color;
import com.example.ecommerce.Models.Enums.Sexo;
import com.example.ecommerce.Models.Enums.Talle;
import com.example.ecommerce.Models.Enums.TipoProducto;
import lombok.Data;

import java.util.List;

@Data
public class FiltroProductoDTO {
    private String descripcion;
    private Sexo sexo;
    private TipoProducto tipoProducto;
    private List<Long> categoriasIds;
    private Color color;
    private Talle talle;
    private String marca;
    private Double precioMin;
    private Double precioMax;
}
