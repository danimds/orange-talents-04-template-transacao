package br.com.zupacademy.dani.transacao.cartao;

import br.com.zupacademy.dani.transacao.transacao.Transacao;

import javax.persistence.*;
import java.util.List;


@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String email;
    @OneToMany(mappedBy = "cartao")
    private List<Transacao> transacao;

    @Deprecated
    public Cartao() {
    }

    public Cartao(String numero, String email) {
        this.numero = numero;
        this.email = email;
    }

    public Cartao(CartaoResponse cartao) {
        this.email = cartao.getEmail();
        this.numero = cartao.getId();
    }

    public List<Transacao> getTransacao() {
        return transacao;
    }
}
