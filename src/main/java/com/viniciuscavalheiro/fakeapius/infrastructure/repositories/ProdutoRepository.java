package com.viniciuscavalheiro.fakeapius.infrastructure.repositories;

import com.viniciuscavalheiro.fakeapius.infrastructure.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, String> {
}
