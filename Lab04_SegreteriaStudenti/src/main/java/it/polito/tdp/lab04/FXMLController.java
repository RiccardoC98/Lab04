package it.polito.tdp.lab04;

import java.util.*;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;
import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;	
	
    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Button btnCercaIscritti;

    @FXML
    private Button btnIscritto;
    
    @FXML
    private TextField txtMatricola;

    @FXML
    private Button btnComplete;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnIscrivi;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private TextArea txtArea;

    @FXML
    private Button btnResert;

    @FXML
    void doCercaCorsi(ActionEvent event) { // ai quali uno studente è iscritto
    	txtArea.clear();
    	Integer matricola = 0;
 
    	try {
    		matricola = Integer.parseInt(txtMatricola.getText());
    	} catch (NumberFormatException nfe) {
    		txtArea.appendText("Inserire una matricola valida!\n");
    	}
    	
    	Studente s = this.model.getStudenteByMatricola(matricola);
    	
    	if (s != null) {
    		List<Corso> corsi = new LinkedList<Corso>( this.model.getCorsiAiQualiEIscritto(s) );
    		for (Corso c : corsi) {
    			txtArea.appendText(c.toString());
    		}
    	} else {
    		txtArea.appendText("Inserire una matricola valida!\n");
    	}
    }

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {
    	txtArea.clear();
    	String nome = choiceBox.getSelectionModel().getSelectedItem();
    	if (nome != "Scegliere corso") {
    		List<Studente> studenti = new LinkedList<Studente> ( model.getStudentiIscrittiAlCorso( model.getCorso(nome)) );
    		for (Studente s : studenti) {
    			txtArea.appendText(s.toString());
    		}
    	} else {
    		txtArea.appendText("Selezionare un corso!\n");
    	}
    	
    	
    }

    @FXML
    void doCercaSeIscritto(ActionEvent event) {
    	txtArea.clear();
    	Integer matricola = 0;
 
    	try {
    		matricola = Integer.parseInt(txtMatricola.getText());
    	} catch (NumberFormatException nfe) {
    		txtArea.appendText("Inserire una matricola valida!\n");
    	}
    	
    	Studente s = this.model.getStudenteByMatricola(matricola);
    	
    	String nome = choiceBox.getSelectionModel().getSelectedItem();
    	if (nome != "Scegliere corso") {
    		boolean res = this.model.CercaSeIscritto(s, model.getCorso(nome));
    		if (res) {
    			txtArea.appendText("Lo studente è iscritto al corso!\n");
    		} else {
    			txtArea.appendText("Lo studente NON è iscritto al corso!\n");
    		}
    	} else {
    		txtArea.appendText("Selezionare un corso!\n");
    	}
    	
    }
    
    @FXML
    void doComplete(ActionEvent event) {
    	txtArea.clear();
    	Integer matricola = 0;
 
    	try {
    		matricola = Integer.parseInt(txtMatricola.getText());
    	} catch (NumberFormatException nfe) {
    		txtArea.appendText("Inserire una matricola valida!\n");
    	}
    	
    	Studente s = this.model.getStudenteByMatricola(matricola);
    	
    	if ( s != null) {
    		txtNome.setText(s.getNome());
        	txtCognome.setText(s.getCognome());
    	} else {
    		txtArea.clear();
    		txtArea.appendText("Inserire una matricola valida!\n");
    	}
    	
    	
    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtArea.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	txtMatricola.clear();
    }

    @FXML
    void initialize() {
    	
        CorsoDAO cDAO = new CorsoDAO();
        List<Corso> corsi = new LinkedList<Corso> ( cDAO.getTuttiICorsi() );
        ObservableList<String> list = FXCollections.observableArrayList();
        
        list.add("Scegliere corso");	// creating list containing all options
        for (Corso c : corsi) {
        	list.add(c.getNome());
        }
        
        
        //populate the Choicebox;  
        choiceBox.setItems(list);
        choiceBox.setValue("Scegliere corso");
    }

	public void setModel(Model model) {
		this.model = model;
	}
    
}
