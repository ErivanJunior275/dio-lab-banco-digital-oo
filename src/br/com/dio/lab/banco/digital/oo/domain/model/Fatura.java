package br.com.dio.lab.banco.digital.oo.domain.model;

import br.com.dio.lab.banco.digital.oo.domain.constants.EstadoFaturaEnum;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class Fatura {

    @Getter
    private final List<Transacao> transacoes;

    private Double valorTotal;

    @Getter
    private EstadoFaturaEnum estadoFatura;

    public Fatura() {
        this.transacoes = new ArrayList<>();
        this.valorTotal = 0.00d;
    }

    public void adicionarTransacaoFatura(double valor, String descricao) {
        Transacao transacao = new Transacao(valor, descricao);

        transacoes.add(transacao);
        this.estadoFatura = EstadoFaturaEnum.EM_ABERTO;
    }

    public void debitarValorFatura(double valor) {
        this.valorTotal -= valor;
        this.estadoFatura = EstadoFaturaEnum.PAGO;
    }

    public Double getValorTotalFatura() {
        atualizarValorTotalFatura();

        return this.valorTotal;
    }

    private void atualizarValorTotalFatura() {
        Optional<Double> valorTotalFatura = this.transacoes.stream().map(Transacao::getValor).reduce(Double::sum);

        this.valorTotal = valorTotalFatura.orElseGet(() -> 0.00d);
    }

}
