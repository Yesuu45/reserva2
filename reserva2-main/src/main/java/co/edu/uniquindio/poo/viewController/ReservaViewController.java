package co.edu.uniquindio.poo.viewController;

import java.net.URL;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.Controller.ReservaController;
import co.edu.uniquindio.poo.model.Auto;
import co.edu.uniquindio.poo.model.Caja;
import co.edu.uniquindio.poo.model.Camion;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ReservaViewController {
    private App app;
    private ReservaController reservaController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Cliente> cbClientes; // Value injected by FXMLLoader

    @FXML
    private TableColumn<Reserva, Cliente> columClientes; // Value injected by FXMLLoader

    @FXML
    private TableColumn<Reserva, Vehiculo> columVehiculos; // Value injected by FXMLLoader

    @FXML
    private TableColumn<Reserva, LocalDate> columInicioReserva; // Value injected by FXMLLoader

    @FXML
    private DatePicker btnFechaInicial; // Value injected by FXMLLoader

    @FXML
    private TableView<Reserva> tblListaReservas; // Value injected by FXMLLoader
    
    @FXML
    private TableColumn<Reserva, LocalDate> columFinReserva;

    private ObservableList<Cliente> listaClientes;
    private ObservableList<Vehiculo> listaVehiculos;
    private ObservableList<Reserva> listaReservas;

    @FXML
    private Button btnAgregarReserva; // Value injected by FXMLLoader

    @FXML
    private DatePicker btnFechaFinal; // Value injected by FXMLLoader

    @FXML
    private Button btnEliminarReserva; // Value injected by FXMLLoader

    @FXML
    private ComboBox<Vehiculo> cbVehiculos; // Value injected by FXMLLoader

@FXML
//Obetener valores
void agregarReservaAction(ActionEvent event) {
    Cliente cliente = cbClientes.getValue();
    Vehiculo vehiculo = cbVehiculos.getValue();
    LocalDate fechaInicio = btnFechaInicial.getValue();
    LocalDate fechaFin = btnFechaFinal.getValue();

    if (cliente != null && vehiculo != null && fechaInicio != null && fechaFin != null) {
        // Calcular los días de la reserva
        int dias = (int) (fechaFin.toEpochDay() - fechaInicio.toEpochDay());

        // Generar un ID único (esto es solo un ejemplo, puedes ajustarlo según tus necesidades)
        String id = "RES-" + System.currentTimeMillis();

        // Crear listas vacías de clientes y vehículos si no tienes valores iniciales
        LinkedList<Vehiculo> vehiculos = new LinkedList<>();
        LinkedList<Cliente> clientes = new LinkedList<>();

        // Usar las tarifas predeterminadas
        double tarifaBase = 15000.0;
        double tarifaAdicional = 20000.0;

        // Crear la reserva con todos los parámetros del constructor
        Reserva reserva = new Reserva(fechaInicio, fechaFin, id, dias, vehiculos, cliente, vehiculo, clientes, tarifaBase, tarifaAdicional);

        reservaController.agregarReserva(reserva);
        listaReservas.add(reserva);
        tblListaReservas.refresh();
    } else {
        // Mostrar una alerta o mensaje de error en lugar de imprimirlo
        System.out.println("Todos los campos son obligatorios.");
    }
}



    @FXML
    void eliminarReservaAction(ActionEvent event) {
        Reserva reservaSeleccionada = tblListaReservas.getSelectionModel().getSelectedItem();
        if(reservaSeleccionada != null){
            reservaController.getListaReservas().remove(reservaSeleccionada);
            listaReservas.remove(reservaSeleccionada);
            tblListaReservas.refresh();
        } else {
            // Mostrar una alerta al usuario indicando que debe seleccionar una reserva
            System.out.println("Seleccione una reserva para eliminar.");
        }
    }

    @FXML
    void initialize() {
        assert cbClientes != null : "fx:id=\"cbClientes\" fue inyectado incorrectamente.";
        assert columClientes != null : "fx:id=\"columClientes\" fue inyectado incorrectamente.";
        assert columVehiculos != null : "fx:id=\"columVehiculos\" fue inyectado incorrectamente.";
        assert columInicioReserva != null : "fx:id=\"columInicioReserva\" fue inyectado incorrectamente.";
        assert btnFechaInicial != null : "fx:id=\"btnFechaInicial\" fue inyectado incorrectamente.";
        assert tblListaReservas != null : "fx:id=\"tblListaReservas\" fue inyectado incorrectamente.";
        assert columFinReserva != null : "fx:id=\"columFinReserva\" fue inyectado incorrectamente.";
        assert btnAgregarReserva != null : "fx:id=\"btnAgregarReserva\" fue inyectado incorrectamente.";
        assert btnFechaFinal != null : "fx:id=\"btnFechaFinal\" fue inyectado incorrectamente.";
        assert btnEliminarReserva != null : "fx:id=\"btnEliminarReserva\" fue inyectado incorrectamente.";
        assert cbVehiculos != null : "fx:id=\"cbVehiculos\" fue inyectado incorrectamente.";

        cargarDatos();

        // Configuración de ComboBox
        cbClientes.setItems(listaClientes);
        cbVehiculos.setItems(listaVehiculos);

        // Configuración de TableView
        columClientes.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        columVehiculos.setCellValueFactory(new PropertyValueFactory<>("vehiculo"));
        columInicioReserva.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
        columFinReserva.setCellValueFactory(new PropertyValueFactory<>("fechaFin"));

        tblListaReservas.setItems(listaReservas);
    }

    private void cargarDatos() {
        // Crear clientes
        listaClientes = FXCollections.observableArrayList(
            new Cliente("Carlos", "Pérez", "carlos.perez@example.com", "ID001"),
            new Cliente("Ana", "García", "ana.garcia@example.com", "ID002"),
            new Cliente("Luis", "Martínez", "luis.martinez@example.com", "ID003"),
            new Cliente("Marta", "Rodríguez", "marta.rodriguez@example.com", "ID004"),
            new Cliente("Juan", "López", "juan.lopez@example.com", "ID005")
        );

        // Crear vehículos
        listaVehiculos = FXCollections.observableArrayList(
            new Moto("ABC123", "Alto", "Suzuki", LocalDate.of(2020, 1, 10), Caja.AUTOMATICA),
            new Moto("DEF456", "Fiesta", "Ford", LocalDate.of(2019, 5, 20), Caja.MANUAL),
            new Camion("GHI789", "Yaris Hibrida", "Toyota", LocalDate.of(2018, 3, 15), 5.5),
            new Auto("JKL012", "Panigale", "Ducati", LocalDate.of(2021, 7, 8), 4),
            new Camion("MNO345", "Q3", "Audi", LocalDate.of(2017, 11, 30), 7.0)
        );

        // Crear lista de reservas (vacía al inicio)
        listaReservas = FXCollections.observableArrayList();
    }

    public void setApp(App app) {
        this.app = app;
    }

    public void setReservaController(ReservaController reservaController) {
        this.reservaController = reservaController;
    }

    public class MostrarImagen extends Application {

        @Override
        public void start(Stage primaryStage) {
            // Cargar la imagen
            Image imagen = new Image("@FastCars%20(2).png"); // Asegúrate de que la ruta sea correcta
            ImageView imageView = new ImageView(imagen);
    
            // Crear un layout y agregar la imagen
            StackPane root = new StackPane();
            root.getChildren().add(imageView);
    
            // Crear la escena
            Scene scene = new Scene(root, 400, 300);
    
            // Configurar el escenario
            primaryStage.setTitle("Mostrar Imagen en JavaFX");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    
    }
}