package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Camion extends Vehiculo{

    private double capacidadCarga;



    public Camion(String matricula, String modelo, String marca, LocalDate añoFabricacion, double capacidadCarga) {
        super(matricula, modelo, marca, añoFabricacion);
        this.capacidadCarga = capacidadCarga;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public double calcularCosto(Reserva reserva) {
        double costoTotal;
        double porcentajeExtra = 0.05;
        costoTotal = (reserva.getTarifaBase()*reserva.getDias() )+ (capacidadCarga *porcentajeExtra*reserva.getTarifaBase());
        return costoTotal;
    }

    
    
}
