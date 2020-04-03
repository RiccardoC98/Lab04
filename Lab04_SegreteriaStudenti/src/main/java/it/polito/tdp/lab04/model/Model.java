package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	public Studente getStudenteByMatricola(Integer matricola) {
		StudenteDAO dao = new StudenteDAO();
		
		return dao.getStudenteByMatricola(matricola);
	}
	
	public Corso getCorso(String nome) {
		CorsoDAO dao = new CorsoDAO();
		
		return dao.getCorso(nome);
	}
	
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		CorsoDAO dao = new CorsoDAO();
		
		return dao.getStudentiIscrittiAlCorso(corso);
	}
	 
	public List<Corso> getCorsiAiQualiEIscritto(Studente studente) {
		CorsoDAO dao = new CorsoDAO();
		
		return dao.getCorsiAiQualiEIscritto(studente);
	}
	
	public boolean CercaSeIscritto(Studente s, Corso c) {
		StudenteDAO dao = new StudenteDAO();
		
		return dao.CercaSeIscritto(s, c);
	}
	
}
