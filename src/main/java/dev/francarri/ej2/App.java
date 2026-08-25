package dev.francarri.ej2;



import java.util.ArrayList;
import java.util.List;


public class App {

    public static Integer id = 0;
    public static List<EventoUniversitario> eventos = new ArrayList<>();
    public static List<Estudiante> estudiantes = new ArrayList<>();

    public static void main(String[] args) {
        EventoUniversitario evento1 = new EventoUniversitario(((Integer) (eventos.size())).toString(),
                "Evento de Sistemas", 1000.00, true);
        EventoUniversitario evento2 = new EventoUniversitario(evento1);
        Estudiante santi = new Estudiante("Santi", "67");
        Estudiante juani = new Estudiante("Juani", "6767");
        estudiantes.add(santi);
        estudiantes.add(juani);



        evento1.crearActividad(1,"Charla de Ray Tracing",60);
        evento1.crearActividad(2,"Charla de DLSS",65);

        evento2.crearActividad(3,"Charla de Path Tracing",60);
        evento2.crearActividad(4,"Charla de Nvenc",80);

        for (Estudiante estudiante : estudiantes){
            for (EventoUniversitario evento : eventos){
                for (Actividad actividad : evento.getActividades()){
                    actividad.inscribirEstudiante(estudiante);
                }
            }
        }

        for (EventoUniversitario evento : eventos){
            evento.mostrarDatos();
        }

        System.out.println("Cantidad de eventos: " + EventoUniversitario.getCantidadEventos());
    }
}
