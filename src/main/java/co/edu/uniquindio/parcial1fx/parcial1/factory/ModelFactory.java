package co.edu.uniquindio.parcial1fx.parcial1.factory;

import co.edu.uniquindio.parcial1fx.parcial1.model.*;
import co.edu.uniquindio.parcial1fx.parcial1.model.builder.EmpresaTransporteBuilder;
import co.edu.uniquindio.parcial1fx.parcial1.model.builder.PropietarioBuilder;
import co.edu.uniquindio.parcial1fx.parcial1.model.builder.VehiculoTransporteBuilder;

import java.util.Collection;

public class ModelFactory {
    private static ModelFactory modelFactory;

    private EmpresaTransporte empresaTransporte;

    private ModelFactory() {
        empresaTransporte = new EmpresaTransporteBuilder().build();
        inicializarDatos();
    }

    public static ModelFactory getInstance() {
        if (modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private void inicializarDatos() {

        Propietario propietario01 = new PropietarioBuilder()
                .setNombre("Juan")
                .setCedula("123456789")
                .setEmail("juan777@example.com")
                .setCelular("3024567033")
                .setVehiculoPrincipal(vehiculoTransporte01)
                .build();

        VehiculoTransporte vehiculoTransporte01 = new VehiculoTransporteBuilder()
                .setPlaca("ABC123")
                .setModelo("2019")
                .setMarca("Copetran")
                .setColor("Negro")
                .setPropietarioAsociado(propietario01)
                .setNumeroMaxPasajeros(30)
                .build();

    }

    public boolean crearPropietario(String nombre, String cedula,
                                    String email, String celular,
                                    Vehiculo vehiculoPrincipal,
                                    Collection<Vehiculo> listaVehiculosAsociados) {
        return empresaTransporte.crearPropetario(nombre, cedula, email,
                celular, vehiculoPrincipal, listaVehiculosAsociados);

    }

    public boolean crearUsuario(String nombre, String ID, int edad,
                                VehiculoTransporte vehiculoTransporteAsociado) {
        return empresaTransporte.crearUsuario(nombre, ID, edad,
                vehiculoTransporteAsociado);
    }

    public boolean crearVehiculoCarga(String placa, String modelo,
                                      String marca, String color,
                                      Propietario propietarioAsociado,
                                      Collection<Propietario> listaPropietariosAsociados,
                                      double capacidadCarga, int numeroEjes) {
        return empresaTransporte.crearVehiculoCarga(placa, modelo, marca, color,
                propietarioAsociado, listaPropietariosAsociados,
                capacidadCarga, numeroEjes);
    }

    public boolean crearVehiculoTransporte(String placa, String modelo,
                                           String marca, String color,
                                           Propietario propietarioAsociado,
                                           Collection<Propietario> listaPropietariosAsociados,
                                           int numeroMaxPasajeros,
                                           Collection<Usuario> listaUsuariosAsociados) {
        return empresaTransporte.crearVehiculoTransporte(placa, modelo, marca,
                color, propietarioAsociado, listaPropietariosAsociados,
                numeroMaxPasajeros, listaUsuariosAsociados);
    }
}
