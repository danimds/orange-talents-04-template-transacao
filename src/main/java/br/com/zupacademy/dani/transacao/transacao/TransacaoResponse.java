package br.com.zupacademy.dani.transacao.transacao;

import br.com.zupacademy.dani.transacao.estabelecimento.EstabelecimentoResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoResponse estabelecimento;
    private LocalDateTime efetivadaEm;

    public TransacaoResponse(Transacao transacao) {
        this.valor = transacao.getValor();
        this.estabelecimento = new EstabelecimentoResponse(
                transacao.getEstabelecimento().getNome(),
                transacao.getEstabelecimento().getCidade(),
                transacao.getEstabelecimento().getEndereco());
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

}
