package fp.tipos;

import java.util.Set;
import java.util.TreeSet;
import static fp.utiles.Checkers.*;

public class Despacho extends Espacio{


	private Set<Profesor> profesores; 
	
	public Despacho(String nombre, Integer capacidad, Set<Profesor> profesores) {
		super(nombre, capacidad, Aula.OTRO);
		this.profesores = new TreeSet<>(profesores); 
	}

	public Despacho(String nombre, Integer capacidad, Profesor profesor) { 
		super(nombre, capacidad, Aula.OTRO); 
		this.profesores = new TreeSet<>(); 
		this.setProfesores(profesor);
	}
	
	public Despacho(String nombre, Integer capacidad) {
		super(nombre, capacidad, Aula.OTRO); 
		this.profesores = new TreeSet<Profesor>();	
	}

	
	
	public Set<Profesor> getProfesores() {
		return new TreeSet<>(profesores);
	}

	public void setProfesores(Profesor profesor) {
		this.profesores.add(profesor);
		check("Los profesores no pueden superar la capacidad del Despacho", 
				profesores.size() <= this.getCapacidad()); // Probando que no se supere el aforo maximo
	}

	public String toString() { 
		return super.toString() + profesores.toString();
	}
	
	public void setAula(Aula aula) { 
		checkAula(aula);
		super.setAula(aula); //Con super.setAula se llama a el setAula de Espacio
	}
	
	public void checkAula(Aula aula) {
		if(aula != Aula.OTRO) { 
			throw new UnsupportedOperationException("El aula ha de ser de tipo Aula.OTRO"); 
		}
	}
	
	
}
/*
. Finalmente, un despacho tiene la misma representación que los
 * espacios, seguida de los profesores que ocupan el despacho (utilice la
 * representación como cadena de la propiedad profesores). Por ejemplo:
 * "M2.25 (planta 2) [28200400P – Martín Oviedo, María – 21/05/1985 (TITULAR), 33123210J – Vegarredonda Ordiales, Jorge – 25/11/1990 (CONTRATADO_DOCTOR)]"
 * .
 */
