package br.com.dio.lab.banco.digital.oo.domains;

import br.com.dio.lab.banco.digital.oo.domains.core.Conta;

public final class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato br.com.dio.lab.banco.digital.oo.domains.core.Conta Corrente ===");
        super.imprimirInfosComuns();
    }

}
