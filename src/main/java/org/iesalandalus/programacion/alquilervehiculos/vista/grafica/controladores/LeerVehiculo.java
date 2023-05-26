package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Autobus;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Furgoneta;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.texto.TipoVehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controles;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class LeerVehiculo  extends Controlador{
	
	
	@FXML private TextField tfMarca;
	
	@FXML private TextField tfModelo;
	
	@FXML private TextField tfMatricula;
	
	@FXML private ComboBox<String> cbTipoVehiculo;
	ObservableList<String> tipoOpciones = FXCollections.observableArrayList("Turismo", "Furgoneta", "Autobús");
	
	@FXML private TextField tfCilindrada;
	
	@FXML private TextField tfNplazas;
	
	@FXML private TextField tfPma;
	
	
	private boolean cancelado;
	
	@FXML
	void initialize() {
		tfMarca.textProperty().addListener((ob, ov, nv) -> Controles.validarCampoTexto(Vehiculo.ER_MARCA, tfMarca));
		tfMatricula.textProperty().addListener((ob, ov, nv) -> Controles.validarCampoTexto(Vehiculo.ER_MATRICULA, tfMatricula));
		cbTipoVehiculo.setItems(tipoOpciones);

	}
	
	public Vehiculo getVehiculo() {
		TipoVehiculo tipo = TipoVehiculo.valueOf(cbTipoVehiculo.getValue());
		String marca = tfMarca.getText();
		String modelo = tfModelo.getText();
		String matricula = tfMatricula.getText();
		
		Vehiculo vehiculo2 = null;
		if (tipo == TipoVehiculo.TURISMO) {
			int cilindrada = Integer.parseInt( tfCilindrada.getText());
			vehiculo2 = new Turismo(marca, modelo, cilindrada, matricula);
		} else if (tipo == TipoVehiculo.AUTOBUS){
			int plazas = Integer.parseInt(tfNplazas.getText());
			vehiculo2 = new Autobus(marca, modelo, plazas, matricula);
		} else if (tipo == TipoVehiculo.FURGONETA) {
			int pma = Integer.parseInt(tfPma.getText());
			int plazas = Integer.parseInt(tfNplazas.getText());
			vehiculo2 = new Furgoneta(marca, modelo, pma, plazas, matricula);
		}

		return cancelado ? null : vehiculo2;

	}
	
	public void limpiar() {
		tfMarca.setText("");
		tfModelo.setText("");
		tfMatricula.setText("");
		tfCilindrada.setText("");
		tfNplazas.setText("");
		tfPma.setText("");
	}
	 
	@FXML
	void aceptar() {
		cancelado=false;
		getEscenario().close();
	}
	
	@FXML
	void cancelar() {
		cancelado=true;
		getEscenario().close();
	}
	
	
	@FXML
	void cambiarHabilidades() {
		
		String tipo = cbTipoVehiculo.getValue();
		
		if(tipo == TipoVehiculo.TURISMO.toString()) {
			Controles.habilitarCamposTexto(tfCilindrada);
			Controles.deshabilitarCamposTexto(tfNplazas, tfPma);
		}else if(tipo == TipoVehiculo.AUTOBUS.toString()) {
			Controles.habilitarCamposTexto(tfNplazas);
			Controles.deshabilitarCamposTexto(tfCilindrada,tfPma);
		}else if(tipo == TipoVehiculo.FURGONETA.toString()) {
			Controles.habilitarCamposTexto(tfNplazas, tfPma);
			Controles.deshabilitarCamposTexto(tfCilindrada);
		}
	}

	 
}
