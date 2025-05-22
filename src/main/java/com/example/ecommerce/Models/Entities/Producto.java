package com.example.ecommerce.Models.Entities;


import com.example.ecommerce.Models.Enums.Sexo;
import com.example.ecommerce.Models.Enums.TipoProducto;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "productos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Producto extends Base{

    @Column
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo_producto")
    protected Sexo sexo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_producto")
    protected TipoProducto tipoProducto;

    @ManyToMany
    @JoinTable(
            name = "producto_categoria",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private Set<Categoria> categorias = new HashSet<>();

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private Set<DetalleProducto> detalleProductos = new HashSet<>();


}

