package fp.tipos;

import java.util.Set;
import java.util.stream.Collectors;

import fp.utiles.Checkers;

public class Grado implements Comparable<Grado> {

	private String nombre;
	private Set<Asignatura> asignaturasTroncales;
	private Set<Asignatura> asignaturasOptativas;
	private Double minimoCreditos;
	private Double totalCreditos;

	public Grado(String nombre, Set<Asignatura> asignaturasTroncales, Set<Asignatura> asignaturasOptativas, Double minimoCreditos) {
		Checkers.check("Todas las asignaturas optativas tienen que tener el mismo numero de creditos", 
				asignaturasOptativas.stream().map(Asignatura::creditos) //Cambia el stream a un stream<Double> con todos los creditos
				.collect(Collectors.toSet()) //Convierte el stream<Double> a Set<Double>, eliminando elementos duplicados
				.size() == 1); // Comprueba si el tamaño del set es 1, es decir todos los elementos son iguales
		Checkers.check("El numero total de creditos de asignaturas tiene que estar comprendido entre 0 y el numero total de creditos de asignaturas optativas",
				minimoCreditos != 0 && totalCreditos <= asignaturasOptativas.stream().
				mapToDouble(Asignatura::creditos) // Transforma el Stream<Asignatura> a Stream<Double> y luego a Stream de tipo primitivo double
				.sum()); //hace la suma aritmetica
		
		this.nombre = nombre;
		this.asignaturasTroncales = asignaturasTroncales;
		this.asignaturasOptativas = asignaturasOptativas;
		this.minimoCreditos = minimoCreditos;
		this.totalCreditos = calcTotalCreditos();
	}

	@Override
	public boolean equals(Object obj) { 
		if(this == obj)
			return true; 
		if(obj == null)
			return false; 
		if(getClass() != obj.getClass())
			return false; 
		Grado other = (Grado) obj; 
		return this.nombre.equals(other.nombre); 			
	}
	
	@Override 
	public int compareTo(Grado o) { 
		return this.nombre.compareTo(o.nombre); 
	}
	
	private Double calcTotalCreditos() {
		return asignaturasTroncales.stream().mapToDouble(Asignatura::creditos).sum();
	}
	
	public Set<Asignatura> getAsignaturas(Integer curso){
		//TODO: 
		return null; 
	}
	
	public Asignatura getAsinatura(String codigo) { 
		return null; 
	}
}
