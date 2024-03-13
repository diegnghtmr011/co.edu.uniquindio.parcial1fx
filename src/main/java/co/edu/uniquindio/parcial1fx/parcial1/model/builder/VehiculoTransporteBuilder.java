package co.edu.uniquindio.parcial1fx.parcial1.model.builder;

import co.edu.uniquindio.parcial1fx.parcial1.model.Usuario;
import co.edu.uniquindio.parcial1fx.parcial1.model.VehiculoTransporte;

import java.util.Collection;
import java.util.LinkedList;

public class VehiculoTransporteBuilder extends VehiculoBuilder {
    private int numeroMaxPasajeros;
    private Collection<Usuario> listaUsuariosAsociados = new LinkedList<>();

    public VehiculoTransporteBuilder setNumeroMaxPasajeros
            (int numeroMaxPasajeros) {
        this.numeroMaxPasajeros = numeroMaxPasajeros;
        return this;
    }

    public VehiculoTransporteBuilder setListaUsuariosAsociados
            (Collection<Usuario> listaUsuariosAsociados) {
        this.listaUsuariosAsociados.addAll(listaUsuariosAsociados);
        return this;
    }

    @Override
    public VehiculoTransporte build() {
        return new VehiculoTransporte(placa, modelo, modelo, color,
                propietarioAsociado, listaPropietariosAsociados,
                numeroMaxPasajeros, listaUsuariosAsociados);
    }
}
