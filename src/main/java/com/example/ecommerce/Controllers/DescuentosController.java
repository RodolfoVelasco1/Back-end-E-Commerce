package com.example.ecommerce.Controllers;

import com.example.ecommerce.Models.Entities.Descuento;
import com.example.ecommerce.Services.DescuentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/descuentos")

public class DescuentosController extends BaseController<Descuento, Long> {

    private final DescuentosService descuentosService;

    @Autowired
    public DescuentosController(DescuentosService descuentosService) {
        super(descuentosService);
        this.descuentosService = descuentosService;
    }

    @GetMapping("/{idDescuento}")
    public ResponseEntity<Descuento> obtenerPorIdDescuento(@PathVariable Long idDescuento) {
        try {
            Optional<Descuento> descuento = descuentosService.obtenerPorIdDescuento(idDescuento);
            return descuento.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }
}
