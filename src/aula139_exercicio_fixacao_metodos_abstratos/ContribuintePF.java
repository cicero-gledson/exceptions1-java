package aula139_exercicio_fixacao_metodos_abstratos;

public class ContribuintePF extends Contribuinte {
	private double despesas_saude;

	public ContribuintePF(String nome, double renda, double despesas_saude) {
		super(nome, renda);
		this.despesas_saude = despesas_saude;
	}

	@Override
	public double impostoAPagar() {
		double impostoAPagar;
		if (this.getRenda() < 20000) {
			impostoAPagar = this.getRenda() * 0.15 - this.despesas_saude / 2;
		} else {
			impostoAPagar = this.getRenda() * 0.25 - this.despesas_saude / 2;
		}
		
		if (impostoAPagar < 0) return 0;
		
		return impostoAPagar;
	}
	
	


	

	
	
	
}
