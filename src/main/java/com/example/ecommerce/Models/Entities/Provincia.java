package com.example.ecommerce.Models.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="provincias")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Provincia extends Base{
    @Column(name="provincia")
    private String nombre;

    @ManyToOne
    @JoinColumn(name="pais_id")
    private Pais pais;
}

