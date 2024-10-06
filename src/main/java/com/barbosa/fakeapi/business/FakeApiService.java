package com.barbosa.fakeapi.business;

import com.barbosa.fakeapi.apiv1.dto.ProductsDto;
import com.barbosa.fakeapi.infrastructure.FakeApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FakeApiService {

    private final FakeApiClient fakeApiClient;

    public List<ProductsDto> buscaTodosProdutos() {
        return fakeApiClient.buscaTodosProdutos();
    }
}
