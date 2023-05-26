package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MostrarCliente extends Controlador{
	
	@FXML
    private Label tfDni;

    @FXML
    private Label tfNombre;

    @FXML
    private Label tfTelefono;
    
    @FXML
	void initialize() {
		System.out.println("Método initialize de Mostrar Cliente");
	}
    
    public void mostrar(Cliente cliente) {
    	tfDni.setText(cliente.getDni());
    	tfNombre.setText(cliente.getNombre());
    	tfTelefono.setText(cliente.getTelefono());
    }
    
    @FXML
    void cancelar(ActionEvent event) {
    	getEscenario().close();
    }

    @FXML
    void borrar(ActionEvent event) {
    	
    }

    @FXML
    void devolver(ActionEvent event) {
    	
    }

    @FXML
    void listarCliente(ActionEvent event) {
    	
    }

}
