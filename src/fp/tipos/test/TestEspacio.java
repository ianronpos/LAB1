package fp.tipos.test;

import fp.tipos.Aula;
import fp.tipos.Espacio;

public class TestEspacio {

	public static void main(String[] args) {
		try { 
			Espacio s1 = new Espacio("H0.12", 0, Aula.TEORIA); 
		} catch(IllegalArgumentException e) { 
			System.out.println(e);
		}
		
		System.out.println("TEST 2");
		
		try { 
			Espacio s2 = new Espacio("H0.12", -1, Aula.TEORIA); 
		} catch(IllegalArgumentException e) { 
			System.out.println(e);
		}
		
		System.out.println("TEST 3");
		
		try { 
			Espacio s3 = new Espacio("H0.12", 100, Aula.TEORIA); 
		} catch(IllegalArgumentException e) { 
			System.out.println(e);
		}
		
		
	}

}
