package com.barbosa.fakeapi.infrastructure.repositories;

import com.barbosa.fakeapi.infrastructure.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, String> {

    Boolean existsByNome(String nome);

    ProdutoEntity findByNome(String nome);

    ProdutoEntity deleteByNome(String nome);
}
