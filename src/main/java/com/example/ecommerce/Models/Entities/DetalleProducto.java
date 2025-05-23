package com.example.ecommerce.Models.Entities;

import com.example.ecommerce.Models.Enums.Color;
import com.example.ecommerce.Models.Enums.Talle;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "detalleProductos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleProducto extends Base {

    private Boolean estado;

    @Enumerated(EnumType.STRING)
    private Talle talle;

    @Enumerated(EnumType.STRING)
    private Color color;

    private String marca;

    private Integer stock;



    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "precio_id")
    private Precio precio;

    @ManyToMany
    @JoinTable(
            name = "detalle_imagen",
            joinColumns = @JoinColumn(name = "detalle_id"),
            inverseJoinColumns = @JoinColumn(name = "imagen_id")
    )
    private List<Imagen> imagenes;

    @OneToMany(mappedBy = "detalleProducto")
    private List<OrdenCompraDetalle> ordenes = new ArrayList<>();

}
