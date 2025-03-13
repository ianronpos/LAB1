package fp.tipos.test;

import java.time.LocalDate; 
import fp.tipos.Alumno;
import fp.tipos.Asignatura;
import fp.tipos.Tipo; 

public class TestAlumno {

	public static void main(String[] args) {
		Alumno a1 = new Alumno("12345678A", "Carlos", "Pérez", LocalDate.of(2000, 5, 20), "carlos@alum.us.es");
		Alumno a2 = new Alumno("87654321B", "Ana", "Gómez", LocalDate.of(1999, 8, 15), "ana@alum.us.es");
		
		System.out.println(a1.compareTo(a2));
		
		a1.matriculaAsignatura(new Asignatura("Fundamentos de Programacion", "FP", "0000230", 12.0, Tipo.ANUAL, 1));

		System.out.println(a1.estaMatriculadoEn(new Asignatura("Estructura de computadores", "EdC", "2874892", 6.0, Tipo.SEGUNDO, 1)));
		
		a1.matriculaAsignatura(new Asignatura("Estructura de computadores", "EdC", "2874892", 6.0, Tipo.SEGUNDO, 1));
		a1.eliminarAsignatura(new Asignatura("Estructura de computadores", "EdC", "2874892", 6.0, Tipo.SEGUNDO, 1));
		a1.eliminarAsignatura(new Asignatura("Estructura de computadores", "EdC", "2874892", 6.0, Tipo.SEGUNDO, 1));
		
	}

}
