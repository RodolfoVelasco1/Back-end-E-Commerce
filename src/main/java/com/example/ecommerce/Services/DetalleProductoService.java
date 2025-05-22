package com.example.ecommerce.Services;

import com.example.ecommerce.Models.Entities.DetalleProducto;
import com.example.ecommerce.Repositories.DetalleProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class DetalleProductoService extends BaseService<DetalleProducto, Long>{
    private final DetalleProductoRepository detalleProductoRepository;

    public DetalleProductoService(DetalleProductoRepository detalleProductoRepository) {
        super(detalleProductoRepository);
        this.detalleProductoRepository = detalleProductoRepository;
    }

}
