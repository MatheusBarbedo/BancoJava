package AtividadeC2;

public interface Transacao {
	
	void deposito(double valor);	
	boolean saque(double valor);
	double saldo();
	boolean transferencia(double valor, Conta outraConta);
}
