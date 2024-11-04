package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class Reserva {
    private LocalDate FechaInicio;
    private LocalDate FechaFin;
    private String id;
    private int dias;
    private LinkedList<Vehiculo>vehiculos;
    private LinkedList<Cliente>clientes ;
    private double tarifaBase = 15.0000;
    private  double tarifaAdicional =20.000;

    public Reserva(LocalDate fechaInicio, LocalDate fechaFin, String id, int dias, LinkedList<Vehiculo> vehiculos,
            LinkedList<Cliente> clientes, double tarifaBase, double tarifaAdicional) {
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
        this.id = id;
        this.dias = dias;
        this.vehiculos = vehiculos;
        this.clientes = clientes;
        this.tarifaBase = tarifaBase;
        this.tarifaAdicional = tarifaAdicional;
    }
    public LocalDate getFechaInicio() {
        return FechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio) {
        FechaInicio = fechaInicio;
    }
    public LocalDate getFechaFin() {
        return FechaFin;
    }
    public void setFechaFin(LocalDate fechaFin) {
        FechaFin = fechaFin;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getDias() {
        return dias;
    }
    public void setDias(int dias) {
        this.dias = dias;
    }
    public LinkedList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    public void setVehiculos(LinkedList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    public LinkedList<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(LinkedList<Cliente> clientes) {
        this.clientes = clientes;
    }
    public double getTarifaBase() {
        return tarifaBase;
    }
    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }
    public double getTarifaAdicional() {
        return tarifaAdicional;
    }
    public void setTarifaAdicional(double tarifaAdicional) {
        this.tarifaAdicional = tarifaAdicional;
    }


    


}
