package br.com.dio.lab.banco.digital.oo.domain;

public interface ICartao {

    void exibirDadosCartao();

    void realizarCompra(double valor, String descricao);

}
