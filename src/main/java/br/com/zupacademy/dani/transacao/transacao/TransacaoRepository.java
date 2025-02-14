package br.com.zupacademy.dani.transacao.transacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    List<Transacao> findByCartaoNumero(String numero);

    Page<Transacao> findByCartaoNumero(String numero, Pageable paginacao);
}

