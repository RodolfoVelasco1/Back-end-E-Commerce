package com.example.ecommerce.Controllers;

import com.example.ecommerce.Models.Entities.OrdenCompraDetalle;
import com.example.ecommerce.Services.OrdenCompraDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orden_compra_detalle")
public class OrdenCompraDetalleController extends BaseController<OrdenCompraDetalle, Long> {

    private final OrdenCompraDetalleService ordenCompraDetalleService;

    @Autowired
    public OrdenCompraDetalleController(OrdenCompraDetalleService ordenCompraDetalleService) {
        super(ordenCompraDetalleService);
        this.ordenCompraDetalleService = ordenCompraDetalleService;
    }
}
