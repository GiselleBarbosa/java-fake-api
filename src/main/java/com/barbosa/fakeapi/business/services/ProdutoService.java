package com.barbosa.fakeapi.business.services;

import com.barbosa.fakeapi.apiv1.dto.ProductsDTO;
import com.barbosa.fakeapi.infrastructure.entities.ProdutoEntity;
import com.barbosa.fakeapi.infrastructure.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoEntity salvaProduto(ProdutoEntity produtoEntity) {
        try {
            return repository.save(produtoEntity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar produto" + e.getMessage());
        }
    }

    public List<ProdutoEntity> buscaTodosProdutos() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar todos os produtos.");
        }
    }

    public ProdutoEntity buscaProdutoPorNome(String nome) {
        try {
            return repository.findByNome(nome);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar produto por nome.");
        }
    }

    public void deletaProdutoPorNome(String nome) {
        try {
            repository.deleteByNome(nome);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover produto por nome.");
        }
    }

    public Boolean existeProdutoPorNome(String nome) {

        try {
            return repository.existsByNome(nome);
        } catch (Exception e) {
            throw new RuntimeException(format("Erro ao buscar produto por nome", nome), e);
        }

    }
}
