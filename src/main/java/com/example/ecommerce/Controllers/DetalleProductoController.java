package com.example.ecommerce.Controllers;

import com.example.ecommerce.Models.Entities.DetalleProducto;
import com.example.ecommerce.Services.DetalleProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detalleProductos")
public class DetalleProductoController extends BaseController<DetalleProducto, Long> {

    private final DetalleProductoService detalleProductoService;

    @Autowired
    public DetalleProductoController(DetalleProductoService detalleProductoService) {
        super(detalleProductoService);
        this.detalleProductoService = detalleProductoService;
    }
}

