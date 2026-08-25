package dev.francarri.ej2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class EventoUniversitarioTest {

    private EventoUniversitario eventoGratuito;
    private EventoUniversitario eventoPago;

    @BeforeEach
    void setUp() {
        eventoGratuito = new EventoUniversitario("1", "Evento Gratis", 1000.0, true);
        eventoPago = new EventoUniversitario("2", "Evento Pago", 1000.0, false);
    }

    @Test
    void calcularCostoEstimado_debeSerCeroSiEsGratuito() {
        assertEquals(0.0, eventoGratuito.calcularCostoEstimado(), 0.0001);
    }

    @Test
    void calcularCostoEstimado_debeAplicarRecargoSiNoEsGratuito() {
        // 1000 * 1.2 = 1200
        assertEquals(1200.0, eventoPago.calcularCostoEstimado(), 0.0001);
    }

    @Test
    void crearActividad_agregaActividadCuandoCupoValido() {
        int inicial = eventoPago.getActividades().size();
        eventoPago.crearActividad(10, "Charla", 5);
        assertEquals(inicial + 1, eventoPago.getActividades().size());
        Actividad act = eventoPago.getActividades().get(inicial);
        assertNotNull(act);
        assertEquals(5, act.getCupoMaximo());
    }

    @Test
    void crearActividad_noAgregaActividadCuandoCupoMenorAlMinimo() {
        int inicial = eventoPago.getActividades().size();
        eventoPago.crearActividad(11, "Charla2", 0); // menor al CUPO_MINIMO=1
        assertEquals(inicial, eventoPago.getActividades().size());
    }

    @Test
    void getCantidadEventos_incrementaAlCrearInstancias() {
        int antes = EventoUniversitario.getCantidadEventos();
        new EventoUniversitario("3", "Otro", 500.0, true);
        new EventoUniversitario("4", "Otro2", 500.0, false);
        assertEquals(antes + 2, EventoUniversitario.getCantidadEventos());
    }
}
