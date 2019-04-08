package veiculo;

public class Caminhao extends Veiculo {
	private double capacidadeCarga = 0.0;

	public Caminhao(String marca, String modelo, int anoFabricacao, String placa, double valorDiaria,
			double valorAvaliado, double capacidadeCarga) {
		super(marca, modelo, anoFabricacao, placa, valorDiaria, valorAvaliado);
		this.setCapacidadeCarga(capacidadeCarga);
	}

	public double getCapacidadeCarga() {
		return capacidadeCarga;
	}

	public void setCapacidadeCarga(double capacidadeCarga) {
		this.capacidadeCarga = capacidadeCarga;
	}

	@Override
	public double valorSeguro() {
		return (this.getValorAvaliado() * 0.08) / 365;
	}
}
