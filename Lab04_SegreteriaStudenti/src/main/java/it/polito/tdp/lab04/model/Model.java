package it.polito.tdp.lab04.model;

import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	public Studente getStudenteByMatricola(Integer matricola) {
		StudenteDAO dao = new StudenteDAO();
		
		return dao.getStudenteByMatricola(matricola);
	}
	
}
