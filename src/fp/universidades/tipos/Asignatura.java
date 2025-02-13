package fp.universidades.tipos;

public record Asignatura(String nombre, String acronimo, String codigo, Double creditos, Tipo tipo, Integer curso){
	
    public String acronimo() {
        return null; // Temporalmente devuelve null
    }

    @Override
    public String toString() {
        return "(" + codigo + ") " + nombre;
    }
}