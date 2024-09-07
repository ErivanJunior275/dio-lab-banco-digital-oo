package br.com.dio.lab.banco.digital.oo.domains;

import br.com.dio.lab.banco.digital.oo.domains.core.Conta;

public final class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato br.com.dio.lab.banco.digital.oo.domains.core.Conta Poupança ===");
        super.imprimirInfosComuns();
    }

}
