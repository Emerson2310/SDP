package br.com.efx.sdp.modelo;

public class materiaPrima {

	private final String codMP;
	private final int lote;
	
	public materiaPrima(String codMP, int lote) {
		this.codMP = codMP;
		this.lote = lote;
	}

	public String getCodMP() {
		return codMP;
	}

	public int getLote() {
		return lote;
	}
	
	public String toString() {
		return "Materia prima: " + getCodMP()+
			   "\nLote: " + getLote();
	}
}
