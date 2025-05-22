package com.example.ecommerce.Models.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "descuentos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Descuento extends Base {

    @Column(name = "porcentaje")
    private Double porcentaje;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_final")
    private LocalDateTime fechaFinal;

    @ManyToMany
    @JoinTable(
            name = "precioid_descuentoid",
            joinColumns = @JoinColumn(name = "descuento_id"),
            inverseJoinColumns = @JoinColumn(name = "precio_id")
    )
    private List<Precio> precios;
}
