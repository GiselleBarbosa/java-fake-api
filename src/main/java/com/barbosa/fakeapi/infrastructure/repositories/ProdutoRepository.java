package com.barbosa.fakeapi.infrastructure.repositories;

import com.barbosa.fakeapi.infrastructure.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, String> {
}
