package co.edu.uniquindio.poo.Controller;

import java.util.ArrayList;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;

public class ReservaController {
    private ArrayList<Reserva> listaReservas;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Vehiculo> listaVehiculos;
    
    Empresa empresa ;

    public void setListaClientes(ArrayList <Cliente> listaClientes){
        this.listaClientes=listaClientes;
    }

    public void setListaVehiculos(ArrayList <Vehiculo> listaVehiculos){
        this.listaVehiculos=listaVehiculos;
    }

    public void setListaReservas(ArrayList <Reserva> listaReservas){

    }

    public ReservaController(Empresa empresa ){
        this.empresa=empresa;
        this.listaClientes= new ArrayList<>();
        this.listaVehiculos= new ArrayList<>();
        this.listaReservas= new ArrayList<>();
    }

    public Reserva buscarReservaPorId(String IdReserva ){
        for (Reserva reserva : listaReservas){
            if (reserva.getId().equals(IdReserva)){
                return reserva;
            }
        }
        System.out.println("Reserva con Id "+ IdReserva +"no encontrada ");
        return null;

    }

    public void agregarReserva(Reserva reserva){
        // !=null La reserva existe
        if (reserva !=null && !listaReservas.contains(reserva)){
            listaReservas.add(reserva);
        }else{
            System.out.println("Reserva ya existe o es nulo ");
        }
    }

    public Cliente buscarClientePorNombre(String nombreCliente) {
        for (Cliente cliente : listaClientes) {
            // equals ignore case = no importa si es mayuscula o minuscula
            if (cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
                return cliente;
            }
        }
        System.out.println("Cliente con nombre " + nombreCliente + " no encontrado.");
        return null;
    }

    public void agregarCliente(Cliente cliente) {
        //Verifica una secuencia
        if (cliente != null && !listaClientes.contains(cliente)) {
            listaClientes.add(cliente);
        } else {
            System.out.println("Cliente ya existe o es nulo.");
        }
    }

    public Vehiculo buscarVehiculoPorMatricula(String matriculaVehiculo){
        for (Vehiculo vehiculo : listaVehiculos){
            //NO importa mayusculas y minusculas
            if (vehiculo.getMatricula().equalsIgnoreCase(matriculaVehiculo)){
                return vehiculo;
            }
        }
        System.out.println("Vehiculo con matricula "+ matriculaVehiculo +" no encontrado ");
        return null;
    }

    public void agregarVehiculo(Vehiculo vehiculo){
        if(vehiculo !=null && !listaVehiculos.contains(vehiculo)){
            listaVehiculos.add(vehiculo);
        }else{
            System.out.println("Vehiculo ya existe o es nulo ");
        }
    }


    public ArrayList<Reserva> getListaReservas(){
        return listaReservas;
    }

    public ArrayList<Reserva> obtenerTodasLasReservas(){
        return new ArrayList<>(listaReservas);
    }

    public ArrayList<Vehiculo> getListaVehiculos(){
        return listaVehiculos;
    }

    public ArrayList<Vehiculo> obtenerTodosLosVehiculos(){
        return new ArrayList<>(listaVehiculos);
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public ArrayList<Cliente> obtenerTodosLosClientes() {
        return new ArrayList<>(listaClientes);
    }
}
