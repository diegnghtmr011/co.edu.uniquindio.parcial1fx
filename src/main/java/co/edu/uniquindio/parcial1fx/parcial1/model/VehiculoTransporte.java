package co.edu.uniquindio.parcial1fx.parcial1.model;

import java.util.Collection;
import java.util.Collections;

public class VehiculoTransporte extends Vehiculo {
    private int numeroMaxPasajeros;
    private Collection<Usuario> listaUsuariosAsociados;

    public VehiculoTransporte(String placa, String modelo,
                              String marca, String color,
                              Propietario propietarioAsociado,
                              Collection<Propietario> listaPropietariosAsociados,
                              int numeroMaxPasajeros,
                              Collection<Usuario> listaUsuariosAsociados) {
        super(placa, modelo, marca, color, propietarioAsociado, listaPropietariosAsociados);

        this.numeroMaxPasajeros = numeroMaxPasajeros;
        this.listaUsuariosAsociados = listaUsuariosAsociados;
    }

    public int getNumeroMaxPasajeros() {
        return numeroMaxPasajeros;
    }

    public Collection<Usuario> getListaUsuariosAsociados() {
        return Collections.unmodifiableCollection(listaUsuariosAsociados);
    }

    public void agregarUsuarioAsociado(Usuario usuario) {
        this.listaUsuariosAsociados.add(usuario);
    }

    public void eliminarUsuarioAsociado(Usuario usuario) {
        this.listaUsuariosAsociados.remove(usuario);
    }
}
