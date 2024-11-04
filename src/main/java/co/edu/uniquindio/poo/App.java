package co.edu.uniquindio.poo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;

import co.edu.uniquindio.poo.Controller.ReservaController;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;
import co.edu.uniquindio.poo.viewController.ReservaViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class App extends Application {

    private Stage primaryStage;
    private ReservaController reservaController; // Declarar como ReservaController
    private LinkedList<Reserva> listaReservas = new LinkedList<>(); // Inicializa lista de reservas
    private Empresa empresa = new Empresa("UNIQUINDIO", listaReservas);
    // Observable lists to populate ComboBoxes in the UI

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Reserva");
        inicializarData(); // Asegúrate de inicializar datos antes de abrir la vista
        openViewPrincipal();
    }

    private void openViewPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            // Asegúrate de que la ruta coincide con la ubicación real del archivo FXML
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/CrudReserva.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            
            // Obtén el controlador y establece las dependencias
            ReservaViewController primaryController = loader.getController();
            primaryController.setReservaController(reservaController); // Pasar el controlador a la vista
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Considera mostrar una alerta al usuario
        }
    }

    public static void main(String[] args) {
        launch();
    }

    public void inicializarData() {
        reservaController = new ReservaController(empresa); // Inicializa el controlador aquí
        inicializarReservas(); // Agrega las reservas si es necesario
    }

    public void inicializarReservas(){
        // Aquí puedes agregar reservas iniciales si lo deseas
    }
}
