package fp.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalTime;

import fp.tipos.*; 

public class TestAsignatura {

	public static void main(String[] args) {

		Asignatura a1 = new Asignatura("Fundamentos de Programacion", "FP", "0000230", 12.0, Tipo.ANUAL, 1); 
		System.out.println(a1);
		Asignatura a2 = new Asignatura("Estructura de computadores", "EdC", "2874892", 6.0, Tipo.SEGUNDO, 1);
		System.out.println(a2);
		System.out.println("Los objetos mostrados anteriormente son iguales ? " + a1.equals(a2));
		Asignatura a3 = new Asignatura("Estructura de computadores", "EdC", "0000230", 6.0, Tipo.SEGUNDO, 1);
		System.out.println(a3);
		System.out.println("Los objetos mostrados anteriormente son iguales ? " + a1.equals(a3));
		System.out.println("El objeto 1 es mayor que el 2? " + a1.compareTo(a2));
		System.out.println("El objeto 1 es igual que el 3? " + a1.compareTo(a3));
		
		/*
		System.out.println("---------------Probando las restricciones de Asignatura------------------");
		try {
			Asignatura a2 = new Asignatura("Fundamentos de programacion", "FP", "123ASFT", 12.0, Tipo.ANUAL, 1);
		} catch(IllegalArgumentException e) {
			System.out.println(e);
		}
		try {
			Asignatura a3 = new Asignatura("Fundamentos de programacion", "Fp", "0123456", 0.0, Tipo.ANUAL, 5);
		} catch(IllegalArgumentException e) {
			System.out.println(e);
		} 
		
		try {
			Asignatura a4 = new Asignatura("Fundamentos de programacion", "Fp", "0123456", 12.0, Tipo.ANUAL, 5);
		} catch(IllegalArgumentException e) {
			System.out.println(e);
		}*/
		
	}

}
