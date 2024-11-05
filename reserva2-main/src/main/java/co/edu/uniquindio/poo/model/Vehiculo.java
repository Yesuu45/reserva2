package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public abstract class Vehiculo {
    public String matricula;
    public String modelo;
    public String marca ;
    public LocalDate añoFabricacion;


    public Vehiculo(String matricula, String modelo, String marca, LocalDate añoFabricacion) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.añoFabricacion = añoFabricacion;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public LocalDate getAñoFabricacion() {
        return añoFabricacion;
    }
    public void setAñoFabricacion(LocalDate añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    } 

    public abstract double calcularCosto(Reserva reserva);
    @Override
    public String toString() {
        return   matricula + " " + modelo + " " + marca + " "
                + añoFabricacion ;
    }

    
}


