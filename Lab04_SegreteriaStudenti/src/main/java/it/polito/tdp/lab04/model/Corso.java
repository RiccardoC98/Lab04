package it.polito.tdp.lab04.model;

public class Corso {
	String codins;
	int numeroCrediti;
	String nome;
	int periodoDidattico;
	
	public Corso(String codins, int numeroCrediti, String nome, int periodoDidattico) {
		super();
		this.codins = codins;
		this.numeroCrediti = numeroCrediti;
		this.nome = nome;
		this.periodoDidattico = periodoDidattico;
	}

	public void setCodins(String codins) {
		this.codins = codins;
	}

	public void setNumeroCrediti(int numeroCrediti) {
		this.numeroCrediti = numeroCrediti;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPeriodoDidattico(int periodoDidattico) {
		this.periodoDidattico = periodoDidattico;
	}

	public String getCodins() {
		return codins;
	}

	public int getNumeroCrediti() {
		return numeroCrediti;
	}

	public String getNome() {
		return nome;
	}

	public int getPeriodoDidattico() {
		return periodoDidattico;
	}

	@Override
	public String toString() {
		return "Corso [codins=" + codins + ", numeroCrediti=" + numeroCrediti + ", nome=" + nome + ", periodoDidattico="
				+ periodoDidattico + "]\n";
	}
	
	
	
}
