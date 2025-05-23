package com.example.ecommerce.Controllers;

import com.example.ecommerce.Models.Entities.Categoria;
import com.example.ecommerce.Services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")

public class CategoriaController extends BaseController<Categoria, Long> {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        super(categoriaService);
        this.categoriaService = categoriaService;
    }

    @GetMapping("/raiz")
    public ResponseEntity<List<Categoria>> listarCategoriasRaiz() {
        List<Categoria> categoriasRaiz = categoriaService.listarCategoriasRaiz();
        return ResponseEntity.ok(categoriasRaiz);
    }


    @GetMapping("/{idPadre}/subcategorias")
    public ResponseEntity<List<Categoria>> listarSubcategorias(@PathVariable Long idPadre) {
        List<Categoria> subcategorias = categoriaService.listarSubcategorias(idPadre);
        return ResponseEntity.ok(subcategorias);
    }

}

