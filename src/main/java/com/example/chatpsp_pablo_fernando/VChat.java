package com.example.chatpsp_pablo_fernando;

import Modelos.Cliente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class VChat implements Initializable {
    /**/
    @FXML
    private List<Cliente> listadoUsuariosConectados = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
