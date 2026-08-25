package dev.francarri.ej3;


import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<Estudiante> estudiantes = new ArrayList<>();
        List<EventoUniversitario> eventos = new ArrayList<>();
        List<Sala> salas = new ArrayList<>();
        Sala sala = new Sala(1, "Backrooms");
        salas.add(sala);
        Estudiante estudiante1 = new Estudiante("Santiago", "676767");
        Estudiante estudiante2 = new Estudiante("Juani", "20340");

        EventoUniversitario evento1 = new EventoUniversitario("10020", "Reunion Importante", 2000.0, false);
        EventoUniversitario evento2 = new EventoUniversitario(evento1);
        eventos.add(evento1);
        eventos.add(evento2);

        evento1.asignarSala(salas.getFirst());
        evento1.crearCharla(1, "Sistemas Operativos para ignorantes", 80, "Terry Davis");
        evento2.crearTaller(2,"Desarrollo de Apps", 50, true);
        evento2.crearTaller(3, "Desarrollo de Webs", 70, true);

        for (Estudiante estudiante: estudiantes){
            for (EventoUniversitario eventoUniversitario : eventos){
                for (Taller taller : eventoUniversitario.getTalleres()){
                    taller.inscribirEstudiante(estudiante);
                }

                for (Charla charla : eventoUniversitario.getCharlas()){
                    charla.inscribirEstudiante(estudiante);
                }
            }
        }

        for (EventoUniversitario eventoUniversitario : eventos){
            eventoUniversitario.mostrarDatos();
        }
    }
}
