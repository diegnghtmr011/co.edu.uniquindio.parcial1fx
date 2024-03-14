package co.edu.uniquindio.parcial1fx.parcial1.controller;

import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.parcial1fx.parcial1.factory.ModelFactory;
import co.edu.uniquindio.parcial1fx.parcial1.model.Propietario;
import co.edu.uniquindio.parcial1fx.parcial1.model.Usuario;
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
    private TextField txtIDUsuariosVehiculoTransporte;

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
        agregarVehiculoCarga();
    }

    @FXML
    void onAgregarVehiculoTransporte(ActionEvent event) {
        agregarVehiculoTransporte();
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

        Collection<Vehiculo> vehiculosAsociados = new LinkedList<>();
        vehiculosAsociados.add(modelFactory.buscarVehiculo
                (txtPlacaVehiculosAsociadosPropietario.getText()));


        boolean propietarioCreado = modelFactory.crearPropietario
                (txtNombrePropietario.getText(), txtCedulaPropietario.getText(),
                        txtEmailPropietario.getText(),
                        txtCelularPropietario.getText(),
                        vehiculo, vehiculosAsociados);

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

    private String construirMensajeDetallesVehiculoCarga(boolean vehiculoCargaCreado) {
        String mensaje = "";
        if (vehiculoCargaCreado) {
            mensaje = "Vehículo de Carga creado exitosamente. Detalles:\n" +
                    "Placa: " + txtPlacaVehiculoCarga.getText().trim() + "\n" +
                    "Modelo: " + txtModeloVehiculoCarga.getText().trim() + "\n" +
                    "Marca: " + txtMarcaVehiculoCarga.getText().trim() + "\n" +
                    "Color: " + txtColorVehiculoCarga.getText().trim() + "\n" +
                    "Capacidad de Carga: " + txtCapacidadCargaVehiculoCarga.getText().trim() + "\n" +
                    "Número de Ejes: " + txtNumeroEjesVehiculoCarga.getText().trim() + "\n" +
                    "Cédula Propietario: " + txtCedulaPropietarioVehiculoCarga.getText().trim() + "\n" +
                    "Cédulas de Propietarios Asociados: " + txtCedulaAsociadosVehiculoCarga.getText().trim();
            return mensaje;
        } else {
            mensaje = "No se pudo crear el vehículo de carga. " +
                    "Es posible que ya exista un vehículo con la misma placa.";
            return mensaje;
        }
    }

    private void agregarVehiculoCarga() {
        Propietario propietario = modelFactory.buscarPropietario
                (txtCedulaPropietarioVehiculoCarga.getText());

        Collection<Propietario> propietariosAsociados = new LinkedList<>();
        propietariosAsociados.add(modelFactory.buscarPropietario
                (txtCedulaAsociadosVehiculoCarga.getText()));

        boolean vehiculoCargaCreado = modelFactory.crearVehiculoCarga
                (txtPlacaVehiculoCarga.getText(), txtModeloVehiculoCarga.getText(),
                        txtMarcaVehiculoCarga.getText(), txtColorVehiculoCarga.getText(),
                        propietario, propietariosAsociados,
                        Double.parseDouble(txtCapacidadCargaVehiculoCarga.getText()),
                        Integer.parseInt(txtNumeroEjesVehiculoCarga.getText()));

        txtResultadoVehiculoCarga.setText
                (construirMensajeDetallesVehiculoCarga(vehiculoCargaCreado));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Creación de Vehículo de Carga");

        if (vehiculoCargaCreado) {
            String mensaje = "Vehículo de Carga creado exitosamente: "
                    +txtPlacaVehiculoCarga.getText();
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
        } else {
            alert.setHeaderText(null);
            alert.setContentText("No se pudo crear el vehículo de carga.");
        }

        alert.showAndWait();
    }

    private String construirMensajeDetallesVehiculoTransporte(boolean vehiculoTransporteCreado) {
        String mensaje = "";
        if (vehiculoTransporteCreado) {
            mensaje = "Vehículo de Transporte creado exitosamente. Detalles:\n" +
                    "Placa: " + txtPlacaVehiculoTransporte.getText().trim() + "\n" +
                    "Modelo: " + txtModeloVehiculoTransporte.getText().trim() + "\n" +
                    "Marca: " + txtMarcaVehiculoTransporte.getText().trim() + "\n" +
                    "Color: " + txtColorVehiculoTransporte.getText().trim() + "\n" +
                    "Cédula Propietario: " + txtCedulaPropietarioVehiculoTransporte.getText().trim() + "\n" +
                    "Cédulas de Propietarios Asociados: " + txtCedulaAsociadosVehiculoTransporte.getText().trim() + "\n" +
                    "ID Usuarios Asociados: " + txtIDUsuariosVehiculoTransporte.getText().trim() + "\n" +
                    "Número Máximo de Pasajeros: " + txtNumeroMaxPasajerosVehiculoTransporte.getText().trim();
            return mensaje;
        } else {
            mensaje = "No se pudo crear el vehículo de transporte. " +
                    "Es posible que ya exista un vehículo con la misma placa.";
            return mensaje;
        }
    }

    private void agregarVehiculoTransporte() {
        Propietario propietario = modelFactory.buscarPropietario
                (txtCedulaPropietarioVehiculoTransporte.getText());

        Collection<Propietario> propietariosAsociados = new LinkedList<>();
        propietariosAsociados.add(modelFactory.buscarPropietario
                (txtCedulaAsociadosVehiculoTransporte.getText()));

        Collection<Usuario> usuariosAsociados = new LinkedList<>();
        usuariosAsociados.add(modelFactory.buscarUsuario
                (txtIDUsuariosVehiculoTransporte.getText()));

        boolean vehiculoTransporteCreado = modelFactory.crearVehiculoTransporte
                (txtPlacaVehiculoTransporte.getText(), txtModeloVehiculoTransporte.getText(),
                        txtMarcaVehiculoTransporte.getText(),
                        txtColorVehiculoTransporte.getText(), propietario,
                        propietariosAsociados,
                        Integer.parseInt(txtNumeroMaxPasajerosVehiculoTransporte.getText()),
                        usuariosAsociados);

        txtResultadoVehiculoTransporte.setText
                (construirMensajeDetallesVehiculoTransporte(vehiculoTransporteCreado));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Creación de Vehículo de Transporte");

        if (vehiculoTransporteCreado) {
            String mensaje = "Vehículo de Transporte creado exitosamente: "
                    +txtPlacaVehiculoTransporte.getText();
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
        } else {
            alert.setHeaderText(null);
            alert.setContentText("No se pudo crear el vehículo de transporte.");
        }

        alert.showAndWait();
    }
}

