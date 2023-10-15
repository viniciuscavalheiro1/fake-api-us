package com.viniciuscavalheiro.fakeapius.business.service;

import com.viniciuscavalheiro.fakeapius.apiv1.dto.ProductsDTO;
import com.viniciuscavalheiro.fakeapius.business.converter.ProdutoConverter;
import com.viniciuscavalheiro.fakeapius.infrastructure.client.FakeApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FakeApiService {

    private final FakeApiClient client;

    private final ProdutoConverter converter;

    private final ProdutoService produtoService;
    public List<ProductsDTO> buscaListaProducts() {
        List<ProductsDTO> dto = client.buscaListaProducts();
        dto.forEach(produto -> {
            produtoService.salvaProduto(converter.toEntity(produto));
            }
        );
        return dto;
    }
}
