package fp.tipos;

import java.util.Set;
import fp.universidades.utiles.Checkers;
import java.lang.reflect.Array;
import java.util.HashSet;

public record Centro(String nombre, String direccion, Integer plantas, Integer sotanos, Set<Espacio> espacios) implements Comparable<Centro> {
	
	public Centro{ 
		Checkers.check("Los centros tiene que tener almenos una planta",
				plantas >= 1);
		Checkers.check("Los centros tienen que tener 0 o mas sotanos", 
				sotanos >= 0); 
		espacios = new HashSet<Espacio>();
	}
	
	//Contructor secundario donde se crea espacio como Set vacio
	public Centro(String nombre, String direccion, Integer plantas, Integer sotanos) {
		this(nombre, direccion, plantas, sotanos, new HashSet<>());
	}

	@Override
	public boolean equals(Object obj) { 
		if(this == obj)
			return true; 
		if(obj == null)
			return false; 
		if(getClass() != obj.getClass())
			return false;
		Centro other = (Centro) obj; 
		return this.nombre.equals(other.nombre); 
	}
	
	@Override 
	public int compareTo(Centro o) { 
		return this.nombre.compareTo(o.nombre);
	}

	public void nuevoEspacio(Espacio e) {
		//comprobando que la planta del espacio este entre [-s,p-1]
		Checkers.check("La planta del espacio ha de estar entre [" + -sotanos + "," + (plantas-1) + "]", 
				e.getPlanta() >= -sotanos || e.getPlanta() < plantas);
		espacios.add(e);
	}
	
	public void eliminarEspacio(Espacio e) { 
		espacios.remove(e);
	}
	
	public Integer[] getConteosEspacio(){
		//TODO:
		return null; 
	}
	
	public Set<Espacio> getDespachos(){ 
		//TODO:
		return null;
	}
	
	public Set<Espacio> getDespachos(Departamento d){
		//TODO:
		return null;
	}
	
	public Set<Persona> getProfesores(){
		//TODO:
		return null;
	}
	
	public Set<Persona> getProfesores(Departamento d){ 
		//TODO:
		return null; 
	}
	
	public Espacio getEspaccioMayorCapacidad() { 
		//TODO:
		return null;
	}
}