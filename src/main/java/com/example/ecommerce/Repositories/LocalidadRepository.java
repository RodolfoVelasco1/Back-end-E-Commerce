package com.example.ecommerce.Repositories;

import com.example.ecommerce.Models.Entities.Localidad;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalidadRepository extends BaseRepository<Localidad,Long>{
    List<Localidad> findAllByProvinciaId(Long idProvincia);
}
