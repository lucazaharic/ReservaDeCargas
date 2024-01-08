package br.fiap.util;

import static javax.swing.JOptionPane.*;

import br.fiap.Viagem.Viagem;
import br.fiap.carga.Carga;
import br.fiap.cliente.Cliente;
import static java.lang.Integer.parseInt;

public class Util {

	private Viagem viagem = new Viagem();
	
	// método para exibir o menu de opções
	public void menu() {
		int opcao;
		
		do {
			opcao = parseInt(showInputDialog(gerarMenu()));
			if(opcao < 1 || opcao > 6) {
				showMessageDialog(null, "Opção inválida");
			} else {
				switch(opcao) {
					case 1:
						reservar();
						break;
					case 3:
						visualizar();
						break;
				}
			}
		} while(opcao != 6);
	}
	
	private void visualizar() {
		showMessageDialog(null, viagem.getDados());		
	}

	private void reservar() {
		String destino, nomeCliente;
		int cnpj;
		
		cnpj = parseInt(showInputDialog("CNPJ do cliente"));
		nomeCliente = showInputDialog("Nome do cliente");
		destino = showInputDialog("Destino da carga");
		Cliente cliente = new Cliente(cnpj, nomeCliente);
		Carga carga = new Carga(destino, cliente);
		if(viagem.reservar(carga)) {
			showMessageDialog(null, "Carga reservada com sucesso");
		} else {
			showMessageDialog(null, "Problemas ao reservar carga");
		}		
	}

	// método para gerar o menu de opções
	private String gerarMenu() {
		String aux = "Sistema de Reserva de Cargas\n\n";
		aux += "1. Realizar reserva\n";
		aux += "2. Pesquisar reserva\n";
		aux += "3. Visualizar reservas\n";
		aux += "4. Capacidade reservada\n";
		aux += "5. Cancelar reserva\n";
		aux += "6. Encerrar programa\n";
		return aux;
	}
}
