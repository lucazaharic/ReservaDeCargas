package br.fiap.cliente;

public class Cliente {
	private int cnpj;
	private String cliente;
	
	public Cliente(int cnpj, String cliente) {
		super();
		this.cnpj = cnpj;
		this.cliente = cliente;
	}

	// método para retornar os dados do cliente
	public String getDados() {
		String aux = "";
		aux += "CNPJ: " + cnpj + "\n";
		aux += "Cliente: " + cliente + "\n";
		return aux;
	}
	
	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}	
}

