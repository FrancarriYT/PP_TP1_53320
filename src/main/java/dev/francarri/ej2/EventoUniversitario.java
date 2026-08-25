package dev.francarri.ej2;

import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {
    String id;
    String titulo;
    Double costoBase;
    boolean gratuito;
    private static int cantidadEventos;
    private Sala sala;
    private List<Actividad> actividades = new ArrayList<>();

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
    public void asignarSala(Sala sala){
        if (sala != null) {
            this.sala = sala;
        }
        System.out.println("Sala asignada correctamente.");
    }
    public void crearActividad(int id, String titulo, int cupo){
        if (cupo >= Actividad.CUPO_MINIMO) {
            Actividad actividad = new Actividad(id,titulo,cupo);
            actividades.add(actividad);
            System.out.println("Actividad creada correctamente.");
        }
    }
    public void mostrarDatos(){
        System.out.println("ID: " + id);
        System.out.println("Titulo: " + titulo);
        System.out.println("Costo Base: " + costoBase);
        System.out.println("Gratuito: " + gratuito);
        System.out.println("Costo Final: " + calcularCostoEstimado());
        System.out.println("Sala: " + sala);
        System.out.println("Actividades: ");
        System.out.println();
        for (Actividad actividad : actividades) {
            actividad.mostrarDatos();
        }
    }
    public static int getCantidadEventos(){

        return cantidadEventos;
    }

    public List<Actividad> getActividades() { //agregado porque si no imposible hacer ejercicio
        return actividades;
    }
}