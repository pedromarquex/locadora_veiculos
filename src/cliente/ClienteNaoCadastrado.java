package cliente;

public class ClienteNaoCadastrado extends Exception {
	public ClienteNaoCadastrado() {
		super("Cliente não cadastrado");
	}
}
