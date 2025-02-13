package fp.universidades.tipos;

import java.time.LocalDate; 

public class Personas {
	//Atributos
	private String DNI;
	private String nombre; 
	private String apellidos; 
	private LocalDate fechaNacimiento; 
	private String email;

	//Contructor 
	public Personas(String DNI, String nombre, String apellidos, LocalDate fechaNacimiento, String email) {
		this.DNI = DNI; 
		this.nombre = nombre; 
		this.apellidos = apellidos; 
		this.fechaNacimiento = fechaNacimiento; 
		this.email = email; 
	}
	
	//Metodos
	
	public void setDNI(String DNI) { 
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
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return DNI + " - " + apellidos + " - " + nombre + " - " + fechaNacimiento; 
	}
	
}