package br.com.angraz.marombanerd.tendadigital.domain.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.angraz.marombanerd.tendadigital.domain.exception.DomainExceptions;
import br.com.angraz.marombanerd.tendadigital.domain.model.Produto;
import br.com.angraz.marombanerd.tendadigital.domain.repository.ProdutoRepository;

@AllArgsConstructor
@Service
public class ProdutoService {


    private ProdutoRepository produtoRepository;

    @Transactional
    public Produto salvar(Produto produto){
        boolean codbarrasEmUso = produtoRepository.findByCodbarras(produto.getCodbarras()).isPresent();

        if(codbarrasEmUso){
            throw new DomainExceptions("Já Existe um Produto cadastrado  com esse Codigode Barras");
        }

        return produtoRepository.save(produto);
    }
}
