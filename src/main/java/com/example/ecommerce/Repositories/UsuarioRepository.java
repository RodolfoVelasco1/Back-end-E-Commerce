package com.example.ecommerce.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.Models.Entities.Usuario;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long>, JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
