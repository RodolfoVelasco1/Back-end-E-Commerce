package com.example.ecommerce.Controllers;

import com.example.ecommerce.Models.Entities.OrdenCompra;
import com.example.ecommerce.Services.OrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orden_compra")
public class OrdenCompraController extends BaseController<OrdenCompra, Long> {

    private final OrdenCompraService ordenCompraService;

    @Autowired
    public OrdenCompraController(OrdenCompraService ordenCompraService) {
        super(ordenCompraService);
        this.ordenCompraService = ordenCompraService;
    }



}