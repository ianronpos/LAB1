package fp.tipos;

import java.util.Set;
import java.util.HashSet;
import java.time.LocalDate;
import fp.utiles.Checkers;

public class Alumno extends Persona {
	private Set<Asignatura> asignaturas; 
	
	public Alumno(String DNI, String nombre, String apellidos, LocalDate fechaNacimiento, String email) { 
		super(DNI, nombre, apellidos, fechaNacimiento, email);
		validarEmail(email);
		this.asignaturas = new HashSet<>(); 
	}
 
	public Integer getCurso() { 
		return asignaturas.stream().map(Asignatura::curso).max(Integer::compareTo).orElse(null);
	}
	
	public void matriculaAsignatura(Asignatura asignatura) { 
		if(!(asignaturas.add(asignatura))) { 
			throw new IllegalArgumentException("La asignatura ya esta añadida");
		}
	}
	
	public void eliminarAsignatura(Asignatura asignatura) { 
		if(!(asignaturas.remove(asignatura))) { 
			throw new IllegalArgumentException("El alumno no esta matriculada en la asignatura" + asignatura.nombre());
		}
	}
	
	public boolean estaMatriculadoEn(Asignatura  asignatura) { 
		return asignaturas.contains(asignatura);
	}
	
	private void validarEmail(String email) {
		Checkers.check("El email de un alumno no puede ser la cadena vacía y debe acabar en “@alum.us.es”",
				email.endsWith("@alum.us.es") && email != null && !email.isEmpty());
	}
	
	@Override
	public String toString() { 
		//TODO: 
		return null; 
	}
	
	
}