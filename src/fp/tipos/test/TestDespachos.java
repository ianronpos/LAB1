package fp.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import fp.tipos.Categoria;
import fp.tipos.Despacho;
import fp.tipos.Profesor;

public class TestDespachos {
	
	public static void main(String[] args) { 
		Profesor p = new Profesor("10101010X", "Jorge", "Garcia Gutierrez", LocalDate.of(1981,5, 3), "jorgarcia@us.es", Categoria.TITULAR); 
		Profesor p2 = new Profesor("45361360R", "Ian", "Ronco Postigo", LocalDate.of(2006, 5, 13), "ianronpos@us.es", Categoria.AYUDANTE); 
		Despacho d1 = new Despacho("G0.48", 5, p); 
		d1.setProfesores(p2);
		System.out.println(d1);
		
		Despacho d2 = new Despacho("H0.12", 1); 
		d2.setProfesores(p);
		d2.setProfesores(p2);
		
	}
}
  