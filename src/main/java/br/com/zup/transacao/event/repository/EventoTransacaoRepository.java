package br.com.zup.transacao.event.repository;

import br.com.zup.transacao.event.model.EventoDeTransacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoTransacaoRepository extends JpaRepository<EventoDeTransacao, String> {

    Page<EventoDeTransacao> findAllByCartao_Id(String id, Pageable pageable);

}
