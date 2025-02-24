package 
fp.tipos.test;

import fp.tipos.Expediente;
import fp.tipos.Nota;
import fp.tipos.Tipo;
import fp.tipos.Asignatura;
import fp.tipos.Convocatoria;

public class TestExpediente {

	public static void main(String[] args) {
		Asignatura a1 = new Asignatura("Fundamentos de Programacion", "FP", "0000230", 12.0, Tipo.ANUAL, 1); 
		Nota n1 = new Nota(a1, 2024, Convocatoria.PRIMERA, 4.5); 
		Asignatura a2 = new Asignatura("Estructura de Computadores", "EdC", "2050009", 6.0, Tipo.PRIMERO, 1);
		Nota n2 = new Nota(a2, 2024, Convocatoria.PRIMERA, 9.0); 
		Nota n3 = new Nota(a1, 2024, Convocatoria.PRIMERA, 8.69);
		
		
		Expediente e1 = new Expediente(); 
		e1.nuevaNota(n1);
		e1.nuevaNota(n2); 
		e1.nuevaNota(n3);
		
		System.out.println(a1);
		System.out.println(n1);
		System.out.println(a2);
		System.out.println(n2);
		
		System.out.println("---------------------------");
		System.out.println(e1);



		
	}
}
