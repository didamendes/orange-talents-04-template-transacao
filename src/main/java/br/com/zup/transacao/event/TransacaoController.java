package br.com.zup.transacao.event;

import br.com.zup.transacao.event.dto.TransacaoResponse;
import br.com.zup.transacao.event.model.Cartao;
import br.com.zup.transacao.event.model.EventoDeTransacao;
import br.com.zup.transacao.event.repository.CartaoRepository;
import br.com.zup.transacao.event.repository.EventoTransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("transacoes")
public class TransacaoController {

    private CartaoRepository cartaoRepository;

    private EventoTransacaoRepository eventoTransacaoRepository;

    @Autowired
    public TransacaoController(CartaoRepository cartaoRepository, EventoTransacaoRepository eventoTransacaoRepository) {
        this.cartaoRepository = cartaoRepository;
        this.eventoTransacaoRepository = eventoTransacaoRepository;
    }

    @GetMapping(path = "/{numero}")
    public ResponseEntity<?> buscarPorCartao(@NotBlank @PathVariable String numero,
                                             @PageableDefault(direction = Sort.Direction.DESC, sort = { "efetivadaEm" }) Pageable pageable) {
        Optional<Cartao> cartao = cartaoRepository.findById(numero);

        if (cartao.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Page<EventoDeTransacao> eventos = eventoTransacaoRepository.findAllByCartao_Id(numero, pageable);

        return ResponseEntity.ok(TransacaoResponse.converter(eventos));
    }

}
