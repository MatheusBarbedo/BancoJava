package AtividadeC2;

public class ContaEspecial extends Conta {

	private double limite;
	private Conta conta;
	

	public ContaEspecial(String nome, String cpf){
		super(nome, cpf);		
		this.limite = limite; 
	}
	
	public double getLimite() {
		return limite;
	}


	public void setLimite(double limite) {
		this.limite = limite;
	}	
	
	public double saldo() {		
		double valorConta = conta.getValorConta();		
		return valorConta + limite;
	}

}
