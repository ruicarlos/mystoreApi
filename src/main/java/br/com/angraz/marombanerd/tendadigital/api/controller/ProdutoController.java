package br.com.angraz.marombanerd.tendadigital.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.angraz.marombanerd.tendadigital.domain.exception.DomainExceptions;
import br.com.angraz.marombanerd.tendadigital.domain.model.Produto;
import br.com.angraz.marombanerd.tendadigital.domain.repository.ProdutoRepository;
import br.com.angraz.marombanerd.tendadigital.domain.service.ProdutoService;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produtos")
    public List<Produto> Produtos_listagem(){
        return produtoRepository.findAll();
    }

    @GetMapping("/produto/{codBarras}")
    public ResponseEntity<Produto> Produto_Codbarras(@PathVariable String codBarras){
       return produtoRepository.findByCodbarras(codBarras)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/produtos/{status}")
    public List<Produto> Produto_porStatus(@PathVariable String status){
        return produtoRepository.findAllByAtivo(status);
    }

    



    @PostMapping("/produto")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto addProd(@RequestBody Produto prod){
        return produtoService.salvar(prod);
    }

    /* 
    @PutMapping("/contas/{idConta}")
    public ResponseEntity<Conta> Conta_atualizar(@PathVariable Long idConta, @RequestBody Conta conta){
        if(!contaRepository.existsById(idConta)){
            return ResponseEntity.notFound().build();
        }
       return  ResponseEntity.ok().build();

    }

    */


    @ExceptionHandler(DomainExceptions.class)
    public ResponseEntity<String> capturar(DomainExceptions e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
