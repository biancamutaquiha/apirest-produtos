package br.com.mutaquiha.produtos.controller;

import br.com.mutaquiha.produtos.entity.Produto;
import br.com.mutaquiha.produtos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/produtos")
public class ProdutoController implements Serializable {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public List<Produto> getAllProdutos() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable long id) {
        Optional<Produto> produto = produtoService.findById(id);

        if (produto.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(produto.get());

    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto saveProduto(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        if (!produtoService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        produtoService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateById(@PathVariable Long id, @RequestBody Produto produto) {
        if (!produtoService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        produto.setId(id);
        produto = produtoService.save(produto);

        return ResponseEntity.ok(produto);
    }
}
