package br.com.zup.transacao.event;

import br.com.zup.transacao.event.model.EventoDeTransacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoTransacaoRepository extends JpaRepository<EventoDeTransacao, String> {
}
