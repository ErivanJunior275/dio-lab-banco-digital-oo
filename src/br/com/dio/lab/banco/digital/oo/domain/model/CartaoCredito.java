package br.com.dio.lab.banco.digital.oo.domain.model;

import lombok.Getter;
import lombok.Setter;

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
