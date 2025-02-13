package fp.universidades.tipos;


public record Nota(Asignatura asignatura, int cursoAcademico, String convocatoria, double valor, boolean mencionHonor) {

    // Constructor secundario: inicializa mencionHonor como false por defecto
	public Nota(Asignatura asignatura, int cursoAcademico, String convocatoria, double valor) {
	    this(asignatura, cursoAcademico, convocatoria, valor, false); // Inicializa mencionHonor en false
	}


    public String calificacion() {
        if (valor < 5) return "SUSPENSO";
        if (valor < 7) return "APROBADO";
        if (valor < 9) return "NOTABLE";
        return mencionHonor ? "MATRÍCULA DE HONOR" : "SOBRESALIENTE";
    }

    @Override
    public String toString() {
        return "(" + asignatura.acronimo() +") " + asignatura.nombre() + ", " + cursoAcademico + "-" + cursoAcademico+1 + ", "
        		+ convocatoria + ", "+ valor + ", " + calificacion(); 
    }
}
