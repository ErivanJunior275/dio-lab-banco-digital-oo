package br.com.dio.lab.banco.digital.oo.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public final class CartaoCredito extends Cartao {

    private double limite;

    private Fatura fatura;

    public CartaoCredito(String numeroCartao, String nomeTitular, String validade, double limite) {
        super(numeroCartao, nomeTitular, validade);
        this.limite = limite;
    }

    public void realizarCompra(double valor, String descricao) {

        if (valor <= (limite - fatura.getValorTotalFatura())) {
            fatura.adicionarTransacaoFatura(valor, descricao);
        } else {
            LOGGER.info("Limite insuficiente.");
        }

    }

    public void pagarFatura(double valor) {

        if (valor != fatura.getValorTotalFatura()) {
            return;
        }

        fatura.debitarValorFatura(valor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cartao cartao = (Cartao) o;
        return Objects.equals(numeroCartao, cartao.numeroCartao)
                && Objects.equals(nomeTitular, cartao.nomeTitular)
                && Objects.equals(validade, cartao.validade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroCartao, nomeTitular, validade, limite, fatura);
    }

    @Override
    public String toString() {
        return "CartaoCredito {" +
                "limite=" + limite +
                ", valorFatura=" + fatura +
                ", numeroCartao='" + numeroCartao + '\'' +
                ", nomeTitular='" + nomeTitular + '\'' +
                ", validade='" + validade + '\'' +
                '}';
    }

}
