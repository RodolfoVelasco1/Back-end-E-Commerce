package com.example.ecommerce.Repositories;

import com.example.ecommerce.Models.Entities.Direccion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DireccionRepository extends BaseRepository<Direccion,Long> {
    List<Direccion> findAllByLocalidadId(Long idLocalidad);


}