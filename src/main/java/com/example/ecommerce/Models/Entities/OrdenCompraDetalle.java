package com.example.ecommerce.Models.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orden_compra_detalle")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdenCompraDetalle extends Base {

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "subtotal")
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "orden_compra_id")
    private OrdenCompra ordenCompra;

    @ManyToOne
    @JoinColumn(name = "detalle_id")
    private DetalleProducto detalleProducto;
}
