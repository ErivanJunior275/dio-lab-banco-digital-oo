package br.com.dio.lab.banco.digital.oo;

import br.com.dio.lab.banco.digital.oo.domain.model.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    static {
        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));
        } catch (IOException e) {
            Logger.getAnonymousLogger().severe(e.getMessage());
        }
    }

    public static void main(String[] args) {

        Cliente venilton = new Cliente("Venilton", "584.738.820-91");

        Conta cc = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupanca(venilton);

        cc.depositar(100);
        cc.transferir(100, poupanca);
        ((ContaCorrente) cc).consultarPropostasEmprestimoDisponivel();

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        Banco bancoDigitalOO = new Banco();

        bancoDigitalOO.setContas(Arrays.asList(cc, poupanca));

        bancoDigitalOO.listarNomeClientes();
    }

}
