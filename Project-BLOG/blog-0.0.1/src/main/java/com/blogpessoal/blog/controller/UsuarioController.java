package com.blogpessoal.blog.controller;

import com.blogpessoal.blog.model.Usuario;
import com.blogpessoal.blog.repository.UsuarioRepository;
import com.blogpessoal.blog.dto.UsuarioLoginDTO;
import com.blogpessoal.blog.service.UsuarioService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@Valid @RequestBody Usuario usuario) {
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioRepository.save(usuario));
    }

    @PostMapping("/login")
    public ResponseEntity<?> logar(@RequestBody UsuarioLoginDTO usuarioLoginDTO) {
        Optional<Usuario> usuario = usuarioService.autenticarUsuario(
                usuarioLoginDTO.getEmail(),
                usuarioLoginDTO.getSenha());

        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha inválidos.");
    }
}
