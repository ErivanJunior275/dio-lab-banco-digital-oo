package br.com.dio.lab.banco.digital.oo.domain.model;

import br.com.dio.lab.banco.digital.oo.domain.ICartao;
import br.com.dio.lab.banco.digital.oo.domain.IConta;
import br.com.dio.lab.banco.digital.oo.domain.constants.TipoConta;
import lombok.Getter;
import lombok.Setter;

import java.util.logging.Logger;

@Getter
public abstract class Conta implements IConta {

    protected static final Logger LOGGER = Logger.getLogger("BancoDigitalOOLogger");

    private static final int AGENCIA_PADRAO = 1;

    private static int sequencial = 1;

    protected final Cliente cliente;

    @Setter
    private TipoConta tipoConta;

    protected final int agencia;

    protected final int numero;

    protected double saldo;

    protected ICartao cartao;

    protected Conta(final Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = sequencial++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if (this.saldo < valor) {
            LOGGER.info("Saldo insuficiente! Não foi possível realizar o saque.");
            return;
        }

        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0d) {
            return;
        }

        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if (this.saldo < valor) {
            LOGGER.info("Saldo insuficiente! Não foi possível realizar a transferência.");
            return;
        }

        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfosComuns() {
        String titularMensagem = String.format("Titular: %s", this.cliente.getNome());
        String agenciaMensagem = String.format("Agencia: %d", this.agencia);
        String numeroMensagem = String.format("Numero: %d", this.numero);
        String saldoMensagem = String.format("Saldo: %.2f%n", this.saldo);

        LOGGER.info(titularMensagem);
        LOGGER.info(agenciaMensagem);
        LOGGER.info(numeroMensagem);
        LOGGER.info(saldoMensagem);
    }

    @Override
    public String toString() {
        return "Conta {" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                ", cliente=" + cliente +
                ", tipoConta=" + tipoConta +
                '}';
    }

}
