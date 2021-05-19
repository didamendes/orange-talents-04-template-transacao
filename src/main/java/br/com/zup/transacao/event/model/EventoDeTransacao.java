package br.com.zup.transacao.event.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacao")
public class EventoDeTransacao {

    @Id
    private String id;

    private BigDecimal valor;

    private LocalDateTime efetivadaEm;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Cartao cartao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Estabelecimento estabelecimento;

    @Deprecated
    public EventoDeTransacao() {}

    public EventoDeTransacao(String id, BigDecimal valor, LocalDateTime efetivadaEm, Cartao cartao, Estabelecimento estabelecimento) {
        this.id = id;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.cartao = cartao;
        this.estabelecimento = estabelecimento;
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

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    @Override
    public String toString() {
        return "EventoDeTransacao{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", efetivadaEm=" + efetivadaEm +
                ", cartao=" + cartao +
                ", estabelecimento=" + estabelecimento +
                '}';
    }
}
