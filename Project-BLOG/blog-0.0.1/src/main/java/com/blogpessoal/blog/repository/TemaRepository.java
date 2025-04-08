package com.blogpessoal.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.blogpessoal.blog.model.Tema;
import java.util.List;

public interface TemaRepository extends JpaRepository<Tema, Long> {
    List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
}
