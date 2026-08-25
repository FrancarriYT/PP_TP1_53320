package dev.francarri.ej1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppConScanner {
    public static Scanner scanner = new Scanner(System.in);
    public static Integer id = 0;
    public static List<EventoUniversitario> eventos = new ArrayList<>();
    public static void main(String[] args) {
        //Declaro el Scanner

        System.out.println("Bienvenido al programa de eventos");
        int opcion = 0;

        do {
            System.out.println("");
            System.out.println("Seleccione que hacer:");
            System.out.println("1. Crear evento.");
            System.out.println("2. Copiar evento.");
            System.out.println("3. Mostrar datos de evento.");
            System.out.println("4. Mostrar todos los datos de todos los eventos.");
            System.out.println("5. Cantidad de eventos.");
            System.out.println("67. Salir.");
            opcion = scanner.nextInt();
            scanner.nextLine();
            try {
                switch(opcion) {
                    case 1: crearEvento();
                    break;
                    case 2:
                        if (EventoUniversitario.getCantidadEventos() >0) {
                            copiarEvento();
                        } else {
                            System.out.println("No hay eventos para copiar");
                        }
                        break;
                    case 3:
                        if (EventoUniversitario.getCantidadEventos() >0) {
                        mostrarEvento();
                        } else {
                            System.out.println("No hay eventos para mostrar");
                        }
                    break;
                    case 4:
                        if (EventoUniversitario.getCantidadEventos() >0) {
                        mostrarEventos();
                        } else {
                        System.out.println("No hay eventos");
                    }
                    break;
                    case 5: System.out.println("Cantidad de eventos: " + EventoUniversitario.getCantidadEventos() + ".");
                    break;
                    default: System.out.println("Opcion no valida");
                }
            } catch (Exception e) {
                System.out.println( "Error: " + e.getMessage());
            }
        } while (opcion != 67);
    }

    public static void crearEvento(){

        System.out.println("Diga los datos del evento:");
        System.out.println("Titulo del evento: ");
        String titulo = scanner.nextLine();
        System.out.println("Costo base del evento: ");
        Double costoBase = scanner.nextDouble();
        System.out.println("Es gratuito? (true/false): ");
        Boolean gratuito = scanner.nextBoolean();

        EventoUniversitario evento = new EventoUniversitario(id.toString(), titulo, costoBase, gratuito);
        eventos.add(evento);
        System.out.println("Evento creado con ID: " + id);
        id++;
    }
    public static void copiarEvento(){
        System.out.println("Diga el ID del evento que desea copiar (Recuerde existen ids" +
                " hasta el evento de ID " + (EventoUniversitario.getCantidadEventos()-1) + "): ");
        int idEventoACopiar = scanner.nextInt();
        EventoUniversitario evento = new EventoUniversitario(eventos.get(idEventoACopiar));
        eventos.add(evento);
        System.out.println("Evento copiado con ID: " + id);
        id++;
        System.out.println("El evento copiado tiene el ID: " + evento.id);
    }

    public static void mostrarEvento(){
        System.out.println("Diga el ID del evento que desea mostrar: ");
        int idEvento = scanner.nextInt();
        EventoUniversitario evento = eventos.get(idEvento);
        evento.mostrarDatos();
    }
    public static void mostrarEventos(){
        for (EventoUniversitario evento : eventos) {
            evento.mostrarDatos();

        }
    }
}
