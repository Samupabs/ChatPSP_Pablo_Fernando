package Modelos;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class Cliente {

    private int ID;
    private String nombre;
    private Socket conexion;

    //El @ID se obtiene de manera secuencial cuando entra el cliente al servidor para evitar que se repita

    public Cliente(String nombre, String host, int puerto) throws IOException, ConnectException {
        this.ID = 0;
        setNombre(nombre);
        this.conexion = new Socket(host,puerto);
        //writeUTF con get.nombre
        //readUTF el nuevo id y llamo a setID
    }

    @Override
    public String toString() {
        return "Usuario [ ID: " + ID + " || " + "Nombre de Usuario: " + nombre + " ]"
                +"\n\t" + conexion.toString();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {

        String idSTR = String.valueOf(ID).trim();

        if (idSTR.matches("[1-9]+")) {
            this.ID = ID;
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        if (nombre == null){
            System.out.println("Error: El nombre no puede ser nulo");
            return;
        }

        nombre = nombre.trim();

        if (nombre.isBlank() || nombre.isEmpty()) {
            System.out.println("Error: El nombre no puede estar en blanco o vacío");
            return;
        }

        if (!nombre.matches("[a-zA-Z]+")) {
            System.out.println("Error: El nombre solo puede contener letras corrientes");
            return;
        }

        this.nombre = "@"+nombre;
    }

    public Socket getConexion() {
        return conexion;
    }

    public void setConexion(Socket conexion) {
        this.conexion = conexion;
    }
}
