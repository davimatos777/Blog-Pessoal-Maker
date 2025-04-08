package com.blogpessoal.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blogpessoal.blog.model.Postagem;

import java.util.List;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
    List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);
}

