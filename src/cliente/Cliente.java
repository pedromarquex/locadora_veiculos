package cliente;

import java.util.ArrayList;

import veiculo.Veiculo;

public class Cliente {
	private String nome;
	private int cpf; // apenas numeros
	private String profissao;
	private ArrayList<Veiculo> veiculosAlugados = new ArrayList<Veiculo>();

	public Cliente(String nome, int cpf, String profissao) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setProfissao(profissao);
	}

	public void alugarVeiculo(Veiculo v) {
		this.veiculosAlugados.add(v);
		v.setAlugado(true);
	}
	
	public void devolverVeiculo(Veiculo v) {
		this.veiculosAlugados.remove(v);
		v.setAlugado(false);
	}

	public ArrayList<Veiculo> getVeiculosAlugados(){
		return this.veiculosAlugados;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
}
