package br.com.dio.lab.banco.digital.oo.domain.model;

import br.com.dio.lab.banco.digital.oo.domain.ICartao;
import lombok.Data;

import java.util.Objects;
import java.util.logging.Logger;

@Data
public abstract class Cartao implements ICartao {

    protected static final Logger LOGGER = Logger.getLogger("BancoDigitalOOLogger");

    protected final String numeroCartao;

    protected final String nomeTitular;

    protected String validade;

    protected Cartao(String numeroCartao, String nomeTitular, String validade) {
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.validade = validade;
    }

    @Override
    public void exibirDadosCartao() {
        String dadosCartao = toString();

        LOGGER.info(dadosCartao);
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
        return Objects.hash(numeroCartao, nomeTitular, validade);
    }

}
