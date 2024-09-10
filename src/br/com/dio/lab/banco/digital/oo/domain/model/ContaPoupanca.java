package br.com.dio.lab.banco.digital.oo.domain.model;

import br.com.dio.lab.banco.digital.oo.domain.constants.TipoConta;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.LongStream;

public final class ContaPoupanca extends Conta {

    private static final double TAXA_RENDIMENTO = 0.01;

    private final LocalDateTime dataCriacao;

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        setTipoConta(TipoConta.CONTA_POUPANCA);
        this.dataCriacao = LocalDateTime.now();
        this.render();
    }

    @Override
    public void imprimirExtrato() {
        LOGGER.info("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
    }

    private void render() {

        long mesesPassados = ChronoUnit.MONTHS.between(dataCriacao, LocalDateTime.now());

        String nome = this.cliente.getNome();

        LongStream.range(0, mesesPassados).forEach(mes -> {
            String mensagemRendimento = String.format("Rendimento realizado na conta poupança de " +
                    "%s referente ao mês %d. Novo saldo: %.2f", nome, ++mes, saldo);

            this.saldo += saldo * TAXA_RENDIMENTO;

            LOGGER.info(mensagemRendimento);
        });

    }

}
