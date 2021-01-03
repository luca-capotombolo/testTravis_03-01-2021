package com.logic.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class HomePageControllerGUI {
	
	@FXML
	private AnchorPane pane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button esami;

    @FXML
    private Button voti;

    @FXML
    private Button note;

    @FXML
    void caricaEsamiPagina(ActionEvent event) {

    }

   

    @FXML
    void caricaVotiPagina(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/logic/View/VotiPagina.fxml"));
    	Parent root = loader.load();
    	pane.getChildren().setAll(root);
    	
    }
    
    @FXML
    void caricaNotePagina(ActionEvent e) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/logic/View/NotePagina.fxml"));
    	Parent root = loader.load();
    	pane.getChildren().setAll(root);
    }

    @FXML
    void initialize() {
        assert esami != null : "fx:id=\"esami\" was not injected: check your FXML file 'HomePage.fxml'.";
        assert voti != null : "fx:id=\"voti\" was not injected: check your FXML file 'HomePage.fxml'.";
        assert note != null : "fx:id=\"note\" was not injected: check your FXML file 'HomePage.fxml'.";

    }
}
