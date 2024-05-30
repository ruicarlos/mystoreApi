package br.com.angraz.marombanerd.tendadigital.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.angraz.marombanerd.tendadigital.domain.model.Conta;

import java.util.List;
import java.util.Optional;


@Repository
public interface ContaRepository extends JpaRepository <Conta, Long> {

    Optional<Conta> findByEmail(String email);
    Optional<Conta> findByUsuarioAndSenha(String usuario, String senha);
    List<Conta> findByUsuarioContaining(String usuario);
    Conta findByEmailAndUsuario(String email, String usuario);
}
