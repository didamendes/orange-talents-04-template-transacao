package br.com.zup.transacao.event.repository;

import br.com.zup.transacao.event.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, String> {
}
