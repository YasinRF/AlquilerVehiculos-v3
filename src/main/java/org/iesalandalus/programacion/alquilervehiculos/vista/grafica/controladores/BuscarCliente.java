package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controles;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BuscarCliente extends Controlador{
	
	@FXML private TextField tfDni;
	
	private boolean cancelado;
	
	@FXML
	void initialize() {
		tfDni.textProperty().addListener((ob, ov, nv) -> Controles.validarCampoTexto(Cliente.ER_DNI, tfDni));
	}
	
	public String getDni() {
		String dni = tfDni.getText();
		
		return cancelado ? null : dni;
	}
	
	public void limpiar() {
		tfDni.setText("");
		cancelado=true;
	}
	
	@FXML
	void volver() {
		cancelado=true;
		getEscenario().close();
	}
	
	@FXML
	void buscar() {
		cancelado=false;
		getEscenario().close();
	}

	
}