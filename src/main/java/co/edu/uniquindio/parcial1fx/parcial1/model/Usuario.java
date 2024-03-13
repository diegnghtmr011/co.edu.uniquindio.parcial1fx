package co.edu.uniquindio.parcial1fx.parcial1.model;

public class Usuario {
    private String nombre;
    private String ID;
    private int edad;
    private VehiculoTransporte vehiculoTransporteAsociado;

    public Usuario(String nombre, String ID, int edad,
                   VehiculoTransporte vehiculoTransporteAsociado) {
        this.nombre = nombre;
        this.ID = ID;
        this.edad = edad;
        this.vehiculoTransporteAsociado = vehiculoTransporteAsociado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getID() {
        return ID;
    }

    public int getEdad() {
        return edad;
    }

    public VehiculoTransporte getVehiculoTransporteAsociado() {
        return vehiculoTransporteAsociado;
    }

}
