package co.edu.uniquindio.parcial1fx.parcial1.factory;

import co.edu.uniquindio.parcial1fx.parcial1.model.*;
import co.edu.uniquindio.parcial1fx.parcial1.model.builder.*;

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
                .build();

        Propietario propietario02 = new PropietarioBuilder()
                .setNombre("Maria")
                .setCedula("987654321")
                .setEmail("maria123@example.com")
                .setCelular("3105678901")
                .build();

        Propietario propietario03 = new PropietarioBuilder()
                .setNombre("Carlos")
                .setCedula("246810121")
                .setEmail("carlos456@example.com")
                .setCelular("3156789012")
                .build();

        Usuario usuario01 = new UsuarioBuilder()
                .setNombre("Alvaro")
                .setID("495543432")
                .setEdad(55)
                .build();

        Usuario usuario02 = new UsuarioBuilder()
                .setNombre("Beatriz")
                .setID("876543219")
                .setEdad(45)
                .build();

        Usuario usuario03 = new UsuarioBuilder()
                .setNombre("Carlos")
                .setID("123456789")
                .setEdad(60)
                .build();

        VehiculoCarga vehiculoCarga01 = new VehiculoCargaBuilder()
                .setPlaca("XYZ987")
                .setModelo("2015")
                .setMarca("Tinto")
                .setColor("Rojo")
                .setCapacidadCarga(20.5)
                .setNumeroEjes(4)
                .build();

        VehiculoCarga vehiculoCarga02 = new VehiculoCargaBuilder()
                .setPlaca("LMN654")
                .setModelo("2017")
                .setMarca("CargaExpress")
                .setColor("Verde")
                .setCapacidadCarga(25.0)
                .setNumeroEjes(6)
                .build();

        VehiculoCarga vehiculoCarga03 = new VehiculoCargaBuilder()
                .setPlaca("RST321")
                .setModelo("2018")
                .setMarca("MaxiCarga")
                .setColor("Azul")
                .setCapacidadCarga(30.0)
                .setNumeroEjes(8)
                .build();

        VehiculoTransporte vehiculoTransporte01 = new VehiculoTransporteBuilder()
                .setPlaca("ABC123")
                .setModelo("2019")
                .setMarca("Copetran")
                .setColor("Negro")
                .setNumeroMaxPasajeros(30)
                .build();

        VehiculoTransporte vehiculoTransporte02 = new VehiculoTransporteBuilder()
                .setPlaca("DEF456")
                .setModelo("2020")
                .setMarca("Berlinas")
                .setColor("Blanco")
                .setNumeroMaxPasajeros(40)
                .build();

        VehiculoTransporte vehiculoTransporte03 = new VehiculoTransporteBuilder()
                .setPlaca("GHI789")
                .setModelo("2021")
                .setMarca("Flota Magdalena")
                .setColor("Azul")
                .setNumeroMaxPasajeros(50)
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

    public Vehiculo buscarVehiculo(String placa) {
        return empresaTransporte.obtenerVehiculo(placa);
    }

    public VehiculoTransporte buscarVehiculoTransporte(String placa) {
        return empresaTransporte.obtenerVehiculoTransporte(placa);
    }
}
