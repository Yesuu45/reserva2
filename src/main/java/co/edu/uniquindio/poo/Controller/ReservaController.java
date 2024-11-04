package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class ReservaController {
    private ArrayList<Reserva> listaReservas;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Vehiculo> listaVehiculos;
    
    Empresa empresa ;

    public ReservaController(Empresa empresa ){
        this.empres = empresa;
    }

    public boolean crearReserva(Reserva reserva){
        return empresa.agregarReserva(Reserva reserva);
    }

    public Collection<Reserva> obtenerListaReservas(){
        return empresa.getReservas();
    }

    public boolean eliminaReserva(Reserva reserva){
        return empresa.eliminarReserva(reserva);
    }




}
