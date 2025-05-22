package com.example.ecommerce.Models.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="direcciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Direccion extends Base{
    @Column(name="calle")
    private String calle;

    @Column(name="numero")
    private int numero;

    @Column(name="numero_departamento")
    private int deptoNro;

    @Column(name="cp")
    private int codigoPostal;

    @ManyToOne
    @JoinColumn(name="localidad_id")
    private Localidad localidad;

    @ManyToMany(mappedBy = "direcciones")
    private Set<Usuario> usuarios = new HashSet<>();

}
