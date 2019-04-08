package veiculo;

public class Moto extends Veiculo {
	
	private int cc = 0; // cilindradass
	
	public Moto(String marca, String modelo, int anoFabricacao, String placa, double valorDiaria,
			double valorAvaliado, int cc) {
		super(marca, modelo, anoFabricacao, placa, valorDiaria, valorAvaliado);
		this.setCc(cc);
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	@Override
	public double valorSeguro() {
		return (this.getValorAvaliado() * 0.11) / 365;
	}

}
