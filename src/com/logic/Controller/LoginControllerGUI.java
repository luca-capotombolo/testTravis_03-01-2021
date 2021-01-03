package com.logic.Controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginControllerGUI {
	
	@FXML
	private AnchorPane pane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button autentificazione;
    
    @FXML
    public void autentificazione(ActionEvent e) throws IOException {
    	String usern = username.getText();
    	String pass = password.getText();
    	
    	LoginController loginController = null;
    	
    	loginController = new LoginController();
		boolean ret = loginController.login(usern, pass);
		
		if(ret) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/logic/View/HomePage.fxml"));
			Parent root = loader.load();
			pane.getChildren().setAll(root);
		}
    		
    	
    }

    @FXML
    void initialize() {
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'Login.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'Login.fxml'.";
        assert autentificazione != null : "fx:id=\"autentificazione\" was not injected: check your FXML file 'Login.fxml'.";

    }
}
