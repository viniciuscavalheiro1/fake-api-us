package com.viniciuscavalheiro.fakeapius.infrastructure.repositories;

import com.viniciuscavalheiro.fakeapius.infrastructure.entities.ProdutoEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, String> {

    Boolean existsByNome(String nome);

    ProdutoEntity findByNome(String nome);

    @Transactional
    void deleteByNome(String nome);
}
