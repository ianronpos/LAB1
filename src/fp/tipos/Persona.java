package fp.tipos;

import java.time.LocalDate;

import fp.universidades.utiles.Checkers; 

public class Persona implements Comparable<Persona>{
	//Atributos
	private String DNI;
	private String nombre; 
	private String apellidos; 
	private LocalDate fechaNacimiento; 
	private String email;

	//Contructor 
	public Persona(String DNI, String nombre, String apellidos, LocalDate fechaNacimiento, String email) {
		validarDNI(DNI);
		validarEmail(email); 
		
		this.DNI = DNI; 
		this.nombre = nombre; 
		this.apellidos = apellidos; 
		this.fechaNacimiento = fechaNacimiento; 
		this.email = email; 
	}
	
	//Metodos
	
	public void setDNI(String DNI) { 
		validarDNI(DNI);
		this.DNI = DNI; 
	}
	
	public String getDNI() {
		return DNI;
	}
	
	public void setNombre(String nombre){	
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre; 
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getApellidos() {
		return apellidos; 
	}
	
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public Integer getEdad() {
		LocalDate hoy = LocalDate.now();
		Integer edad = hoy.getYear() - fechaNacimiento.getYear();
		
		//Comprobando si todavia no ha cumplido años; 
		if(hoy.getMonthValue() < fechaNacimiento.getMonthValue() ||
				hoy.getMonthValue() == fechaNacimiento.getMonthValue() && hoy.getDayOfMonth() < fechaNacimiento.getDayOfMonth()) {
			//decrementando la edad
			--edad;
		}
		return edad; 
	}
	
	public void setEmail(String email) {
		validarEmail(email);
		
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return DNI + " - " + apellidos + " - " + nombre + " - " + fechaNacimiento; 
	}
	
	@Override
	public boolean equals(Object obj) { 
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false; 
		Persona other = (Persona) obj; 
		
		//Dos personaa son iguales si tienen mismo dni, nombre y apellidos
		return this.DNI.equals(other.DNI) && this.nombre.equals(other.nombre) && this.apellidos.equals(other.apellidos); 
	}
	
	@Override
	public int compareTo(Persona o) { 
		//Comprueba los DNIS
		int codigoDni = this.DNI.compareTo(o.DNI); 
		if(codigoDni != 0) { 
			return codigoDni; 
		}
		
		//Si los dnis son iguales compara los nombre
		int codigoNombre = this.nombre.compareTo(o.nombre); 
		if(codigoNombre != 0) { 
			return codigoNombre; 
		}
		
		//Si los dnis y los nombre son iguales compara apellidos
		return this.apellidos.compareTo(o.apellidos); 
	}
	
	//Restricciones 
	private void validarDNI(String  dni) { 
		//Comprueba si el dni contiene 9 caracteres -> los 8 primeros son letras -> el ultimo corresponde con una letras
		Checkers.check("El dni ha de contener 8 digitos y al final una letra",
				dni.length() == 9 && dni.substring(0, dni.length()-1).chars().allMatch(Character::isDigit) && Character.isLetter(dni.charAt(dni.length()-1))); 
	}
	
	private void validarEmail(String email) {
		Checkers.check("El formato del email no es correcto",
				email.contains("@") && email.isEmpty());
	}
	
}