package fp.tipos;

import fp.utiles.Checkers;

public class Espacio implements Comparable<Espacio>{
	private String nombre; 
	private Integer capacidad; 
	private Aula aula; 
	private final Integer planta; 
	
	public Espacio(String nombre, Integer capacidad, Aula aula) {
		//Comprobando si la capacidad cumple la restriccion
		validarCapacidad(capacidad);
		
		this.nombre = nombre; 
		this.capacidad = capacidad; 
		this.aula = aula;
		this.planta = extraerPlanta(nombre); 
	}
	
	private Integer extraerPlanta(String nombre) { 
        //Comprueba que el nombre de la clase tenga el formato adecuado y se pueda extraer la planta
		if (nombre.length() >= 2 && Character.isDigit(nombre.charAt(1))) {
            return Character.getNumericValue(nombre.charAt(1));
        } else {
        	//Lanza error, el nombre no tiene el formato esperado 
            throw new IllegalArgumentException("El nombre no tiene el formato correcto (Ejemplo: H0.12)");
        }
    }
	
	public String getNombre() { 
		return nombre; 
	}
	
	public void setNombre(String nombre) {
		Integer plantaNueva = extraerPlanta(nombre); 
		
		//Comprueba si se esta intentando cambiar la planta, en caso afirmativo lanza un error
		if(plantaNueva != planta){ 
            throw new IllegalArgumentException("No se puede cambiar la planta con un nuevo nombre, ya que se esta intentando cambiar la planta"); 
		}
		
		this.nombre = nombre; 
	}
	
	public Integer getCapacidad() {
		return capacidad; 
	}
	
	public void setCapacidad(Integer capacidad) {
		//Comprobando si la capacidad cumple la restriccion
		validarCapacidad(capacidad);
		
		this.capacidad = capacidad; 
	}
	
	public Aula getAula() {
		return aula;
	}
	
	public void setAula(Aula aula) {
		this.aula = aula; 
	}
	
	public Integer getPlanta() {
		return planta;
	}
	
	@Override
	public String toString() { 
		return nombre + "(planta " + planta + ")"; 
	}
	
	@Override 
	public boolean equals(Object obj) { 
		if(this == obj)  
			return true;
		if(obj == null)
			return false; 
		if(getClass() != obj.getClass())
			return false; 
		Espacio other = (Espacio) obj; 
		return this.nombre.equals(other.nombre) && this.planta.equals(other.planta); 
	}
	
	@Override
	public int compareTo(Espacio o) { 
		int codigoPlanta = this.planta.compareTo(o.planta);
		if(codigoPlanta != 0) 
			return codigoPlanta;

		return this.nombre.compareTo(o.nombre); 
	}
	
	
	private void validarCapacidad(int capacidad) {
		//Comprueba si la capacidad es mayor que 0
		Checkers.check("La capacidad ha de ser mayor que 0", capacidad > 0);
		
	}
}