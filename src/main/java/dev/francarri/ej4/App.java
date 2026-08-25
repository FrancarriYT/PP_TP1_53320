package dev.francarri.ej4;




import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<Estudiante> estudiantes = new ArrayList<>();
        List<EventoUniversitario> eventos = new ArrayList<>();
        List<Sala> salas = new ArrayList<>();
        Sala sala = new Sala(1, "Temple OS Room");
        Estudiante estudiante1 = new Estudiante("Santiago", "676767");
        Estudiante estudiante2 = new Estudiante("Juani", "20340");
        Estudiante estudiante3 = new Estudiante("Agus", "12067");
        EventoUniversitario evento = new EventoUniversitario("1","Reunion extracurricular", 1000.67, false);
        evento.asignarSala(sala);
        evento.crearCharla(1,"Charla de Fisica", 70, "David Ribon");
        evento.crearTaller(2, "Pseint", 000067, false);
        evento.getCharlas().getFirst().inscribirEstudiante(estudiante1);
        evento.getCharlas().getFirst().inscribirEstudiante(estudiante2);

        evento.getTalleres().getFirst().inscribirEstudiante(estudiante2);
        evento.getTalleres().getFirst().inscribirEstudiante(estudiante3);
    }
}
