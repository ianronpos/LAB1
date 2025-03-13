package fp.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import fp.tipos.Categoria;
import fp.tipos.Profesor;

public class TestProfesor {

	public static void main(String[] args) {
		Profesor p = new Profesor("10101010X", "Jorge", "Garcia Gutierrez", LocalDate.of(1981,5, 3), "jorgarcia@us.es", Categoria.TITULAR); 
		System.out.println(p);
		
		p.nuevaTutoria(LocalTime.of(11, 00), 30, DayOfWeek.FRIDAY);
		p.nuevaTutoria(LocalTime.of(11, 00), 15, DayOfWeek.FRIDAY);
		p.nuevaTutoria(LocalTime.of(10, 30), 30, DayOfWeek.FRIDAY);
		System.out.println(p.getTutorias());
		
		p.borraTutoria(LocalTime.of(11, 00), DayOfWeek.FRIDAY);
		System.out.println(p.getTutorias());
		
		p.borraTutorias();
		System.out.println(p.getTutorias());
	}

}
