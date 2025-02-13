package fp.universidades.tipos;

import java.time.LocalTime;
import java.time.Duration;
import java.time.DayOfWeek;

public record Tutoria(DayOfWeek dia, LocalTime horaInicio, LocalTime horaFin) {

    // Constructor secundario: Calcula la hora de fin a partir de la duración
    public Tutoria(DayOfWeek dia, LocalTime horaInicio, Integer duracionMinutos) {
        this(dia, horaInicio, horaInicio.plusMinutes(duracionMinutos));
    }

    public Integer duracion() {
    	// Calcula la los minutos entre la hora de inicio y la de fin, luego los convierte a int y los retorna
    	return (int) Duration.between(horaInicio, horaFin).toMinutes();
    }

    @Override
    public String toString() {
        return dia.toString().charAt(0) + " " + horaInicio + "-" + horaFin; 
    }
}
