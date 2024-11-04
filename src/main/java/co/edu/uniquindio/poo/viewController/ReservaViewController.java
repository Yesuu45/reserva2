package co.edu.uniquindio.poo.viewController;

/**
 * Sample Skeleton for 'CrudReserva.fxml' Controller Class
 */

 /**
 * Sample Skeleton for 'CrudReserva.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ReservaViewController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="cbClientes"
    private ComboBox<?> cbClientes; // Value injected by FXMLLoader

    @FXML // fx:id="columClientes"
    private TableColumn<?, ?> columClientes; // Value injected by FXMLLoader

    @FXML // fx:id="columVehiculos"
    private TableColumn<?, ?> columVehiculos; // Value injected by FXMLLoader

    @FXML // fx:id="columInicioReserva"
    private TableColumn<?, ?> columInicioReserva; // Value injected by FXMLLoader

    @FXML // fx:id="btnFechaInicial"
    private DatePicker btnFechaInicial; // Value injected by FXMLLoader

    @FXML // fx:id="tblListaReservas"
    private TableView<?> tblListaReservas; // Value injected by FXMLLoader

    @FXML // fx:id="columFinReserva"
    private TableColumn<?, ?> columFinReserva; // Value injected by FXMLLoader

    @FXML // fx:id="btnAgregarReserva"
    private Button btnAgregarReserva; // Value injected by FXMLLoader

    @FXML // fx:id="btnFechaFinal"
    private DatePicker btnFechaFinal; // Value injected by FXMLLoader

    @FXML // fx:id="btnEliminarReserva"
    private Button btnEliminarReserva; // Value injected by FXMLLoader

    @FXML // fx:id="cbVehiculos"
    private ComboBox<?> cbVehiculos; // Value injected by FXMLLoader

    @FXML
    void agregarReservaAction(ActionEvent event) {

    }

    @FXML
    void eliminarReservaAction(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert cbClientes != null : "fx:id=\"cbClientes\" was not injected: check your FXML file 'CrudReserva.fxml'.";
        assert columClientes != null : "fx:id=\"columClientes\" was not injected: check your FXML file 'CrudReserva.fxml'.";
        assert columVehiculos != null : "fx:id=\"columVehiculos\" was not injected: check your FXML file 'CrudReserva.fxml'.";
        assert columInicioReserva != null : "fx:id=\"columInicioReserva\" was not injected: check your FXML file 'CrudReserva.fxml'.";
        assert btnFechaInicial != null : "fx:id=\"btnFechaInicial\" was not injected: check your FXML file 'CrudReserva.fxml'.";
        assert tblListaReservas != null : "fx:id=\"tblListaReservas\" was not injected: check your FXML file 'CrudReserva.fxml'.";
        assert columFinReserva != null : "fx:id=\"columFinReserva\" was not injected: check your FXML file 'CrudReserva.fxml'.";
        assert btnAgregarReserva != null : "fx:id=\"btnAgregarReserva\" was not injected: check your FXML file 'CrudReserva.fxml'.";
        assert btnFechaFinal != null : "fx:id=\"btnFechaFinal\" was not injected: check your FXML file 'CrudReserva.fxml'.";
        assert btnEliminarReserva != null : "fx:id=\"btnEliminarReserva\" was not injected: check your FXML file 'CrudReserva.fxml'.";
        assert cbVehiculos != null : "fx:id=\"cbVehiculos\" was not injected: check your FXML file 'CrudReserva.fxml'.";

    }
}
