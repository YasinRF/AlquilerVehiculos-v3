package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controlador;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListarVehiculos extends Controlador {
	@FXML

	private TableColumn<Vehiculo, String> tcMatricula;

	@FXML

	private TableColumn<Vehiculo, String> tcMarca;

	@FXML

	private TableColumn<Vehiculo, String> tcModelo;

	@FXML

	private TableColumn<Vehiculo, Integer> tcCilindrada;

	@FXML

	private TableColumn<Vehiculo, Integer> tcPlazas;

	@FXML

	private TableColumn<Vehiculo, Integer> tcPma;

	@FXML

	private TableView<Vehiculo> tvVehiculos;

	@FXML

	private Button btAceptar;

	@FXML

	void aceptar(ActionEvent event) {
		getEscenario().close();
	}

	@FXML

	void initialize() {

		tcMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));

		tcMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));

		tcModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		/*
		if (Turismo) {
			tcCilindrada.setCellValueFactory(new PropertyValueFactory<>("cilindrada"));
			
		}else if(Autobus) {
			tcPlazas.setCellValueFactory(new PropertyValueFactory<>("plazas"));
			
		}else if(Furgoneta)
			tcPma.setCellValueFactory(new PropertyValueFactory<>("pma"));
		*/

		tcCilindrada.setCellValueFactory(new PropertyValueFactory<>("cilindrada"));

		tcPlazas.setCellValueFactory(new PropertyValueFactory<>("plazas"));

		tcPma.setCellValueFactory(new PropertyValueFactory<>("pma"));

	}

	public void actualizar(List<Vehiculo> vehiculos) {

		tvVehiculos.setItems(FXCollections.observableArrayList(vehiculos));

	}

}