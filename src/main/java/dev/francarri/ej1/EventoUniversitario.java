package dev.francarri.ej1;

import dev.francarri.ej2.Actividad;

import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {
    String id;
    String titulo;
    Double costoBase;
    boolean gratuito;
    private static int cantidadEventos;
    private Sala sala;

    public EventoUniversitario(String id, String titulo, Double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        cantidadEventos++;
    }
    public EventoUniversitario(EventoUniversitario otro) {
        this.id = otro.id;
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;
        cantidadEventos++;
    }
    public double calcularCostoEstimado() {
        if (gratuito) {
            return 0;
        } else {
            return costoBase * 1.2;
        }
    }
    public void asignarSala(){
        Sala sala = new Sala();
        if (sala != null) {
            System.out.println("Sala asignada correctamente.");

        }

    }
    public void crearActividad(int id, String titulo, int cupo){

    }
    public void mostrarDatos(){
        System.out.println("ID: " + id);
        System.out.println("Titulo: " + titulo);
        System.out.println("Costo Base: " + costoBase);
        System.out.println("Gratuito: " + gratuito);
    }
    public static int getCantidadEventos(){

        return cantidadEventos;
    }


}