package com.example.ecommerce.Models.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orden_compra")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdenCompra extends Base {
    @Column(name = "total")
    private Float total;

    @Column(name = "fecha_compra")
    private LocalDateTime fechaDeCompra;

    @ManyToOne
    @JoinColumn(name="usuario_direccion")
    private Direccion direccion;

    @OneToMany(mappedBy = "ordenCompra", cascade = CascadeType.ALL)
    private Set<OrdenCompraDetalle> detalles = new HashSet<>();


}
