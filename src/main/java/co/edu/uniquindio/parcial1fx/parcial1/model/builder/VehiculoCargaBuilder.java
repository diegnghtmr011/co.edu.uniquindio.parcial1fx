package co.edu.uniquindio.parcial1fx.parcial1.model.builder;

import co.edu.uniquindio.parcial1fx.parcial1.model.VehiculoCarga;

public class VehiculoCargaBuilder extends VehiculoBuilder {
    private double capacidadCarga;
    private int numeroEjes;

    public VehiculoCargaBuilder setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
        return this;
    }

    public VehiculoCargaBuilder setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
        return this;
    }

    @Override
    public VehiculoCarga build() {
        return new VehiculoCarga(placa, modelo, modelo, color,
                propietarioAsociado, listaPropietariosAsociados,
                capacidadCarga, numeroEjes);
    }
}
