package fp.tipos;

import java.util.Objects;

import fp.utiles.Checkers;


public record Asignatura(String nombre, String acronimo, String codigo, Double creditos, Tipo tipo, Integer curso) implements Comparable<Asignatura>{
	
	//Comprobando si los atributos cumplen las restricciones
	public Asignatura{ 
    	Checkers.check("El codigo ha de tener 7 digitos", codigo.length() == 7 && codigo.chars().allMatch(Character::isDigit));
    	Checkers.check("Los creditos han de ser mayor que 0", creditos > 0.0);
    	Checkers.check("La asignatura debe impartirse en alguno de los 4 cursos que dura la titulacion", curso == 1 || curso == 2 || curso == 3 || curso == 4); 
	}
	
    public String acronimo() {
        return null; // Temporalmente devuelve null
    }
    

    @Override
    public String toString() {
        return "(" + codigo + ") " + nombre;
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		//Dos Asignaturas son iguales si comparten el mismo codigo
		return Objects.equals(this.codigo, other.codigo); 
	}

	@Override
	public int compareTo(Asignatura o) {
		//Las Asignaturas se ordenan Alfabeticamente por su codigo
		return this.codigo.compareTo(o.codigo());
	}
    
	
    
    
}