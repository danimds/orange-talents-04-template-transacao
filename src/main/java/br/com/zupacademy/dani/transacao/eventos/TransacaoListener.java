package br.com.zupacademy.dani.transacao.eventos;

import br.com.zupacademy.dani.transacao.transacao.EventoDeTransacao;
import br.com.zupacademy.dani.transacao.transacao.Transacao;
import br.com.zupacademy.dani.transacao.transacao.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransacaoListener {

    private final Logger logger = LoggerFactory.getLogger(TransacaoListener.class);

    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(EventoDeTransacao mensagem) {
        try {
            logger.info("Nova transacao = {}", mensagem.toString());
            Transacao transacao = mensagem.toModel();
            transacaoRepository.save(transacao);
            logger.info("Nova transação salva com id={}", transacao.getId());

        } catch (Exception e) {
            logger.error("Não foi possivel salvar a transação");
            e.printStackTrace();
        }
    }
}
