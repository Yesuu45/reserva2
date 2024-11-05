package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

public class Empresa {
    private String nombre;
    private LinkedList<Reserva> reservas;

    public Empresa(String nombre, LinkedList<Reserva> reservas) {
        this.nombre = nombre;
        this.reservas = reservas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(LinkedList<Reserva> reservas) {
        this.reservas = reservas;
    }

    // Método para agregar una reserva
    public boolean agregarReserva(Reserva reserva) {
        if (reserva == null) {
            return false; // No se puede agregar una reserva nula
        }
        
        // Verificar si la reserva ya existe
        if (!verificarReserva(reserva)) {
            reservas.add(reserva);
            return true; // Indica que se ha agregado la reserva
        }
        
        return false; // Indica que la reserva ya existe
    }

    // Método para eliminar una reserva
    public boolean eliminarReserva(Reserva reserva) {
        return reservas.remove(reserva); // Retorna true si la reserva fue eliminada, false si no estaba
    }

    // Método para verificar si una reserva ya existe
    private boolean verificarReserva(Reserva reserva) {
        return reservas.contains(reserva); // Asegúrate de que Reserva tenga equals() y hashCode() bien implementados
    }
}
