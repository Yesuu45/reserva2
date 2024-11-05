package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Auto extends Vehiculo{
    private int puertas;



    public Auto(String matricula, String modelo, String marca, LocalDate añoFabricacion, int puertas) {
        super(matricula, modelo, marca, añoFabricacion);
        this.puertas = puertas;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    @Override
    public double calcularCosto(Reserva reserva) {
        double costoTotal;
        
        costoTotal = reserva.getTarifaBase()*reserva.getDias();
        return costoTotal;
    } 

    
    
}
