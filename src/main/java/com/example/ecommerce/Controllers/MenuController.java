package com.example.ecommerce.Controllers;

import com.example.ecommerce.Dto.CategoriaMenuDTO;
import com.example.ecommerce.Models.Enums.Sexo;
import com.example.ecommerce.Services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
@CrossOrigin(origins = "*") // opcional para frontend
public class MenuController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaMenuDTO>> getMenuBySexo(@RequestParam Sexo sexo) {
        return ResponseEntity.ok(categoriaService.obtenerMenuPorSexo(sexo));
    }
}
