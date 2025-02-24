package fp.tipos.test;

import java.time.LocalDate;

import fp.tipos.Persona;

public class TestPersona {
	public static void main(String[] args) {
		try { 
			Persona p1 = new Persona("45361360Ra", "Ian", "Ronco Postigo", LocalDate.of(2006, 5, 13), "ian.ronco2006@gmail.com"); 
		} catch (IllegalArgumentException e) { 
			System.out.println(e);
		}
		
		
		System.out.println("Test 2");
		
		try { 
			Persona p2 = new Persona("45361360R", "Ian", "Ronco Postigo", LocalDate.of(2006, 5, 13), "ian.ronco2006gmail.com"); 
		} catch (IllegalArgumentException e){ 
			System.out.println(e);
		}
		
		System.out.println("test 3");
		
		try { 
			Persona p3 = new Persona("45361360R", "Ian", "Ronco Postigo", LocalDate.of(2006, 5, 13), ""); 
		} catch (IllegalArgumentException e){ 
			System.out.println(e);
		}
	}
	
}
