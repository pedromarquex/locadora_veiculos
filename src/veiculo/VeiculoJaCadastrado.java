package veiculo;

public class VeiculoJaCadastrado extends Exception{
	public VeiculoJaCadastrado() {
		super("Veiculo já cadastrado");
	}
}
