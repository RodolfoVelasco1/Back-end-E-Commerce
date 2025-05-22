package com.example.ecommerce.Models.Auth;


import com.example.ecommerce.Models.Entities.Usuario;
import com.example.ecommerce.Models.Enums.Rol;
import com.example.ecommerce.Repositories.UsuarioRepository;
import com.example.ecommerce.Services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = usuarioRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        var jwtToken = jwtService.getToken(user);

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
    public AuthResponse register(RegisterRequest request){
        var user= Usuario.builder()
        .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))

                .nombre(request.getFirstname())
        .apellido(request.getLastname())

                .direcciones(new HashSet<>()) // si no las cargás desde el form
                .rol(Rol.USUARIO)
        .build();
        usuarioRepository.save(user);
        // 5. Generar el token JWT
        var jwtToken = jwtService.getToken(user);
        return AuthResponse.builder()
        .token(jwtToken)
        .build();
    }
}
