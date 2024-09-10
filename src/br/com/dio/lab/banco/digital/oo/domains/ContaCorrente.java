package br.com.dio.lab.banco.digital.oo.domains;

import br.com.dio.lab.banco.digital.oo.core.Conta;

public final class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        LOGGER.info("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
    }

}
