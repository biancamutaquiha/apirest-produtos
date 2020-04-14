package br.com.mutaquiha.produtos.controller;

import br.com.mutaquiha.produtos.entity.Produto;
import br.com.mutaquiha.produtos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("produtos")
    public List<Produto> getAllProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("produtos/{id}")
    public Optional<Produto> getProdutoById(@PathVariable long id){
        return produtoRepository.findById(id);
    }

    @PostMapping("produtos")
    public Produto saveProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }
}
