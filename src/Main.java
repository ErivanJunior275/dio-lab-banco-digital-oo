import br.com.dio.lab.banco.digital.oo.domains.Cliente;
import br.com.dio.lab.banco.digital.oo.domains.core.Conta;
import br.com.dio.lab.banco.digital.oo.domains.ContaCorrente;
import br.com.dio.lab.banco.digital.oo.domains.ContaPoupanca;

public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente("Venilton");

		Conta cc = new ContaCorrente(venilton);
		Conta poupanca = new ContaPoupanca(venilton);

		cc.depositar(100);
		cc.transferir(100, poupanca);

		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}

}
