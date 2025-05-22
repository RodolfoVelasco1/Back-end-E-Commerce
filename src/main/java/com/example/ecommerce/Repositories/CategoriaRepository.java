package com.example.ecommerce.Repositories;

import com.example.ecommerce.Models.Entities.Categoria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends BaseRepository<Categoria,Long> {
    List<Categoria> findByCategoriaPadreId(Long idPadre);
    List<Categoria> findByCategoriaPadreIsNull();

}
