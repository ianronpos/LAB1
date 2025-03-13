package fp.tipos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import static fp.utiles.Checkers.*;

public class Profesor extends Persona {

	private Categoria categoria; 
	private SortedSet<Tutoria> tutorias;
	
	public Profesor(String DNI, String nombre, String apellidos, LocalDate fechaNacimiento, String email, Categoria categoria) {
		super(DNI, nombre, apellidos, fechaNacimiento, email); // llama al constructor de Persona
		//Comprobar edad
		check("La persona tiene que tener +18 años", getEdad() >= 18);
		this.categoria = categoria; 
		this.tutorias = new TreeSet<Tutoria>();
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public SortedSet<Tutoria> getTutorias() {
		//return tutorias; con estto se da acceso a poder modificar las tutorias del profesor 
		return new TreeSet<>(tutorias); // Devuelve una copia de tutorias, para que lo que se modifique desde afuera no cambie el contenido de las tutorias de profesor
	}
	
	public String toString() { 
		return super.toString() + "(" + getCategoria() + ")";
	}
	
	public void nuevaTutoria(LocalTime horaComienzo, Integer duracion, DayOfWeek dia) {
		tutorias.add(new Tutoria(dia, horaComienzo, duracion));
	}
	
	public void borraTutoria(LocalTime hora, DayOfWeek dia) {
		List<Tutoria> res = new ArrayList<Tutoria>(); 
		for (Tutoria tutoria:tutorias) { //For extendido (Crea una variable que va a recorrer lo que esta despues de los ':')
			if(tutoria.dia().equals(dia) && tutoria.horaInicio().equals(hora)) {
				res.add(tutoria);			
			}
		}
		tutorias.removeAll(res);
	}
	
	public void borraTutorias() { 
		tutorias.clear(); //.clear borra todas las tutorias
	}

}