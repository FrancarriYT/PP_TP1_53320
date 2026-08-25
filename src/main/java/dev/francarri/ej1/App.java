package dev.francarri.ej1;

import java.util.ArrayList;
import java.util.List;


public class App {

    public static Integer id = 0;
    public static List<EventoUniversitario> eventos = new ArrayList<>();

    public static void main(String[] args) {
        EventoUniversitario evento1 = new EventoUniversitario("1",
                "Charla de Sistemas", 1000.00, true);
        EventoUniversitario evento2 = new EventoUniversitario(evento1);
        eventos.add(evento1);
        eventos.add(evento2);
        for (EventoUniversitario evento : eventos){
            evento.mostrarDatos();
        }

        System.out.println("Cantidad de eventos: " + EventoUniversitario.getCantidadEventos());
    }
}
