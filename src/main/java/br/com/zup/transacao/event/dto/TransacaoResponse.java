package br.com.zup.transacao.event.dto;

import br.com.zup.transacao.event.model.EventoDeTransacao;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    private String id;

    private BigDecimal valor;

    private LocalDateTime efetivadaEm;

    private String numeroCartao;

    private String nomeEstabelicimento;

    public TransacaoResponse(EventoDeTransacao eventoDeTransacao) {
        this.id = eventoDeTransacao.getId();
        this.valor = eventoDeTransacao.getValor();
        this.efetivadaEm = eventoDeTransacao.getEfetivadaEm();
        this.numeroCartao = eventoDeTransacao.getCartao().getId();
        this.nomeEstabelicimento = eventoDeTransacao.getEstabelecimento().getNome();
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public String getNomeEstabelicimento() {
        return nomeEstabelicimento;
    }

    public static Page<TransacaoResponse> converter(Page<EventoDeTransacao> eventos) {
        return eventos.map(TransacaoResponse::new);
    }

}
