package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import java.time.LocalDate;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controles;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class BuscarAlquiler extends Controlador{

    @FXML
    private TextField tfDniCliente;
    
    @FXML
    private TextField tfMatriculaVehiculo;

    @FXML
    private DatePicker dpFechaAlquiler;

    private boolean cancelado;
    
    
    @FXML
	void initialize() {
		tfDniCliente.textProperty().addListener((ob, ov, nv) -> Controles.validarCampoTexto(Cliente.ER_DNI, tfDniCliente));
		tfMatriculaVehiculo.textProperty().addListener((ob, ov, nv) -> Controles.validarCampoTexto(Vehiculo.ER_MATRICULA, tfMatriculaVehiculo));
	}
    
    public Alquiler getAlquiler() {
    	
    	Cliente cliente = Cliente.getClienteConDni(tfDniCliente.getText());
		Vehiculo vehiculo = Vehiculo.getVehiculoConMatricula(tfMatriculaVehiculo.getText());
		LocalDate fechaAlquiler= dpFechaAlquiler.getValue();
    	
    	return cancelado ? null : new Alquiler(cliente, vehiculo, fechaAlquiler);
    }
    
    
    public void limpiar() {
		tfDniCliente.setText("");
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
