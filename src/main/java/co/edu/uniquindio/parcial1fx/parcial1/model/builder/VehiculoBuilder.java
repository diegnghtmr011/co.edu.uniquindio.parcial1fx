package co.edu.uniquindio.parcial1fx.parcial1.model.builder;

import co.edu.uniquindio.parcial1fx.parcial1.model.Propietario;
import co.edu.uniquindio.parcial1fx.parcial1.model.Vehiculo;
import co.edu.uniquindio.parcial1fx.parcial1.services.IBuilder;

import java.util.Collection;
import java.util.LinkedList;

public abstract class VehiculoBuilder implements IBuilder<Vehiculo> {
    protected String placa;
    protected String modelo;
    protected String marca;
    protected String color;
    protected Propietario propietarioAsociado;
    protected Collection<Propietario>
            listaPropietariosAsociados = new LinkedList<>();

    public VehiculoBuilder setPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public VehiculoBuilder setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public VehiculoBuilder setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public VehiculoBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public VehiculoBuilder setPropietarioAsociado
            (Propietario propietarioAsociado) {
        this.propietarioAsociado = propietarioAsociado;
        return this;
    }

    public VehiculoBuilder setListaPropietariosAsociados
            (Collection<Propietario> listaPropietariosAsociados) {
        this.listaPropietariosAsociados.addAll(listaPropietariosAsociados);
        return this;
    }

    @Override
    public abstract Vehiculo build();
}