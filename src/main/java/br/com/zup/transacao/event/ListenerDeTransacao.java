package br.com.zup.transacao.event;

import br.com.zup.transacao.event.model.EventoDeTransacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    private EventoTransacaoRepository eventoTransacaoRepository;

    @Autowired
    public ListenerDeTransacao(EventoTransacaoRepository eventoTransacaoRepository) {
        this.eventoTransacaoRepository = eventoTransacaoRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(EventoDeTransacao eventoDeTransacao) {
        eventoTransacaoRepository.save(eventoDeTransacao);
        System.out.println(eventoDeTransacao);
    }

}
