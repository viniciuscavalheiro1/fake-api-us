package com.viniciuscavalheiro.fakeapius.apiv1.dto;

import com.viniciuscavalheiro.fakeapius.business.service.FakeApiService;
import com.viniciuscavalheiro.fakeapius.business.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produtos")
@RequiredArgsConstructor
@Tag(name = "fake-api")
public class FakeAPiController {

    private final FakeApiService service;
    private final ProdutoService produtoService;

    @Operation(summary = "Busca produtos da API e Salvar", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca de dados"),
    })
    @PostMapping("/api")
    public ResponseEntity<List<ProductsDTO>> salvaProdutosApi() {
        return ResponseEntity.ok(service.buscaListaProducts());
    }

    @Operation(summary = "Salva novos produtos", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto salvo com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar os produtos"),
    })
    @PostMapping("/")
    public ResponseEntity <ProductsDTO> salvaProduto(@RequestBody ProductsDTO dto) {
        return ResponseEntity.ok(produtoService.salvaProdutoDTO(dto));
    }

    @Operation(summary = "Fazer update de novos produtos", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar os produtos"),
    })
    @PutMapping("/")
    public ResponseEntity <ProductsDTO> updateProdutos(@RequestParam("id") String id, @RequestBody ProductsDTO dto) {
        return ResponseEntity.ok(produtoService.updateProduto(id, dto));
    }

    @Operation(summary = "Deleta produtos", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto salvo com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar os produtos"),
    })
    @DeleteMapping("/")
    public ResponseEntity <Void> DeletaProduto(@RequestParam("nome") String nome) {
        produtoService.deletaProduto(nome);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Buscar todos os produtos", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todos os produtos"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar lista de produtos"),
    })
    @GetMapping("/")
    public ResponseEntity<List<ProductsDTO>> buscarTodosProdutos() {
        return ResponseEntity.ok(produtoService.buscaTodosProdutos());
    }

    @Operation(summary = "Buscar produtos por nome", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar produto"),
    })
    @GetMapping("/{nome}")
    public ResponseEntity<ProductsDTO> buscaProdutoPorNome(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(produtoService.buscaProdutoPorNome(nome));
    }
}

/*
* @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca de dados"),
    })
    **/