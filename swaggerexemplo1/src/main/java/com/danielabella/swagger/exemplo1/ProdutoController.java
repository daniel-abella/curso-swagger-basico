package com.danielabella.swagger.exemplo1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final List<String> produtos = new ArrayList<>();

    @Operation(summary = "Lista todos os produtos")
    @ApiResponse(responseCode = "200", description = "Lista de produtos retornada com sucesso")
    @GetMapping
    public ResponseEntity<List<String>> listarProdutos() {
        return ResponseEntity.ok(produtos);
    }

    @Operation(summary = "Adiciona um novo produto")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Produto criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Nome do produto inválido")
    })
    @PostMapping
    public ResponseEntity<String> adicionarProduto(
        @RequestBody(description = "Nome do produto", required = true) String nome) {

        if (nome == null || nome.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Nome inválido");
        }

        produtos.add(nome);
        return ResponseEntity.status(201).body("Produto adicionado: " + nome);
    }

    @Operation(summary = "Busca um produto pelo índice")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Produto encontrado"),
        @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @GetMapping("/{indice}")
    public ResponseEntity<String> buscarProduto(@PathVariable int indice) {
        if (indice < 0 || indice >= produtos.size()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtos.get(indice));
    }

    @Operation(summary = "Atualiza um produto pelo índice")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Nome inválido"),
        @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @PutMapping("/{indice}")
    public ResponseEntity<String> atualizarProduto(@PathVariable int indice, @RequestBody String novoNome) {
        if (indice < 0 || indice >= produtos.size()) {
            return ResponseEntity.notFound().build();
        }
        if (novoNome == null || novoNome.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Nome inválido");
        }

        produtos.set(indice, novoNome);
        return ResponseEntity.ok("Produto atualizado para: " + novoNome);
    }

    @Operation(summary = "Remove um produto pelo índice")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Produto removido com sucesso"),
        @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @DeleteMapping("/{indice}")
    public ResponseEntity<Void> removerProduto(@PathVariable int indice) {
        if (indice < 0 || indice >= produtos.size()) {
            return ResponseEntity.notFound().build();
        }

        produtos.remove(indice);
        return ResponseEntity.noContent().build();
    }
}
