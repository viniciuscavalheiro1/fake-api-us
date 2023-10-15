package com.viniciuscavalheiro.fakeapius.business.service;


import com.viniciuscavalheiro.fakeapius.infrastructure.entities.ProdutoEntity;
import com.viniciuscavalheiro.fakeapius.infrastructure.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private ProdutoRepository repository;

    public ProdutoEntity salvaProduto(ProdutoEntity entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar Produtos " + e);
        }
    }

    public List<ProdutoEntity> buscaTodosProdutos() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar todos os produtos" + e);
        }
    }
}
