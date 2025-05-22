package com.example.ecommerce.Controllers;

import com.example.ecommerce.Models.Entities.Pais;
import com.example.ecommerce.Services.PaisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/paises")
public class PaisController extends BaseController<Pais, Long>{
    public PaisController(PaisService paisService){
        super(paisService);
    }
}
