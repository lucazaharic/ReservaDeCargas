package br.fiap.Viagem;

import br.fiap.carga.Carga;

public class Viagem {
	private int capacidade;
	private int index;
	private Carga[] carga;
	
	public Viagem() {
		this.capacidade = 10000;
		this.index = 0;
		this.carga = new Carga[20];
	}
	
	// método para reservar uma carga no navio
	public boolean reservar(Carga carga) {
		if(permitidoReservar(carga.getPeso())) {
			this.carga[index] = carga;
			index++;
			return true;
		}
		return false;
	}
	
	// método para retornar o total de peso reservado até o momento
	public double capacidadeReservada() {
		double total = 0;
		for(int i = 0; i < index; i++) {
			total += carga[i].getPeso();
		}
		return total;
	}
	
	// método para verificar se é possível fazer uma nova reserva
	public boolean permitidoReservar(double peso) {
		if(index < carga.length && capacidadeReservada() + peso <= capacidade) {
			return true;
		}
		return false;
	}
	
	// método para retornar os dados de todas as cargas reservadas
	public String getDados() {
		String aux = "";
		for(int i = 0; i < index; i++) {
			aux += carga[i].getDados() + "\n";
		}
		return aux;
	}
	
}
