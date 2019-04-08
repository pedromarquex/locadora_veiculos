package locadora;

import veiculo.*;
import aluguel.*;
import cliente.*;
import java.util.ArrayList;

class SistemaLocadora implements Locadora {

	ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();

	@Override
	public void inserir(Veiculo v) throws VeiculoJaCadastrado {
		try {
			pesquisar(v.getPlaca());
		} catch (VeiculoNaoCadastrado e) {
			veiculos.add(v);
		}
	}

	@Override
	public void inserir(Cliente c) throws ClienteJaCadastrado {
		try {
			pesquisarCliente(c.getCpf());
		} catch (ClienteNaoCadastrado e) {
			clientes.add(c);
		}
	}

	@Override
	public Veiculo pesquisar(String placa) throws VeiculoNaoCadastrado {
		if (veiculos.isEmpty()) {
			throw new VeiculoNaoCadastrado();
		} else {
			for (Veiculo v : veiculos) {
				if (v.getPlaca().equals(placa)) {
					return v;
				}
			}
			throw new VeiculoNaoCadastrado();
		}
	}

	@Override
	public ArrayList<Veiculo> pesquisarMoto(int cilindrada) {
		ArrayList<Veiculo> motos = new ArrayList<Veiculo>();
		if (veiculos.isEmpty()) {
			return motos;
		} else {
			for (Veiculo veiculo : veiculos) {
				if (veiculo instanceof Moto && ((Moto) veiculo).getCc() == cilindrada) {
					motos.add(veiculo);
				} else if (veiculo instanceof Moto && cilindrada == -1) {
					motos.add(veiculo);
				}
			}
		}
		return motos;
	}

	@Override
	public ArrayList<Veiculo> pesquisarCarro(int tipoCarro) {
		ArrayList<Veiculo> carros = new ArrayList<Veiculo>();
		if (veiculos.isEmpty()) {
			return carros;
		} else {
			for (Veiculo veiculo : veiculos) {
				if (veiculo instanceof Carro && ((Carro) veiculo).getCategoria() == tipoCarro) {
					carros.add(veiculo);
				} else if (veiculo instanceof Carro && tipoCarro == -1) {
					carros.add(veiculo);
				}
			}
		}
		return carros;
	}

	@Override
	public ArrayList<Veiculo> pesquisarCaminhao(int carga) {
		ArrayList<Veiculo> caminhoes = new ArrayList<Veiculo>();
		if (veiculos.isEmpty()) {
			return caminhoes;
		} else {
			for (Veiculo veiculo : veiculos) {
				if (veiculo instanceof Caminhao && ((Caminhao) veiculo).getCapacidadeCarga() == carga) {
					caminhoes.add(veiculo);
				} else if (veiculo instanceof Caminhao && carga == -1) {
					caminhoes.add(veiculo);
				}
			}
		}
		return caminhoes;
	}

	@Override
	public ArrayList<Veiculo> pesquisarOnibus(int passageiros) {
		ArrayList<Veiculo> onibus = new ArrayList<Veiculo>();
		if (veiculos.isEmpty()) {
			return onibus;
		} else {
			for (Veiculo veiculo : veiculos) {
				if (veiculo instanceof Onibus && ((Onibus) veiculo).getCapacidade() == passageiros) {
					onibus.add(veiculo);
				} else if (veiculo instanceof Onibus && passageiros == -1) {
					onibus.add(veiculo);
				}
			}
		}
		return onibus;
	}

	@Override
	public double calcularAluguel(String placa, int dias) throws VeiculoNaoCadastrado {
		try {
			Veiculo v = pesquisar(placa);
			return v.valorAluguel(dias);
		} catch (VeiculoNaoCadastrado e) {
			throw e;
		}
	}

	@Override
	public void registrarAluguel(String placa, int dias, Cliente c)
			throws VeiculoNaoCadastrado, VeiculoAlugado, ClienteNaoCadastrado {
		try {
			Veiculo v = pesquisar(placa);
			if (v.isAlugado() == true) {
				throw new VeiculoAlugado();
			} else {
				pesquisarCliente(c.getCpf());
				c.alugarVeiculo(v);
				Aluguel a = new Aluguel(c, v, dias);
				alugueis.add(a);
			}
		} catch (VeiculoNaoCadastrado e) {
			throw e;
		} catch (ClienteNaoCadastrado e) {
			throw e;
		}

	}

	@Override
	public void registrarDevolucao(String placa, Cliente c)
			throws VeiculoNaoCadastrado, VeiculoNaoAlugado, ClienteNaoCadastrado {
		try {
			Veiculo v = pesquisar(placa);
			if (v.isAlugado() == false) {
				throw new VeiculoNaoAlugado();
			} else {
				pesquisarCliente(c.getCpf());
				c.devolverVeiculo(v);
				for (Aluguel aluguel : alugueis) {
					if (aluguel.getVeiculo().equals(v)) {
						alugueis.remove(aluguel);
					}
				}
			}
		} catch (VeiculoNaoCadastrado e) {
			throw e;
		} catch (ClienteNaoCadastrado e) {
			throw e;
		}

	}

	@Override
	public void depreciarVeiculos(int tipo, double taxaDepreciacao) {

		if (tipo == 0) {
			for (Veiculo veiculo : veiculos) {
				veiculo.atualizarValorBem(taxaDepreciacao);
			}
		} else if (tipo == 1) {
			ArrayList<Veiculo> v = pesquisarMoto(-1);
			for (Veiculo veiculo : v) {
				veiculo.atualizarValorBem(taxaDepreciacao);
			}

		} else if (tipo == 2) {
			ArrayList<Veiculo> v = pesquisarCarro(-1);
			for (Veiculo veiculo : v) {
				veiculo.atualizarValorBem(taxaDepreciacao);
			}
		} else if (tipo == 4) {
			ArrayList<Veiculo> v = pesquisarOnibus(-1);
			for (Veiculo veiculo : v) {
				veiculo.atualizarValorBem(taxaDepreciacao);
			}
		} else if (tipo == 3) {
			ArrayList<Veiculo> v = pesquisarCaminhao(-1);
			for (Veiculo veiculo : v) {
				veiculo.atualizarValorBem(taxaDepreciacao);
			}
		}
	}

	@Override
	public void aumentarDiaria(int tipo, double taxaAumento) {
		if (tipo == 1) {
			ArrayList<Veiculo> v = pesquisarMoto(-1);
			for (Veiculo veiculo : v) {
				veiculo.atualizarValorDiaria(taxaAumento);
			}

		} else if (tipo == 2) {
			ArrayList<Veiculo> v = pesquisarCarro(-1);
			for (Veiculo veiculo : v) {
				veiculo.atualizarValorDiaria(taxaAumento);
			}
		} else if (tipo == 3) {
			ArrayList<Veiculo> v = pesquisarOnibus(-1);
			for (Veiculo veiculo : v) {
				veiculo.atualizarValorDiaria(taxaAumento);
			}
		} else if (tipo == 4) {
			ArrayList<Veiculo> v = pesquisarCaminhao(-1);
			for (Veiculo veiculo : v) {
				veiculo.atualizarValorDiaria(taxaAumento);
			}
		}

	}

	@Override
	public double faturamentoTotal(int tipo) {
		double faturamento = 0;
		if(tipo == 0) {
			for (Aluguel aluguel : alugueis) {
				try {
					faturamento += calcularAluguel(aluguel.getVeiculo().getPlaca(), aluguel.getDias());
				} catch (VeiculoNaoCadastrado e) {
					e.printStackTrace();
				}
			}
		} else if(tipo == 1) {
			for (Aluguel aluguel : alugueis) {
				if (aluguel.getVeiculo() instanceof Moto) {
					try {
						faturamento += calcularAluguel(aluguel.getVeiculo().getPlaca(), aluguel.getDias());
					} catch (VeiculoNaoCadastrado e) {
						e.printStackTrace();
					}
				}
			}
			
		} else if (tipo == 2) {
			for (Aluguel aluguel : alugueis) {
				if (aluguel.getVeiculo() instanceof Carro) {
					try {
						faturamento += calcularAluguel(aluguel.getVeiculo().getPlaca(), aluguel.getDias());
					} catch (VeiculoNaoCadastrado e) {
						e.printStackTrace();
					}
				}
			}
		} else if (tipo == 3) {
			for (Aluguel aluguel : alugueis) {
				if (aluguel.getVeiculo() instanceof Caminhao) {
					try {
						faturamento += calcularAluguel(aluguel.getVeiculo().getPlaca(), aluguel.getDias());
					} catch (VeiculoNaoCadastrado e) {
						e.printStackTrace();
					}
				}
			}
		} else if (tipo == 4) {
			for (Aluguel aluguel : alugueis) {
				if (aluguel.getVeiculo() instanceof Onibus) {
					try {
						faturamento += calcularAluguel(aluguel.getVeiculo().getPlaca(), aluguel.getDias());
					} catch (VeiculoNaoCadastrado e) {
						e.printStackTrace();
					}
				}
			}
		}
		return faturamento;
	}

	@Override
	public int quantidadeTotalDeDiarias(int tipo) {
		int diarias = 0;
		if(tipo == 0) {
			for (Aluguel aluguel : alugueis) {
				diarias += aluguel.getDias();
			}
		} else if(tipo == 1) {
			for (Aluguel aluguel : alugueis) {
				if (aluguel.getVeiculo() instanceof Moto) {
					diarias += aluguel.getDias();
				}
			}
			
		} else if (tipo == 2) {
			for (Aluguel aluguel : alugueis) {
				if (aluguel.getVeiculo() instanceof Carro) {
					diarias += aluguel.getDias();
				}
			}
		} else if (tipo == 3) {
			for (Aluguel aluguel : alugueis) {
				if (aluguel.getVeiculo() instanceof Caminhao) {
					diarias += aluguel.getDias();
				}
			}
		} else if (tipo == 4) {
			for (Aluguel aluguel : alugueis) {
				if (aluguel.getVeiculo() instanceof Onibus) {
					diarias += aluguel.getDias();
				}
			}
		}
		return diarias;
	}

	public Cliente pesquisarCliente(int cpf) throws ClienteNaoCadastrado {
		if (clientes.isEmpty()) {
			throw new ClienteNaoCadastrado();
		} else {
			for (Cliente cliente : clientes) {
				if (cliente.getCpf() == cpf) {
					return cliente;
				}
			}
			throw new ClienteNaoCadastrado();
		}
	}

}