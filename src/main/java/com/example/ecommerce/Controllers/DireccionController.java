package com.example.ecommerce.Controllers;

import com.example.ecommerce.Models.Entities.Direccion;
import com.example.ecommerce.Services.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/direcciones")

public class DireccionController extends BaseController<Direccion, Long> {

    private final DireccionService direccionService;

    @Autowired
    public DireccionController(DireccionService direccionService) {
        super(direccionService);
        this.direccionService = direccionService;
    }

    @GetMapping("/localidad/{idLocalidad}")
    public ResponseEntity<List<Direccion>> listarPorLocalidad(@PathVariable Long idLocalidad) {
        try {
            List<Direccion> direcciones = direccionService.listarPorLocalidad(idLocalidad);
            return ResponseEntity.ok(direcciones);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

}
