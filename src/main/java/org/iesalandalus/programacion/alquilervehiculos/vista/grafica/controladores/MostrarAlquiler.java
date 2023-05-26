package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Autobus;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Furgoneta;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.texto.TipoVehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MostrarAlquiler extends Controlador{
	
	 	@FXML
	    private Label tfDni;

	    @FXML
	    private Label tfFechaAlquiler;

	    @FXML
	    private Label tfMarca;

	    @FXML
	    private Label tfMatricula;

	    @FXML
	    private Label tfModelo;

	    @FXML
	    private Label tfNombre;

	    @FXML
	    private Label tfTelefono;
	    
	    
	    
	    @FXML
		void initialize() {
			System.out.println("Método initialize de Mostrar Alquiler");
		}
	    
	    public void mostrar(Alquiler alquiler) {
	    	if(alquiler != null) {
	    		tfDni.setText(alquiler.getCliente().getDni());
	        	tfNombre.setText(alquiler.getCliente().getNombre());
	        	tfTelefono.setText(alquiler.getCliente().getTelefono());
	        	tfMatricula.setText(alquiler.getVehiculo().getMatricula());
	    		tfMarca.setText(alquiler.getVehiculo().getMarca());
	    		tfModelo.setText(alquiler.getVehiculo().getModelo());
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

