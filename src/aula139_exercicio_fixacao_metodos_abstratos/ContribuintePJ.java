package aula139_exercicio_fixacao_metodos_abstratos;

public class ContribuintePJ extends Contribuinte {
	private int qtdeFunc;
	

	public ContribuintePJ(String nome, double renda, int qtdeFunc) {
		super(nome, renda);
		this.qtdeFunc = qtdeFunc;
	}


	@Override
	public double impostoAPagar() {
		if (this.qtdeFunc < 10) return this.getRenda() * 0.16;
		return this.getRenda() * 0.14;
	}

}
