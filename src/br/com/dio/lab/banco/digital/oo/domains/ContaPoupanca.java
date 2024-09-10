package br.com.dio.lab.banco.digital.oo.domains;

import br.com.dio.lab.banco.digital.oo.core.Conta;

public final class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        LOGGER.info("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
    }

}
