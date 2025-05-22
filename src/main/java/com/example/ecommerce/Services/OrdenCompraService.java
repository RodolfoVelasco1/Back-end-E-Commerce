package com.example.ecommerce.Services;

import com.example.ecommerce.Models.Entities.OrdenCompra;
import com.example.ecommerce.Repositories.OrdenCompraRepository;
import org.springframework.stereotype.Service;

@Service
public class OrdenCompraService extends BaseService<OrdenCompra, Long> {

    private final OrdenCompraRepository ordenCompraRepository;

    public OrdenCompraService(OrdenCompraRepository ordenCompraRepository) {
        super(ordenCompraRepository);
        this.ordenCompraRepository = ordenCompraRepository;
    }

}