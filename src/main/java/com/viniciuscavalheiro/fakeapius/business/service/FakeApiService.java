package com.viniciuscavalheiro.fakeapius.business.service;

import com.viniciuscavalheiro.fakeapius.apiv1.dto.ProductsDTO;
import com.viniciuscavalheiro.fakeapius.business.converter.ProdutoConverter;
import com.viniciuscavalheiro.fakeapius.infrastructure.client.FakeApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class FakeApiService {

    private final FakeApiClient client;

    private final ProdutoConverter converter;

    private final ProdutoService produtoService;
    public List<ProductsDTO> buscaListaProducts() {
        try {

            List<ProductsDTO> dto = client.buscaListaProducts();
            dto.forEach(produto -> {
                        Boolean retorno = produtoService.existsPorNome(produto.getNome());
                        if(retorno == false) {
                            produtoService.salvaProduto(converter.toEntity(produto));
                        }
            }
            );
            return produtoService.buscaTodosProdutos();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar e gravar produtos no banco de dados");
        }
    }
}
