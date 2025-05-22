package com.example.ecommerce.Models.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "precios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Precio extends Base {

    @Column(name = "precio_compra", nullable = false)
    private double precioCompra;

    @Column(name = "precio_venta", nullable = false)
    private double precioVenta;

    @OneToMany(mappedBy = "precio", cascade = CascadeType.ALL)
    private Set<DetalleProducto> detalleProductos = new HashSet<>();

    @ManyToMany(mappedBy = "precios")
    private List<Descuento> descuentos;


}
