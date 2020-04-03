package it.polito.tdp.lab04.model;

public class Studente {
	Integer matricola;
	String cognome;
	String nome;
	String CDS;
	public Studente(Integer matricola, String cognome, String nome, String CDS) {
		super();
		this.matricola = matricola;
		this.cognome = cognome;
		this.nome = nome;
		this.CDS = CDS;
	}
	public int getMatricola() {
		return matricola;
	}
	public String getCognome() {
		return cognome;
	}
	public String getNome() {
		return nome;
	}
	public String getCDS() {
		return CDS;
	}
	@Override
	public String toString() {
		return matricola + "	" + cognome + "		" + nome + "	" + CDS + "\n";
	}
	
	
	
}
