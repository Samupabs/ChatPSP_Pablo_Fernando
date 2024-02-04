package com.example.chatpsp_pablo_fernando;

import Modelos.Cliente;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;

public class Controlador_Principal {

    private static Controlador_Principal instancia;
    private static Cliente usuario;

    private Controlador_Principal() {
    }

    public static Controlador_Principal getInstancia() {
        if (instancia == null) {
            instancia = new Controlador_Principal();
        }
        return instancia;
    }

    public static void iniciarSesion(String nombreUsuario, String host, int puerto, Button botonPulsado){

        try {

            //conexion con servidor
            usuario = new Cliente(nombreUsuario, host, puerto);

            //envio mi nombre al servidor
            OutputStream os = usuario.getConexion().getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            String datosUsuario = usuario.getNombre();
            dos.writeUTF(datosUsuario);

            //asignacion de id
            InputStream is = usuario.getConexion().getInputStream();
            DataInputStream dis = new DataInputStream(is);
            usuario.setID(dis.readInt());

            //cambio de ventana
            cambiarDeVentana("chat.fxml",botonPulsado);


        } catch (ConnectException ce) {
            System.out.println("Error: No se puede conectar con el servidor");
            return;

        } catch (IOException e) {
            System.out.println("Error: Problema de entrada/salida");
            return;
        }


    }

    private static void cambiarDeVentana (String nombreXML, Button boton ){
        try {

            FXMLLoader loader = new FXMLLoader(Controlador_Principal.class.getResource(nombreXML));
            Parent root = loader.load();

            // Configurar la escena
            Scene scene = new Scene(root);
            Stage stage = (Stage) boton.getScene().getWindow(); // Obtener la ventana actual usando el botón
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}