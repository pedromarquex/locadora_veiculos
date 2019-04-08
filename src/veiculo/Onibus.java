package veiculo;

public class Onibus extends Veiculo {

	private int capacidade = 0;
	
	public Onibus(String marca, String modelo, int anoFabricacao, String placa, double valorDiaria,
			double valorAvaliado, int capacidade) {
		super(marca, modelo, anoFabricacao, placa, valorDiaria, valorAvaliado);
		this.setCapacidade(capacidade);
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	@Override
	public double valorSeguro() {
		return (this.getValorAvaliado() * 0.20) / 365;
	}

}
