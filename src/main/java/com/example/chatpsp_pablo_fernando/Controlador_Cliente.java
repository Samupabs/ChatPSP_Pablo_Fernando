package com.example.chatpsp_pablo_fernando;

import Modelos.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controlador_Cliente {
    /*-Conectarse al server
     * -Recibir listado de usuarios desde el Servidor
     * -AT: HashMap ListadoServidor
     * -AT: int ID
     * -AT: String Nombre */

    @FXML
    private Label nombreUsuario;

    @FXML
    private Label IDusuario;

    @FXML
    private Cliente Usuario;

}
