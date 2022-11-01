package AtividadeC2;

public class Conta {

	private String nome;	
	private String cpf;
	private int numero;
	private double valorConta;
	
	public Conta(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.numero++;
		this.valorConta = 0;
	}
	
	public Conta(int numero) {
		this.nome = getNome();
		this.cpf = getCpf();
		this.valorConta = saldo();
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getNumero() {
		return numero;
	}

	public double getValorConta() {
		return valorConta;
	}
	public void setValorConta(double valorConta) {
		this.valorConta = valorConta;
	}
	
	public double saldo() {
		return valorConta;
	}
	
	public boolean transferencia(double valor, Conta outraConta) {
		double saldo = saldo();
		
		if(saldo < 0) {
			return false;
		}
		
		return true;
	}
	
	public void deposito(double valor) {
		setValorConta(valor);
	}
	
	public boolean saque(double valor) {
		double saldo = saldo();	
		
		if(saldo < 0) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		return "Conta [nome=" + nome + ", cpf=" + cpf + ", numero=" + numero + ", valorConta=" + valorConta + "]";
	}	
	
	
}
