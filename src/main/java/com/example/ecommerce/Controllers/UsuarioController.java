package com.example.ecommerce.Controllers;


import com.example.ecommerce.Models.Entities.Usuario;
import com.example.ecommerce.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends BaseController<Usuario, Long> {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        super(usuarioService);
        this.usuarioService = usuarioService;
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Usuario> getByUsername(@PathVariable String username) {
        Optional<Usuario> usuario = usuarioService.findByUsername(username);

        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}