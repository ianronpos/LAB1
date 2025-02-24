package fp.tipos.test;

import fp.tipos.Asignatura;
import fp.tipos.Nota;
import fp.tipos.Tipo;
import fp.tipos.Convocatoria;

public class TestNota {
	public static void main(String[] args) { 
		Asignatura a1 = new Asignatura("Fundamentos de Programacion", "FP", "0000230", 12.0, Tipo.ANUAL, 1); 
		
		Nota n1 = new Nota(a1, 1, Convocatoria.PRIMERA, 9.0);
		System.out.println(n1);
		
		try { 
			Nota n2 = new Nota(a1, 1, Convocatoria.PRIMERA, 11.0);
		} catch(IllegalArgumentException e) { 
			System.out.println(e);
		}
	}

}
