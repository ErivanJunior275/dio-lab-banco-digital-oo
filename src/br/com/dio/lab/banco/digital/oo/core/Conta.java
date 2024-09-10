package br.com.dio.lab.banco.digital.oo.core;

import br.com.dio.lab.banco.digital.oo.domains.Cliente;
import br.com.dio.lab.banco.digital.oo.interfaces.IConta;
import lombok.Getter;

import java.util.logging.Logger;

@Getter
public abstract class Conta implements IConta {

    protected static final Logger LOGGER = Logger.getLogger("BancoDigitalOOLogger");

    private static final int AGENCIA_PADRAO = 1;

    private static int sequencial = 1;

    protected final int agencia;

    protected final int numero;

    protected double saldo;

    protected final Cliente cliente;

    protected Conta(final Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = sequencial++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
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

}
