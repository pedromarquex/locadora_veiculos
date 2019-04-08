package aluguel;

import cliente.Cliente;
import veiculo.*;

public class Aluguel {
	private Cliente cliente;
	private Veiculo veiculo;
	private int dias;
	
	public Aluguel(Cliente cliente, Veiculo veiculo, int dias) {
		this.setCliente(cliente);
		this.setVeiculo(veiculo);
		this.setDias(dias);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}
}
