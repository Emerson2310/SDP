package br.com.efx.sdp.modelo;

public class item {

	private final String cliente;
	private final String nomenclatura;
	private final int etapa;
	private int numOp;
	
	public item(String cliente, String nomenclatura, int etapa, int numOp) {
		this.cliente = cliente;
		this.nomenclatura = nomenclatura;
		this.etapa = etapa;
		this.numOp = numOp;
	}

	public int getNumOp() {
		return numOp;
	}

	public String getCliente() {
		return cliente;
	}

	public String getNomenclatura() {
		return nomenclatura;
	}

	public int getEtapa() {
		return etapa;
	}
	
	public String toString() {
		return "Item: " + getNomenclatura()+
				"\nEtapa: "+ getEtapa()+
			   "\nOrdem de produção: " + getNumOp()+
			   "\nCliente: " + getCliente();
	}
}
