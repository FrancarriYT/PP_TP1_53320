package dev.francarri.ej2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ActividadTest {

    @Test
    void inscribirEstudiante_devuelveInscripcionYAgregaCuandoHayCupo() {
        Actividad actividad = new Actividad(1, "Charla", 2);
        Estudiante s1 = new Estudiante("Ana", "100");

        Inscripcion insc = actividad.inscribirEstudiante(s1);

        assertNotNull(insc);
        assertEquals(1, actividad.inscripciones.size());
        assertEquals("Ana", actividad.inscripciones.getFirst().getEstudiante().getNombre());
    }

    @Test
    void inscribirEstudiante_devuelveNullCuandoNoHayCupo() {
        Actividad actividad = new Actividad(1, "Charla", 1);
        Estudiante s1 = new Estudiante("Ana", "100");
        Estudiante s2 = new Estudiante("Beto", "200");

        assertNotNull(actividad.inscribirEstudiante(s1));
        assertNull(actividad.inscribirEstudiante(s2));
        assertEquals(1, actividad.inscripciones.size());
    }
}
