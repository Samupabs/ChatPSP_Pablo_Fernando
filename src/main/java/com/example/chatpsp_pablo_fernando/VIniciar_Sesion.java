package com.example.chatpsp_pablo_fernando;

import Modelos.Cliente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;
import java.util.ResourceBundle;

public class VIniciar_Sesion implements Initializable {
    @FXML
    private Button BTN_IniciarSesion;
    @FXML
    private TextField TXTF_nombreUsuario;
    private Controlador_Principal controladorPrincipal = Controlador_Principal.getInstancia();
    private String host = "localhost";
    private int puerto = 6000;

    @FXML
    public void iniciarSesion() {

        String nombreUsuario = TXTF_nombreUsuario.getText();

        if(comprobarNombre(nombreUsuario)){
            controladorPrincipal.iniciarSesion(nombreUsuario,this.host,this.puerto,BTN_IniciarSesion);
        } else {
            System.out.println("El nombre no puede estar vacío ni contener números o símbolos extraños");
        }


    }

    private boolean comprobarNombre(String nombre) {
        boolean respuesta = true;

        if (nombre == null){
            System.out.println("Error: El nombre no puede ser nulo");
            return false;
        }

        nombre = nombre.trim();

        if (nombre.isBlank() || nombre.isEmpty()) {
            System.out.println("Error: El nombre no puede estar en blanco o vacío");
            return false;
        }

        if (!nombre.matches("[a-zA-Z]+")) {
            System.out.println("Error: El nombre solo puede contener letras corrientes");
            return false;
        }

        return respuesta;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public Button getBTN_IniciarSesion() {
        return BTN_IniciarSesion;
    }

    public void setBTN_IniciarSesion(Button BTN_IniciarSesion) {
        this.BTN_IniciarSesion = BTN_IniciarSesion;
    }

    public TextField getTXTF_nombreUsuario() {
        return TXTF_nombreUsuario;
    }

    public void setTXTF_nombreUsuario(TextField TXTF_nombreUsuario) {
        this.TXTF_nombreUsuario = TXTF_nombreUsuario;
    }
}
