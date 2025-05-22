package com.example.ecommerce.Models.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "imagen")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Imagen extends Base{

    @Column(name = "url")
    private String url;

    @ManyToMany(mappedBy = "imagenes")
    private List<DetalleProducto> detalleProductos;



}
