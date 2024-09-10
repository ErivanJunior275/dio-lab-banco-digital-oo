package br.com.dio.lab.banco.digital.oo.domain.model;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public final class Transacao {

    private LocalDateTime dataHora;

    private String descricao;

    private double valor;

    public Transacao(double valor, String descricao) {
        this.dataHora = LocalDateTime.now();
        this.valor = valor;
        this.descricao = descricao;
    }

}
