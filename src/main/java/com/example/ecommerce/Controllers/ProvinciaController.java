package com.example.ecommerce.Controllers;

import com.example.ecommerce.Models.Entities.Provincia;
import com.example.ecommerce.Services.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/provincia")

public class ProvinciaController extends BaseController<Provincia, Long> {

    private final ProvinciaService provinciaService;

    @Autowired
    public ProvinciaController(ProvinciaService provinciaService) {
        super(provinciaService);
        this.provinciaService = provinciaService;
    }
}

