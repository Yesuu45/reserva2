package co.edu.uniquindio.poo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;

import co.edu.uniquindio.poo.model.*;
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
    public static Empresa empresa = new Empresa("UQ");

    // Observable lists to populate ComboBoxes in the UI
    public static ObservableList<Cliente> clientesList;
    public static ObservableList<Vehiculo> vehiculosList;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestion de Clientes y Reservas");
        openViewPrincipal();
    }

    private void openViewPrincipal() {
        inicializarData();

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/CrudView.fxml"));
            AnchorPane rootLayout = loader.load();
            
            // Get the controller and set the application context
            ReservaViewController primaryController = loader.getController();
            primaryController.setApp(this);
            primaryController.initializeComboBoxData(clientesList, vehiculosList);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

    // Initializes example data and populates observable lists
    public void inicializarData() {
        // Create example clients
        Cliente cliente1 = new Cliente("Juan", "Perez", "juan.perez@example.com");
        Cliente cliente2 = new Cliente("Maria", "Gomez", "maria.gomez@example.com");

        // Add clients to the observable list
        clientesList = FXCollections.observableArrayList(cliente1, cliente2);

        // Create example vehicles
        Vehiculo moto = new Moto("M1234", "ModeloM", "Yamaha", LocalDate.of(2022, 5, 10), Caja.AUTOMATICA);
        Vehiculo camion = new Camion("C5678", "ModeloC", "Volvo", LocalDate.of(2021, 3, 15), 10.0);
        Vehiculo auto = new Auto("A91011", "ModeloA", "Toyota", LocalDate.of(2020, 1, 20), 4);

        // Add vehicles to the observable list
        vehiculosList = FXCollections.observableArrayList(moto, camion, auto);

        // Add clients and a reservation to the company data
        LinkedList<Cliente> clientes = new LinkedList<>(clientesList);
        LinkedList<Vehiculo> vehiculos = new LinkedList<>(vehiculosList);
        
        LocalDate fechaInicio = LocalDate.now();
        LocalDate fechaFin = fechaInicio.plusDays(5);
        Reserva reserva = new Reserva(fechaInicio, fechaFin, 5, vehiculos, clientes, 15000.0, 20000.0);

        empresa.agregarCliente(cliente1);
        empresa.agregarCliente(cliente2);
        empresa.agregarReserva(reserva);
    }
}
