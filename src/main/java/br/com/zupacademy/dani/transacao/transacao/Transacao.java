package br.com.zupacademy.dani.transacao.transacao;

import br.com.zupacademy.dani.transacao.cartao.Cartao;
import br.com.zupacademy.dani.transacao.estabelecimento.Estabelecimento;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private BigDecimal valor;
        @ManyToOne(cascade = CascadeType.PERSIST)
        private Estabelecimento estabelecimento;
        @ManyToOne(cascade = CascadeType.PERSIST)
        private Cartao cartao;
        private LocalDateTime efetivadaEm;

        @Deprecated
        public Transacao() {}

        public Transacao(
                         BigDecimal valor,
                         Estabelecimento estabelecimento,
                         Cartao cartao,
                         LocalDateTime efetivadaEm) {
            this.valor = valor;
            this.estabelecimento = estabelecimento;
            this.cartao = cartao;
            this.efetivadaEm = efetivadaEm;
        }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
