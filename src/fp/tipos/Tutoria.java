package fp.tipos;

import java.time.LocalTime;
import java.time.Duration;
import java.time.DayOfWeek;
import java.util.Map;

import fp.utiles.Checkers;

public record Tutoria(DayOfWeek dia, LocalTime horaInicio, LocalTime horaFin, Integer duracion) implements Comparable<Tutoria>{

	//mapeando el valor de dia
	private static final Map<DayOfWeek, Character> DIA_MAP = Map.of(
            DayOfWeek.MONDAY, 'L',
            DayOfWeek.TUESDAY, 'M',
            DayOfWeek.WEDNESDAY, 'X',
            DayOfWeek.THURSDAY, 'J',
            DayOfWeek.FRIDAY, 'V'
        );
	
	//Constructor que comprueba las restricciones
	public Tutoria{
		 Checkers.check("La duracion ha de ser de minimo de 15 minutos", duracion >= 15); 
	     Checkers.check("La hora de inicio debe ser antes que la hora de fin", horaInicio.isBefore(horaFin));
	     Checkers.check("Las tutorias son le lunes a viernes", !dia.equals(DayOfWeek.SATURDAY) && !dia.equals(DayOfWeek.SUNDAY));
	}
	
    // Constructor con hora de inicio y fin (calcula duración automáticamente)
    public Tutoria(DayOfWeek dia, LocalTime horaInicio, LocalTime horaFin) { 
        this(dia, horaInicio.withNano(0), horaFin.withNano(0), (int) Duration.between(horaInicio, horaFin).toMinutes());
    }

    // Constructor con hora de inicio y duración (calcula hora de fin automáticamente)
    public Tutoria(DayOfWeek dia, LocalTime horaInicio, int duracion) { 
        this(dia, horaInicio.withNano(0), horaInicio.plusMinutes(duracion).withNano(0), duracion);
    }
	
	
	private Character diaChar() { 
		return DIA_MAP.get(dia);
	}

    
    @Override
    public String toString() {
        return diaChar() + " " + horaInicio + "-" + horaFin; 
    }
    
    @Override
    public boolean equals(Object obj) { 
    	if(this == obj)
    		return true; 
    	if(obj == null)
    		return false; 
    	if(getClass() != obj.getClass())
    		return false; 
    	Tutoria other = (Tutoria) obj; 
    	return this.dia.equals(other.dia) && this.horaInicio.equals(other.horaInicio);    
    }
    
    @Override 
    public int compareTo(Tutoria o) { 
    	int codigoDia = this.dia.compareTo(o.dia);
    	if(codigoDia != 0)
    		return codigoDia; 
    	return this.horaInicio.compareTo(o.horaInicio);
    }
}
