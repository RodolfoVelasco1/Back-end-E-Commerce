package com.example.ecommerce.Repositories;

import com.example.ecommerce.Models.Entities.Producto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends BaseRepository<Producto,Long> {

}
