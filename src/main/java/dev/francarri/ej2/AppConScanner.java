package dev.francarri.ej2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppConScanner {
    public static Scanner scanner = new Scanner(System.in);

    public static Integer idEvento = 0;
    public static Integer idEstudiante = 0;
    public static Integer idActividadesTotales = 0;
    public static Integer idSala = 0;

    public static List<EventoUniversitario> eventos = new ArrayList<>();
    public static List<Estudiante> estudiantes = new ArrayList<>();
    public static List<Sala> salas = new ArrayList<>();


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
            System.out.println("6- Crear estudiante.");
            System.out.println("7- Crear Sala.");
            System.out.println("8- Asignar sala a evento.");
            System.out.println("9- Crear actividad a evento existente.");
            System.out.println("10- Inscribir estudiante a actividad.");
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
                    case 6:
                        crearEstudiante();
                        break;
                    case 7:
                        crearSala();
                        break;
                    case 8:
                        if (EventoUniversitario.getCantidadEventos() > 0 && !salas.isEmpty()) {
                            asignarSalaAEvento();
                        } else {
                            System.out.println("No hay eventos para asignar sala");
                        }
                        break;
                    case 9:
                        if(EventoUniversitario.getCantidadEventos() > 0) {
                            crearActividad();
                        } else {
                            System.out.println("No hay eventos para crear actividad");
                        }
                        break;
                    case 10:
                        if(EventoUniversitario.getCantidadEventos() > 0 && !estudiantes.isEmpty()) {
                            inscribirEstudiante();
                        } else {
                            System.out.println("No hay eventos para inscribir estudiante o no hay estudiantes registrados");
                        }
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

        EventoUniversitario evento = new EventoUniversitario(idEvento.toString(), titulo, costoBase, gratuito);
        eventos.add(evento);
        System.out.println("Evento creado con ID: " +idEvento);
       idEvento++;
    }
    public static void copiarEvento(){
        System.out.println("Diga el ID del evento que desea copiar (Recuerde existenidEventos" +
                " hasta el evento de ID " + (EventoUniversitario.getCantidadEventos()-1) + "): ");
        int idEventoACopiar = scanner.nextInt();
        scanner.nextLine();
        EventoUniversitario evento = new EventoUniversitario(eventos.get(idEventoACopiar));
        eventos.add(evento);
        System.out.println("Evento copiado con ID: " +idEvento);
       idEvento++;
        System.out.println("El evento copiado tiene el ID: " + evento.id);
    }

    public static void mostrarEvento(){
        System.out.println("Diga el ID del evento que desea mostrar: ");
        int idEventoAMostrar = scanner.nextInt();
        scanner.nextLine();
        EventoUniversitario evento = eventos.get(idEventoAMostrar);
        evento.mostrarDatos();
    }
    public static void mostrarEventos(){
        for (EventoUniversitario evento : eventos) {
            evento.mostrarDatos();
        }
    }
    public static void crearEstudiante(){
        System.out.println("Diga los datos del estudiante:");
        System.out.println("Nombre del estudiante: ");
        String nombre = scanner.nextLine();
        System.out.println("Legajo del estudiante: ");
        String legajo = scanner.nextLine();
        Estudiante estudiante = new Estudiante(nombre,legajo);
        estudiantes.add(estudiante);
    }

    public static void crearSala(){
        System.out.println("Diga los datos de la sala:");
        System.out.println("Nombre de la sala: ");
        String nombre = scanner.nextLine();
        Sala sala = new Sala(idSala, nombre);
        salas.add(sala);
        System.out.println("Sala creada con ID: " + idSala);
        idSala++;
    }

    public static void asignarSalaAEvento(){
        System.out.println("Diga el ID del evento al que desea asignar la sala, recuerde que existen eventos hasta el evento de ID : " + (EventoUniversitario.getCantidadEventos()-1) + ": ");
        int idEvento = scanner.nextInt();
        scanner.nextLine();
        EventoUniversitario evento = eventos.get(idEvento);
        System.out.println("Diga el ID de la sala que desea asignar, recuerde existen salas hasta la sala de ID : " + (idSala-1) + ":");
        int idSala = scanner.nextInt();
        scanner.nextLine();
        Sala sala = salas.get(idSala);
        evento.asignarSala(sala);
    }

    public static void crearActividad(){
        System.out.println("Diga el id del evento al que desea agregar la actividad, recuerde que existen eventos hasta el evento de ID : " + (idEvento -1) + ":");
        int idEvento = scanner.nextInt();
        scanner.nextLine();
        if (idEvento > EventoUniversitario.getCantidadEventos()) {
            System.out.println("El evento no existe");
            return;
        }
        EventoUniversitario evento = eventos.get(idEvento);
        int idActividad = evento.getActividades().size(); // Cada Evento va a tener actividades que parten desde el ID 0
        System.out.println("Diga los datos de la actividad:");
        System.out.println("Titulo de la actividad: ");
        String titulo = scanner.next();
        scanner.nextLine();
        System.out.println("Cantidad de cupos: ");
        int cupos = scanner.nextInt();
        scanner.nextLine();
        evento.crearActividad(idActividad, titulo, cupos);
        System.out.println("Actividad creada correctamente.");
    }

    public static void inscribirEstudiante(){
        System.out.println("Diga el id del evento al que desea agregar el estudiante, recuerde que existen eventos hasta el evento de ID : " + (idEvento-1) + ":");
        int idEvento = scanner.nextInt();
        scanner.nextLine();
        if (idEvento > EventoUniversitario.getCantidadEventos()) {
            System.out.println("El evento no existe");
            return;
        }
        EventoUniversitario evento = eventos.get(idEvento);
        if (evento.getActividades().isEmpty()) {
            System.out.println("El evento no tiene actividades");
            return;
        }
        System.out.println("Diga el id de la actividad al que desea inscribir el estudiante, recuerde que existen actividades de este evento hasta la actividad de ID : " + (evento.getActividades().size() -1) + ":");
        int idActividad = scanner.nextInt();
        scanner.nextLine();
        if (idActividad >= evento.getActividades().size()) {
            System.out.println("La actividad no existe");
            return;
        }
        Actividad actividad = evento.getActividades().get(idActividad);
        actividad.mostrarDatos();
        System.out.println("Cupos restantes: " + (actividad.getCupoMaximo() - actividad.inscripciones.size()) );
        if (actividad.inscripciones.size() >= actividad.getCupoMaximo()) {
            System.out.println("No hay cupos disponibles");
            return;
        }
        System.out.println("Diga el legajo del estudiante que quiere encontrar: ");
        String legajo = scanner.nextLine();
        if (legajo.isEmpty()) {
            System.out.println("El legajo no puede estar vacio");
            return;
        }
        Estudiante estudianteAInscribir = null;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getLegajo().equals(legajo)){
                estudianteAInscribir = estudiante;
            }
        }
        if (estudianteAInscribir == null) {
            System.out.println("El estudiante no existe");
            return;
        }
        Inscripcion inscripcion = actividad.inscribirEstudiante(estudianteAInscribir);
        if (inscripcion != null) {
            System.out.println("Estudiante inscrito correctamente.");
        }



    }


}
