package br.com.dio.lab.banco.digital.oo.domain.model;

import lombok.Data;

import java.util.List;
import java.util.logging.Logger;

@Data
public class Banco {

    private static final Logger LOGGER = Logger.getLogger("BancoDigitalOOLogger");

    private static final String NOME = "Banco Digital Orientado à Objeto";

    private List<Conta> contas;

    public void listarNomeClientes() {
        LOGGER.info("=== Lista de clientes ===");
        contas.stream().map(Conta::getCliente).map(Cliente::getNome).distinct().forEach(LOGGER::info);
    }

}
