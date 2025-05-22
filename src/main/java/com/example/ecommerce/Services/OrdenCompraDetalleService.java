package com.example.ecommerce.Services;

import com.example.ecommerce.Models.Entities.OrdenCompraDetalle;
import com.example.ecommerce.Repositories.OrdenCompraDetalleRepository;
import org.springframework.stereotype.Service;


@Service
public class OrdenCompraDetalleService extends BaseService<OrdenCompraDetalle, Long> {

    private final OrdenCompraDetalleRepository detalleRepository;

    public OrdenCompraDetalleService(OrdenCompraDetalleRepository detalleRepository) {
        super(detalleRepository);
        this.detalleRepository = detalleRepository;
    }

}