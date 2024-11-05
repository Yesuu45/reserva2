package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Moto extends Vehiculo  {
    private Caja caja ;



    public Moto(String matricula, String modelo, String marca, LocalDate añoFabricacion, Caja caja) {
        super(matricula, modelo, marca, añoFabricacion);
        this.caja = caja;
    }



    public Caja getCaja() {
        return caja;
    }



    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    @Override
    public double calcularCosto(Reserva reserva ) {

        double costoTotal;

        // Determina el costo fijo en función de la zona
        if (caja== Caja.AUTOMATICA) {
            costoTotal = (reserva.getTarifaBase() + reserva.getTarifaAdicional()) *reserva.getDias();
        } else { // Zona URBANA
            costoTotal = reserva.getTarifaBase() *reserva.getDias();
        }

        return costoTotal;
    }    

}
