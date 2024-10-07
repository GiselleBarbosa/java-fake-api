package com.barbosa.fakeapi.business.services;

import com.barbosa.fakeapi.apiv1.dto.ProductsDTO;
import com.barbosa.fakeapi.business.converter.ProdutoConverter;
import com.barbosa.fakeapi.infrastructure.client.FakeApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FakeApiService {

    private final FakeApiClient client;
    private final ProdutoConverter converter;
    private final ProdutoService service;

    public List<ProductsDTO> buscaTodosProdutos() {

        try {
            List<ProductsDTO> dto = client.buscaTodosProdutos();
            dto.forEach(
                    produto -> {
                        Boolean retorno = service.existeProdutoPorNome(produto.getNome());
                        if (retorno.equals(false)) {
                            service.salvaProduto(converter.toEntity(produto));
                        }
//                        throw new RuntimeException(format("Produto já cadastrado no banco de dados.", produto.getNome()));
                    }
            );
            return converter.toListDTO(service.buscaTodosProdutos());

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar e salvar produto no banco de dados");
        }
    }
}
