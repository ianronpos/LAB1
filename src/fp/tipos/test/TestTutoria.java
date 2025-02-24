package fp.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalTime;

import fp.tipos.Tutoria;

public class TestTutoria {

	public static void main(String[] args) {
		Tutoria t1 = new Tutoria(DayOfWeek.MONDAY, LocalTime.of(10,30), LocalTime.of(10, 45));
		System.out.println(t1);
		
		Tutoria t2 = new Tutoria(DayOfWeek.FRIDAY, LocalTime.now(), 15);
		System.out.println(t2);
	}

}
