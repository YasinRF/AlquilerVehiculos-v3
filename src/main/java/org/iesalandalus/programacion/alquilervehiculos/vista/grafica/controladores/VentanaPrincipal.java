package org.iesalandalus.programacion.alquilervehiculos.vista.grafica.controladores;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controladores;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Dialogos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class VentanaPrincipal extends Controlador {
	
	@FXML
	private Button btpulsame;
	
	@FXML
	private void initialize() {
		System.out.println("Método initialize de VentanaPrincial");
	}
	
	@FXML
	private void confirmarSalida() {
		if(Dialogos.mostrarDialogoConfirmacion("Salir", "¿Estás seguro de que quieres salir de la aplicación?",
					getEscenario())){
				getEscenario().close();
			}
	}
	
	
	/*
	 * CLIENTE
	 */
	
	
	@FXML
	void listarCliente(ActionEvent event) {
		ListarClientes listarClientes = (ListarClientes) Controladores.get("vistas/ListarClientes.fxml", "Listar Clientes", getEscenario());
		listarClientes.actualizar(VistaGrafica.getInstancia().getControlador().getClientes());
		listarClientes.getEscenario().showAndWait();
	}
	
	@FXML
	 void leerCliente(ActionEvent event) {
		LeerCliente leerCliente = (LeerCliente) Controladores.get("vistas/LeerCliente.fxml","Leer Cliente", getEscenario());
	
	leerCliente.limpiar();
	leerCliente.getEscenario().showAndWait();
	try {
		Cliente cliente = leerCliente.getCliente();
		if(cliente != null){
			VistaGrafica.getInstancia().getControlador().insertar(cliente);
			Dialogos.mostrarDialogoAdvertencia("Insertar Cliente", "Cliente insertado correctamente", getEscenario());
		}
	} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
		Dialogos.mostrarDialogoError("Leer Cliente", e.getMessage(), getEscenario());
	}
	}
	
	@FXML
	void buscarCliente() {
		BuscarCliente buscarCliente = (BuscarCliente) Controladores.get("vistas/BuscarCliente.fxml","Buscar Cliente", getEscenario());
	
		buscarCliente.limpiar();
		buscarCliente.getEscenario().showAndWait();
		if (buscarCliente.getDni() != null) {
			Cliente clienteBuscar = VistaGrafica.getInstancia().getControlador().buscar(Cliente.getClienteConDni(buscarCliente.getDni()));
			if (clienteBuscar != null) {
				MostrarCliente mostrarCliente = (MostrarCliente) Controladores.get("vistas/MostrarCliente.fxml","Mostrar Cliente" , getEscenario());
				mostrarCliente.mostrar(clienteBuscar);
				mostrarCliente.getEscenario().showAndWait();
			} else {
				Dialogos.mostrarDialogoInformacion("No encontrado", "El cliente no ha sido encontrado", getEscenario());
			}
		}

	}
	
	
	/*
	 * VEHICULO
	 */
	
	
	@FXML
	void listarVehiculos(ActionEvent event) {
		ListarVehiculos listarVehiculos = (ListarVehiculos) Controladores.get("vistas/ListarVehiculos.fxml", "Listar Vehículos", getEscenario());
		listarVehiculos.actualizar(VistaGrafica.getInstancia().getControlador().getVehiculos());
		listarVehiculos.getEscenario().showAndWait();
	}
	
	@FXML
	void leerVehiculo(ActionEvent event) {
		LeerVehiculo leerVehiculo = (LeerVehiculo) Controladores.get("vistas/LeerVehiculo.fxml","Leer Vehiculo", getEscenario());
	
	leerVehiculo.limpiar();
	leerVehiculo.getEscenario().showAndWait();
	try {
		Vehiculo vehiculo = leerVehiculo.getVehiculo();
		if(vehiculo != null){
			VistaGrafica.getInstancia().getControlador().insertar(vehiculo);
			Dialogos.mostrarDialogoAdvertencia("Insertar Vehiculo", "Vehiculo insertado correctamente", getEscenario());
		}
	} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
		Dialogos.mostrarDialogoError("Leer Vehiculo", e.getMessage(), getEscenario());
	}
	
	}
	
	@FXML
	void buscarVehiculo() {
		BuscarVehiculo buscarVehiculo = (BuscarVehiculo) Controladores.get("vistas/BuscarVehiculo.fxml","Buscar Vehiculo", getEscenario());
	
		buscarVehiculo.limpiar();
		buscarVehiculo.getEscenario().showAndWait();
		if (buscarVehiculo.getMatricula() != null) {
			Vehiculo vehiculoBuscar = VistaGrafica.getInstancia().getControlador().buscar(Vehiculo.getVehiculoConMatricula(buscarVehiculo.getMatricula()));
			if (vehiculoBuscar != null) {
				MostrarVehiculo mostrarVehiculo = (MostrarVehiculo) Controladores.get("vistas/MostrarVehiculo.fxml","Mostrar Vehiculo" , getEscenario());
				mostrarVehiculo.mostrar(vehiculoBuscar);
				mostrarVehiculo.getEscenario().showAndWait();
			} else {
				Dialogos.mostrarDialogoInformacion("No encontrado", "El vehículo no ha sido encontrado", getEscenario());
			}
		}

	}
	
	
	/*
	 * ALQUILER
	 */
	
	
	@FXML
	void listarAlquileres(ActionEvent event) {
		ListarAlquileres listarAlquileres = (ListarAlquileres) Controladores.get("vistas/ListarAlquileres.fxml", "Listar Alquileres", getEscenario());
		listarAlquileres.actualizar(VistaGrafica.getInstancia().getControlador().getAlquileres());
		listarAlquileres.getEscenario().showAndWait();
	}
	
	@FXML
	 void leerAlquiler(ActionEvent event) {
		LeerAlquiler leerAlquiler = (LeerAlquiler) Controladores.get("vistas/LeerAlquiler.fxml","Leer Alquiler", getEscenario());
	
		leerAlquiler.limpiar();
		leerAlquiler.getEscenario().showAndWait();
	try {
		Alquiler alquiler = leerAlquiler.getAlquiler();
		if(alquiler != null){
			VistaGrafica.getInstancia().getControlador().insertar(alquiler);
			Dialogos.mostrarDialogoAdvertencia("Insertar Alquiler", "Alquiler insertado correctamente", getEscenario());
		}
	} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
		Dialogos.mostrarDialogoError("Leer Alquiler", e.getMessage(), getEscenario());
	}
	}
	
	@FXML
	void buscarAlquiler() {
		BuscarAlquiler buscarAlquiler = (BuscarAlquiler) Controladores.get("vistas/BuscarAlquiler.fxml","Buscar Alquiler", getEscenario());
	
		buscarAlquiler.limpiar();
		buscarAlquiler.getEscenario().showAndWait();

	}
	
	
	
	@FXML
    void acercaDe(ActionEvent event) {
		AcercaDe acercaDe = (AcercaDe) Controladores.get("vistas/AcercaDe.fxml","Leer AcercaDe", getEscenario());
		
		acercaDe.getEscenario().showAndWait();
    }

}
	
