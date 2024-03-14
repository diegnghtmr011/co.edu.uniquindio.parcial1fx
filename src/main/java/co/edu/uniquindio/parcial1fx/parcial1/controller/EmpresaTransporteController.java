package co.edu.uniquindio.parcial1fx.parcial1.controller;

import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.parcial1fx.parcial1.factory.ModelFactory;
import co.edu.uniquindio.parcial1fx.parcial1.model.Vehiculo;
import co.edu.uniquindio.parcial1fx.parcial1.model.VehiculoTransporte;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EmpresaTransporteController {

    ModelFactory modelFactory;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregarPropietario;

    @FXML
    private Button btnAgregarUsuario;

    @FXML
    private Button btnAgregarVehiculoCarga;

    @FXML
    private Button btnAgregarVehiculoTransporte;

    @FXML
    private Button btnCalcularPasajerosTransportados;

    @FXML
    private Button btnObtenerMayoresEdad;

    @FXML
    private Button btnObtenerNumeroUsuariosPlaca;

    @FXML
    private TextField txtCapacidadCargaVehiculoCarga;

    @FXML
    private TextField txtCedulaAsociadosVehiculoCarga;

    @FXML
    private TextField txtCedulaAsociadosVehiculoTransporte;

    @FXML
    private TextField txtCedulaPropietario;

    @FXML
    private TextField txtCedulaPropietarioVehiculoCarga;

    @FXML
    private TextField txtCedulaPropietarioVehiculoTransporte;

    @FXML
    private TextField txtCedulaUsuariosVehiculoTransporte;

    @FXML
    private TextField txtCelularPropietario;

    @FXML
    private TextField txtColorVehiculoCarga;

    @FXML
    private TextField txtColorVehiculoTransporte;

    @FXML
    private TextField txtEdadUsuario;

    @FXML
    private TextField txtEmailPropietario;

    @FXML
    private TextField txtIDUsuario;

    @FXML
    private TextField txtMarcaVehiculoCarga;

    @FXML
    private TextField txtMarcaVehiculoTransporte;

    @FXML
    private TextField txtModeloVehiculoCarga;

    @FXML
    private TextField txtModeloVehiculoTransporte;

    @FXML
    private TextField txtNombrePropietario;

    @FXML
    private TextField txtNombreUsuario;

    @FXML
    private TextField txtNumeroEjesVehiculoCarga;

    @FXML
    private TextField txtNumeroMaxPasajerosVehiculoTransporte;

    @FXML
    private TextField txtPlacaObtenerNumeroUsuariosPlacaInicio;

    @FXML
    private TextField txtPlacaVehiculoCarga;

    @FXML
    private TextField txtPlacaVehiculoPrincipalPropietario;

    @FXML
    private TextField txtPlacaVehiculoTransporte;

    @FXML
    private TextField txtPlacaVehiculoUsuario;

    @FXML
    private TextField txtPlacaVehiculosAsociadosPropietario;

    @FXML
    private TextArea txtResultadoInicio;

    @FXML
    private TextArea txtResultadoPropietario;

    @FXML
    private TextArea txtResultadoUsuario;

    @FXML
    private TextArea txtResultadoVehiculoCarga;

    @FXML
    private TextArea txtResultadoVehiculoTransporte;

    @FXML
    void onAgregarPropietario(ActionEvent event) {
        agregarPropietario();
    }

    @FXML
    void onAgregarUsuario(ActionEvent event) {
        agregarUsuario();
    }

    @FXML
    void onAgregarVehiculoCarga(ActionEvent event) {

    }

    @FXML
    void onAgregarVehiculoTransporte(ActionEvent event) {

    }

    @FXML
    void onCalcularPasajerosTransportados(ActionEvent event) {

    }

    @FXML
    void onObtenerMayoresEdad(ActionEvent event) {

    }

    @FXML
    void onObtenerNumeroUsuariosPlaca(ActionEvent event) {

    }

    @FXML
    void initialize() {
        modelFactory = ModelFactory.getInstance();
    }

    private String construirMensajeDetallesPropietario(boolean propietarioCreado) {
        String mensaje = "";
        if (propietarioCreado) {
            mensaje = "Propietario creado exitosamente. Detalles:\n" +
                    "Nombre: " + txtNombrePropietario.getText().trim() + "\n" +
                    "Cédula: " + txtCedulaPropietario.getText().trim() + "\n" +
                    "Email: " + txtEmailPropietario.getText().trim() + "\n" +
                    "Celular: " + txtCelularPropietario.getText().trim() + "\n" +
                    "Placa Vehículo Principal: " + txtPlacaVehiculoPrincipalPropietario
                    .getText().trim() + "\n" +
                    "Placas de Vehículos Asociados: " + txtPlacaVehiculosAsociadosPropietario
                    .getText().trim();
            return mensaje;
        } else {
            mensaje = "No se pudo crear el propietario. " +
                    "Es posible que ya exista un propietario con la misma cédula.";
            return mensaje;
        }
    }

    private void agregarPropietario() {

        Vehiculo vehiculo = modelFactory.buscarVehiculo
                (txtPlacaVehiculoPrincipalPropietario.getText());

        Collection<Vehiculo> vehiculoAsociado = new LinkedList<>();
        vehiculoAsociado.add(modelFactory.buscarVehiculo
                (txtPlacaVehiculosAsociadosPropietario.getText()));


        boolean propietarioCreado = modelFactory.crearPropietario
                (txtNombrePropietario.getText(), txtCedulaPropietario.getText(),
                        txtEmailPropietario.getText(),
                        txtCelularPropietario.getText(),
                        vehiculo, vehiculoAsociado);

        txtResultadoPropietario.setText
                (construirMensajeDetallesPropietario(propietarioCreado));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Creación de Propietario");

        if (propietarioCreado) {
            String mensaje = "Propietario creado exitosamente: "
                    +txtNombrePropietario.getText() + " "
                    + txtCedulaPropietario.getText();
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
        } else {
            alert.setHeaderText(null);
            alert.setContentText("No se pudo crear el propietario.");
        }

        alert.showAndWait();
    }

    private String construirMensajeDetallesUsuario(boolean usuarioCreado) {
        String mensaje = "";
        if (usuarioCreado) {
            mensaje = "Usuario creado exitosamente. Detalles:\n" +
                    "Nombre: " + txtNombreUsuario.getText().trim() + "\n" +
                    "ID: " + txtIDUsuario.getText().trim() + "\n" +
                    "Edad: " + txtEdadUsuario.getText().trim() + "\n" +
                    "Placa Vehículo Asociado: " + txtPlacaVehiculoUsuario.getText().trim();
        } else {
            mensaje = "No se pudo crear el usuario. " +
                    "Es posible que ya exista un propietario con la misma ID.";
        }
        return mensaje;
    }

    private void agregarUsuario() {
        VehiculoTransporte vehiculoAsociado = modelFactory.buscarVehiculoTransporte
                (txtPlacaVehiculoUsuario.getText());

        boolean usuarioCreado = modelFactory.crearUsuario(
                txtNombreUsuario.getText().trim(),
                txtIDUsuario.getText().trim(),
                Integer.parseInt(txtEdadUsuario.getText().trim()),
                vehiculoAsociado);

        txtResultadoUsuario.setText
                (construirMensajeDetallesUsuario(usuarioCreado));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Creación de Usuario");

        if (usuarioCreado) {
            String mensaje = "Usuario creado exitosamente: "
                    +txtNombreUsuario.getText() + " "
                    + txtIDUsuario.getText();
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
        } else {
            alert.setHeaderText(null);
            alert.setContentText("No se pudo crear el usuario.");
        }

        alert.showAndWait();
    }



}

