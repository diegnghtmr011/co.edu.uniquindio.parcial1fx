package co.edu.uniquindio.parcial1fx.parcial1.factory;

import co.edu.uniquindio.parcial1fx.parcial1.model.*;
import co.edu.uniquindio.parcial1fx.parcial1.model.builder.EmpresaTransporteBuilder;

import java.util.Collection;

public class ModelFactory {
    private static ModelFactory modelFactory;

    private EmpresaTransporte empresaTransporte;

    private ModelFactory() {
        empresaTransporte = new EmpresaTransporteBuilder().build();
    }

    public static ModelFactory getInstance() {
        if (modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
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
