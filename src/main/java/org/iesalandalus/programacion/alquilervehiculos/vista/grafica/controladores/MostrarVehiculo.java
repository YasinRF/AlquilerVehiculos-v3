package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Autobus;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Furgoneta;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.texto.TipoVehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MostrarVehiculo extends Controlador{
	
	@FXML
    private Label tfMatricula;

    @FXML
    private Label tfMarca;

    @FXML
    private Label tfModelo;
    
    @FXML
    private Label tfCilindrada;
    
    @FXML
    private Label tfPlazas;
    
    @FXML
    private Label tfPma;
	
	
	@FXML
	void initialize() {
		System.out.println("Método initialize de Mostrar Vehiculo");
	}

	public void mostrar(Vehiculo vehiculo) {
		tfMatricula.setText(vehiculo.getMatricula());
		tfMarca.setText(vehiculo.getMarca());
		tfModelo.setText(vehiculo.getModelo());
		if (TipoVehiculo.get(vehiculo) == TipoVehiculo.TURISMO) {
			tfCilindrada.setText(String.valueOf(((Turismo)vehiculo).getCilindrada()));
		} else if(TipoVehiculo.get(vehiculo) == TipoVehiculo.AUTOBUS){
			tfPlazas.setText(String.valueOf(((Autobus)vehiculo).getPlazas()));
		} else if(TipoVehiculo.get(vehiculo) == TipoVehiculo.FURGONETA) {
			tfPlazas.setText(String.valueOf(((Furgoneta)vehiculo).getPlazas()));
			tfPma.setText(String.valueOf(((Furgoneta)vehiculo).getPlazas()));
		}
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
    void listarVehiculo(ActionEvent event) {
    	
    }
	
	

}
