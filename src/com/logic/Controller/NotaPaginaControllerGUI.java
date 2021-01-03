package com.logic.Controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import com.logic.Model.Nota;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class NotaPaginaControllerGUI {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Nota> tabella;

    @FXML
    private TableColumn<Nota, String> noteColonna;

    @FXML
    private TextArea areaTesto;

    @FXML
    private Button inserisci;

    @FXML
    private Button carica;
    
    @FXML
    private Button homePage;
    
    @FXML
    private AnchorPane pane;
    
    private ObservableList<Nota> noteTotali;
    
    @FXML
    public void caricaHomePage(ActionEvent e) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/logic/View/HomePage.fxml"));
    	Parent root = loader.load();
    	pane.getChildren().setAll(root);  
    }

    @FXML
    void caricaNote(ActionEvent event) {
    	NoteController noteController = new NoteController();    	
    	noteTotali = noteController.caricaNota();		
    	tabella.setItems(noteTotali); 
    }

    @FXML
    void inserisciNota(ActionEvent event) {
    	NoteController inserisciDatiController = new NoteController();
    	inserisciDatiController.inserisciNota(areaTesto.getText());
    	this.caricaNote(null);
    }

    @FXML
    void initialize() {
        assert tabella != null : "fx:id=\"tabella\" was not injected: check your FXML file 'EsamiPagina.fxml'.";
        assert noteColonna != null : "fx:id=\"noteColonna\" was not injected: check your FXML file 'EsamiPagina.fxml'.";
        assert areaTesto != null : "fx:id=\"areaTesto\" was not injected: check your FXML file 'EsamiPagina.fxml'.";
        assert inserisci != null : "fx:id=\"inserisci\" was not injected: check your FXML file 'EsamiPagina.fxml'.";
        assert carica != null : "fx:id=\"carica\" was not injected: check your FXML file 'EsamiPagina.fxml'.";
        
      //set up the columns in the table
        noteColonna.setCellValueFactory(new PropertyValueFactory<Nota,String>("contenuto"));
        

    }
}
