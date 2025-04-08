package com.blogpessoal.blog.controller;

import com.blogpessoal.blog.dto.UsuarioLoginDTO;
import com.blogpessoal.blog.model.Usuario;
import com.blogpessoal.blog.repository.UsuarioRepository;
import com.blogpessoal.blog.security.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioLoginDTO loginDTO) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(loginDTO.getEmail());

        if (usuario.isPresent() && encoder.matches(loginDTO.getSenha(), usuario.get().getSenha())) {
            String token = jwtUtils.generateToken(usuario.get().getEmail());

            return ResponseEntity.ok().body("Bearer " + token);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos.");
    }
}
