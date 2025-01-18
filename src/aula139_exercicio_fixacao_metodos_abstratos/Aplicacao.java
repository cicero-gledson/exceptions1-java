package aula139_exercicio_fixacao_metodos_abstratos;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Contribuinte> contribuintes = new ArrayList<>();
		
		System.out.print("Quantos contribuintes cadastrar? ");
		int n = sc.nextInt();
		System.out.println("");
		Contribuinte contribuinte; 
		for (int i=1; i<=n; i++) {
			System.out.println("DADOS DO CONTRIBUINTE #"+i);
			System.out.print("É um contribuinte PJ ou PF (f/j)? ");
			char tipo = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Nome: ");
			String nome= sc.nextLine();
			System.out.print("Renda anual: ");
			double renda = sc.nextDouble();
			if (Character.toLowerCase(tipo) == 'f') { 
				System.out.print("Despesas com saúde: ");
				double despesas = sc.nextDouble();
				contribuinte = new ContribuintePF(nome, renda, despesas);
			} else {
				System.out.print("Quantidade de funcionários: ");
				int qtdeFunc = sc.nextInt();
				contribuinte = new ContribuintePJ(nome, renda, qtdeFunc);
			}
			
			contribuintes.add(contribuinte);
	
		}
		
		System.out.println("\n===============================");
		System.out.println("TRIBUTOS PAGOS:");
		double totalImpostos = 0;
		for (Contribuinte con: contribuintes) {
			System.out.println(con.getNome() + " $ "+ String.format("%.2f", con.impostoAPagar()));
			totalImpostos += con.impostoAPagar();
		}
		System.out.println("Total: "+String.format("%.2f", totalImpostos));
		sc.close();
	
		
	}

}
