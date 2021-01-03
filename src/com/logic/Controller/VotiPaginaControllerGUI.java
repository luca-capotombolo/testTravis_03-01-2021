package com.logic.Controller;



import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import com.logic.Model.EsameDato;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


public class VotiPaginaControllerGUI {	
	
	@FXML
	private AnchorPane pane;
	
	@FXML
	private TextField esameCampo;
	
	@FXML
	private TextField votoCampo;
	
	@FXML
	private Button insert;
	
	@FXML
	private Button load;
	
	@FXML
	private TableColumn<EsameDato, String> colonnaEsame;
	
	@FXML
	private TableColumn<EsameDato, String> colonnaVoto;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<EsameDato> tabella;

   @FXML
    private Button homePage;
   
    private ObservableList<EsameDato> esamiDati;

    @FXML
    void caricaHomePage(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/logic/View/HomePage.fxml"));
    	Parent root = loader.load();
    	pane.getChildren().setAll(root);    	
    }
    
    @FXML
    void caricaVoti(ActionEvent e)  {
    	
    	CaricatVotiController caricatVotiController = new CaricatVotiController();    	
    	esamiDati = caricatVotiController.caricaVoti();		
    	tabella.setItems(esamiDati);   	
    	
    }

    @FXML
    void initialize() {
    	assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'VotiPagina.fxml'.";
        assert tabella != null : "fx:id=\"tabella\" was not injected: check your FXML file 'VotiPagina.fxml'.";        
        assert homePage != null : "fx:id=\"homePage\" was not injected: check your FXML file 'VotiPagina.fxml'.";
        assert colonnaEsame != null : "fx:id=\"colonnaEsame\" was not injected: check your FXML file 'VotiPagina.fxml'.";
        assert colonnaVoto != null : "fx:id=\"colonnaVoto\" was not injected: check your FXML file 'VotiPagina.fxml'.";
        
        //set up the columns in the table
        colonnaEsame.setCellValueFactory(new PropertyValueFactory<EsameDato,String>("nome"));
        colonnaVoto.setCellValueFactory(new PropertyValueFactory<EsameDato,String>("voto"));
        //tabella.setItems(getEsami());
        
    }
    
    public void inserisciDati() {
    	
    	InserisciDatiController inserisciDatiController = new InserisciDatiController();
    	inserisciDatiController.inserisciDati(esameCampo.getText(),votoCampo.getText());
    	this.caricaVoti(null);
    }
    
    
    /*
    public ObservableList<EsameDato> getEsami(){
    	ObservableList<EsameDato> esami = FXCollections.observableArrayList();
    	esami.add(new EsameDato("Analisi 1", "25"));
    	return esami;
    	
    }
    */
    
}
