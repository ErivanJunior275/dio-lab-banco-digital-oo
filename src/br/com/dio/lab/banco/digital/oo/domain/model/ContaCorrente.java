package br.com.dio.lab.banco.digital.oo.domain.model;

import br.com.dio.lab.banco.digital.oo.domain.constants.TipoConta;

public final class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        setTipoConta(TipoConta.CONTA_CORRENTE);
    }

    @Override
    public void imprimirExtrato() {
        LOGGER.info("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
    }

    public void consultarPropostasEmprestimoDisponivel() {

        String propostaEmprestimoDisponivel;

        if (saldo <= 1000) {
            propostaEmprestimoDisponivel = "Empréstimo não disponível";
        } else if (saldo > 1500 && saldo < 5000) {
            propostaEmprestimoDisponivel = "Empréstimo de 5 mil disponível";
        } else if (saldo > 5000 && saldo < 10000) {
            propostaEmprestimoDisponivel = "Empréstimo de 15 mil disponível";
        } else {
            propostaEmprestimoDisponivel = "Você está elegível para empréstimos de até 20 mil. " +
                    "Para valores superiores, fale com seu gerente!";
        }

        LOGGER.info(propostaEmprestimoDisponivel);
    }

}
