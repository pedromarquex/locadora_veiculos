package veiculo;

public class Carro extends Veiculo {
	
	private int categoria;
	
	public Carro(String marca, String modelo, int anoFabricacao, String placa, double valorDiaria,
			double valorAvaliado, int categoria) {
		super(marca, modelo, anoFabricacao, placa, valorDiaria, valorAvaliado);
		this.setCategoria(categoria);
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	@Override
	public double valorSeguro() {
		return (this.getValorAvaliado() * 0.03) / 365;
	}

}
