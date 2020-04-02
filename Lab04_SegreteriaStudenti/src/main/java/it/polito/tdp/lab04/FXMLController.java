package it.polito.tdp.lab04;

import java.util.*;

import it.polito.tdp.lab04.DAO.CorsoDAO;
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
    void doCercaCorsi(ActionEvent event) {

    }

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {

    }

    @FXML
    void doComplete(ActionEvent event) {
    	Integer matricola = Integer.parseInt(txtMatricola.getText());    
    	System.out.println(matricola);
    	Studente s = model.getStudenteByMatricola(matricola);

    	txtNome.setText(s.getNome());
    	txtCognome.setText(s.getCognome());
    	
    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

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
    
}
