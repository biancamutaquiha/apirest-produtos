package br.com.mutaquiha.produtos.service;

import br.com.mutaquiha.produtos.entity.Produto;
import br.com.mutaquiha.produtos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> findById(long id) {
        return produtoRepository.findById(id);
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deleteById(long id) {
        produtoRepository.deleteById(id);
    }

    public boolean existsById(long id) {
        return produtoRepository.existsById(id);
    }
}
