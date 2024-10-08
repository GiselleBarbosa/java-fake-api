package com.barbosa.fakeapi.business.services;

import com.barbosa.fakeapi.apiv1.dto.ProductsDTO;
import com.barbosa.fakeapi.business.converter.ProdutoConverter;
import com.barbosa.fakeapi.infrastructure.client.FakeApiClient;
import com.barbosa.fakeapi.infrastructure.error.NotificacaoErro;
import com.barbosa.fakeapi.infrastructure.exceptions.BusinessException;
import com.barbosa.fakeapi.infrastructure.exceptions.ConflictException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FakeApiService {

    private final FakeApiClient cliente;
    private final ProdutoConverter converter;
    private final ProdutoService produtoService;

    @NotificacaoErro
    public List<ProductsDTO> buscaProdutos() {
        try {


            List<ProductsDTO> dto = cliente.buscaTodosProdutos();
            dto.forEach(produto -> {
                        Boolean retorno = produtoService.existsPorNome(produto.getNome());
                        if (retorno.equals(false)) {
                            produtoService.salvaProduto(converter.toEntity(produto));
                        } else {
                            throw new ConflictException("Produto já existente no banco de dados " + produto.getNome());
                        }
                    }

            );
            return produtoService.buscaTodosProdutos();
        } catch (ConflictException e) {
            throw new ConflictException(e.getMessage());
        } catch (Exception e) {
            throw new BusinessException("Erro ao buscar e gravar produtos no banco de dados");
        }
    }
}
