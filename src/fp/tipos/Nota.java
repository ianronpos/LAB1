package fp.tipos;

import fp.universidades.utiles.Checkers;

public record Nota(Asignatura asignatura, Integer cursoAcademico, Convocatoria convocatoria, Double valor) implements Comparable<Nota> {
	
	public Nota{ 
		Checkers.check("La nota debe ser un numero entre 0 y 10",
				valor >= 0.0 && valor <= 10.0);
	}

	private boolean mencionHonor(double valor) { 
		return (valor >= 9.0); 
	}

    public String calificacion() {
        if (valor < 5) return "SUSPENSO";
        if (valor < 7) return "APROBADO";
        if (valor < 9) return "NOTABLE";
        return mencionHonor(valor) ? "MATRÍCULA DE HONOR" : "SOBRESALIENTE";
    }

    
    
    @Override
    public String toString() {
        return "(" + asignatura.acronimo() +") " + asignatura.nombre() + ", " + cursoAcademico + "-" + (cursoAcademico+1) + ", "
        		+ convocatoria + ", "+ valor + ", " + calificacion(); 
    }
    
    @Override 
    public boolean equals(Object obj) { 
    	if(this == obj)
    		return true; 
    	if(obj == null)
    		return false;
    	if(getClass() != obj.getClass())
    		return false; 
    	Nota other = (Nota) obj; 
    	return this.cursoAcademico.equals(other.cursoAcademico) && this.asignatura.equals(other.asignatura)
    			&& this.convocatoria.equals(other.convocatoria); 
    	}
    
    @Override 
    public int compareTo(Nota o) { 
    	int codigoCurso = this.cursoAcademico.compareTo(o.cursoAcademico); 
    	if(codigoCurso != 0)
    		return codigoCurso;
    	
    	int codigoAsignatura = this.asignatura.compareTo(o.asignatura); 
    	if(codigoAsignatura != 0)
    		return codigoAsignatura;
    	
    	return this.convocatoria.compareTo(o.convocatoria);
    }
    
}
