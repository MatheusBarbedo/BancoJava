package AtividadeC2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class ContaApp {
	static Scanner lerInteiro = new Scanner(System.in);
	static Scanner lerString = new Scanner(System.in);
	static ArrayList<Conta> conta = new ArrayList<Conta>();
	static int opcoes = 1;
	static int numeroConta;
	static int indice = 0;

	public static void main(String[] args) {
        
        System.out.println("Ola, Bem vindo ao Banco SemNome");
		System.out.printf("\nEscolha uma das opções [1], [2], [3], [4], [5], [6]: "
				+ "\n[1] Cadastrar conta"
				+ "\n[2] Saldo"
				+ "\n[3] Saque"
				+ "\n[4] Depósito"
				+ "\n[5] Transferência"
				+ "\n[6] Sair"
				+ "\n");
        do {
        	
        	System.out.print("\nEscolha uma das opções: ");
        	opcoes = lerInteiro.nextInt();		
	
        	switch (opcoes) {
        	case 1:
        		cadastrarConta(conta);
        		break;
    		
        	case 2:
        		System.out.print("\nInforme o numero da conta: ");
        		numeroConta = lerInteiro.nextInt();	
        		saldo(numeroConta);
    		break;
        		
        	case 3:
        		System.out.print("\nInforme o numero da conta: ");
        		numeroConta = lerInteiro.nextInt();	
        		saque(numeroConta);
        	break;
        	
        	case 4:
        		System.out.print("\nInforme o numero da conta: ");
        		numeroConta = lerInteiro.nextInt();	
        		deposito(numeroConta);
        	break;	
        		
        	case 5:
        		System.out.print("\nInforme o numero da conta: ");
        		numeroConta = lerInteiro.nextInt();	
        		transferencia(numeroConta);
        	break;	
        	
        	case 6:
        		System.out.println("Volte sempre.");
        		opcoes = 0;
        		break;
        		
        	default:
        		System.out.println("O número escolhido é inválido! escolha uma opção valida.");
        	}        	
        	
        } while (opcoes != 0);
	}      

	private static void cadastrarConta(ArrayList<Conta> conta) {	
		
		String nome, cpf;
		double limite;
		
		System.out.print("\nInforme o nome: ");
		nome = lerString.nextLine();
		
		System.out.print("\nInforme o cpf: ");
		cpf = lerString.nextLine();
		
		ContaEspecial contaEspecial = new ContaEspecial(nome, cpf);
		
		System.out.print("\nDefina um limite para a conta: ");
		limite = lerInteiro.nextInt();		
		contaEspecial.setLimite(limite);

		conta.add(new Conta(nome, cpf));
		
		System.out.println("Cadastro do usuario: " + nome + " foi feita com sucesso, Numero da conta: " + indice);
		indice++;
	}	
	
	private static void saldo(int numeroConta) {
		
		Conta contaRecuperada = conta.get(numeroConta);
		String nome = contaRecuperada.getNome();
		String cpf = contaRecuperada.getCpf();
		double saldo = contaRecuperada.getValorConta();
		
		System.out.println("Saldo do usuario " + nome + " portador do cpf " + cpf + " é de: " + saldo + " reais.");
	}
	
	private static void saque(int numeroConta) {
		
		Conta contaRecuperada = conta.get(numeroConta);
		double saldo = contaRecuperada.getValorConta();
		String nome = contaRecuperada.getNome();
		double valorSaque;
		
		System.out.print("\nInforme o valor do saque: ");
		valorSaque = lerInteiro.nextDouble();
		
		if(valorSaque < saldo) {
			saldo = saldo - valorSaque;
			contaRecuperada.setValorConta(saldo);
			System.out.println("\nSaque de " + valorSaque + " realizado com sucesso.");
			System.out.print("Saldo atual do cliente " + nome + " é de: " + saldo + " reais.");
		}
		
		else {
			System.out.println("Não é possivel realizar o saque da conta de " + nome + ", saldo insuficiente.");
			System.out.println("Saldo atual é de: " + saldo + " reais.");			
		}
	}
	
	private static void deposito(int numeroConta) {
		
		Conta contaRecuperada = conta.get(numeroConta);
		double saldo = contaRecuperada.getValorConta();
		String nome = contaRecuperada.getNome();
		double valorDeposito;
		
		System.out.print("\nInforme o valor do deposito: ");
		valorDeposito = lerInteiro.nextDouble();
		
		if(valorDeposito < 0) {
			System.out.println("\nNão é possivel depositar valores menores que zero.");
		}
		
		else {
			saldo = valorDeposito + saldo;
			contaRecuperada.setValorConta(saldo);
			
			System.out.println("\nDeposito de: " + valorDeposito + " realizado com sucesso.");
			System.out.println("O saldo atual do cliente " + nome + " é de: " + saldo + " reais.");		
		}
	}
	
	private static void transferencia(int numeroConta) {
		
		Scanner lerInt = new Scanner(System.in);
		
		Conta contaRecuperada = conta.get(numeroConta);
		String nomeContaRecuperada = contaRecuperada.getNome();
		
		System.out.print("\nInforme a conta que deseja transferir: ");
		int numeroContaDepositada = lerInt.nextInt();	
		
		Conta contaDepositada = conta.get(numeroContaDepositada);
		Integer contaDepositadaRecuperada = contaDepositada.getNumero(); 		
		
		if(numeroConta == numeroContaDepositada) {
			System.out.println("\nNão é possivel realizar uma transferencia para a mesma conta. ");
		}
		
		else if(contaDepositadaRecuperada != null) {
			
			double saldoContaDepositada = contaDepositada.getValorConta();
			double saldoContaTransferencia = contaRecuperada.getValorConta();
			
			System.out.print("\nInforme o valor que deseja transferir: ");
			int valorInformado = lerInteiro.nextInt();
			
			if(saldoContaTransferencia > valorInformado) {
				
				double saldo = saldoContaTransferencia - valorInformado;
				contaRecuperada.setValorConta(saldo);
				double saldoAtual = contaRecuperada.getValorConta();
				
				double saldoTransferido = saldoContaDepositada + valorInformado;
				contaDepositada.setValorConta(saldoTransferido);
				String nomeContaDepositada = contaDepositada.getNome();
				
				System.out.println("\nValor de " + valorInformado + " reais transferido com sucesso para conta de " + nomeContaDepositada + ". ");
				System.out.println("O saldo atual do cliente " + nomeContaRecuperada + " é de: " + saldoAtual + " reais após a transferencia.");
			}
			
			else {
				double saldoContaRecuperada = contaRecuperada.saldo();
				System.out.println("Não é possivel realizar o saque da conta de " + nomeContaRecuperada + ", saldo insuficiente.");
				System.out.println("Saldo atual é de: " + saldoContaRecuperada + " reais.");	
			}
		}
	}
}
