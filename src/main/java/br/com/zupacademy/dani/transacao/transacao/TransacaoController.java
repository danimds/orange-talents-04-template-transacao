package br.com.zupacademy.dani.transacao.transacao;

import br.com.zupacademy.dani.transacao.erros.ErroPadronizado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping("{numero}")
    public ResponseEntity<?> buscarTransacoes (@PathVariable String numero,
                                       @PageableDefault(sort = "efetivadaEm", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao){
        Page<Transacao> transacoes = transacaoRepository.findByCartaoNumero(numero, paginacao);
        if (transacoes.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErroPadronizado(List.of("Não foram encontradas transações para este cartão")));
        }
        return ResponseEntity.ok((transacoes.stream().map(TransacaoResponse::new).collect(Collectors.toList())));
    }
}

