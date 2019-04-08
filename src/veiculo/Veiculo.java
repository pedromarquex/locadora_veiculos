package veiculo;

public abstract class Veiculo {
	private String marca = ""; // marca
	private String modelo = ""; // modelo
	private int anoFabricacao = 0; // ano de fabricação
	private String placa = ""; // numero da placa
	private double valorDiaria = 0.0; // valor da diária
	private double valorAvaliado = 0.0; // valor avaliado do bem
	private boolean alugado = false; // indicador de alugado

	public Veiculo(String marca, String modelo, int anoFabricacao, String placa, double valorDiaria,
			double valorAvaliado) {
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setAnoFabricacao(anoFabricacao);
		this.setPlaca(placa);
		this.setValorDiaria(valorDiaria);
		this.setValorAvaliado(valorAvaliado);
	}

	public abstract double valorSeguro();

	public double valorAluguel(int dias) {
		return ( this.getValorDiaria() + this.valorSeguro() ) * dias;
	}

	public void atualizarValorDiaria(double percent) {
		this.setValorDiaria( this.getValorDiaria() + percent / 100 );
	}

	public void atualizarValorBem(double percent) {
		this.setValorAvaliado( this.getValorAvaliado() + percent / 100 );
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public double getValorAvaliado() {
		return valorAvaliado;
	}

	public void setValorAvaliado(double valorAvaliado) {
		this.valorAvaliado = valorAvaliado;
	}

	public boolean isAlugado() {
		return alugado;
	}

	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}
}