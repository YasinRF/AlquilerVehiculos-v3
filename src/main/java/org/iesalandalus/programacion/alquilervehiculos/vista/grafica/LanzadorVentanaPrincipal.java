package org.iesalandalus.programacion.alquilervehiculos.vista.grafica;

import org.iesalandalus.programacion.alquilervehiculos.vista.grafica.utilidades.Controladores;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.ventanas.utilidades.Dialogos;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class LanzadorVentanaPrincipal extends Application {
	
	private static final String TITULO = "Vista Ventana Alquiler de Vehiculos";

	@Override
	public void start(Stage escenarioPrincipal) throws Exception {
		try {
			//FXMLLoader cargadorVentanaPrincipal = new FXMLLoader(LocalizadorRecursos.class.getResource("vistas/VentanaPrincipal.fxml"));
			//Parent raiz = cargadorVentanaPrincipal.load();
			
			//Scene escena = new Scene(raiz);
			//escenarioPrincipal.setTitle("Vista Gráfica Alquiler de Vehículos");
			//escenarioPrincipal.setScene(escena);
			//escenarioPrincipal.show();
			Controlador ventanaPrincipal = Controladores.get("vistas/VentanaPrincipal.fxml", TITULO, null);
			ventanaPrincipal.getEscenario().setOnCloseRequest(e -> confirmarSalida(ventanaPrincipal.getEscenario(), e));
			ventanaPrincipal.getEscenario().show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void comenzar() {
		launch("LanzadorVentanaPrincipal.class");
	}
	
	private void confirmarSalida(Stage escenario, WindowEvent e) {
		if(Dialogos.mostrarDialogoConfirmacion("Salir", "¿Estas seguro de que quieres salir de la aplicacion?", escenario)) {
			escenario.close();
		}
		
	}
	
}
