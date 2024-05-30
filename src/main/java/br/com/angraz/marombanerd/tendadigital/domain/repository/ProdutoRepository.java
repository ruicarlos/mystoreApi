package br.com.angraz.marombanerd.tendadigital.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.angraz.marombanerd.tendadigital.domain.model.Produto;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long> {

    Optional<Produto> findByDescricao(String descricao);
    Optional<Produto> findByCodbarras(String codbarras);
    List<Produto> findAllByAtivo(String ativo);
    List<Produto> findAllByCategoria(String categoria);
    List<Produto> findAllBySubcategoria(String sub);
}
