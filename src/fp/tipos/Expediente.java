package fp.tipos;

import java.util.List;
import java.util.ArrayList;

public class Expediente implements Comparable<Expediente>{
	private List<Nota> notas;
	
	public Expediente(){ 
		notas = new ArrayList<Nota>();
	}
	
	@Override
	public String toString() { 
		String res = "["; 
		for(int i = 0; i < notas.size(); i++) { 
			res = res.concat(notas.get(i).toString()).concat(", ");
		}
		return res;
	}
	
	@Override
	public int compareTo(Expediente e) { 
		return 0; 
	}
	
	public void nuevaNota(Nota n) { 
		if(notas.stream().anyMatch(n::equals)) {  
			notas.remove(notas.indexOf(n)); 
			notas.add(n); 
		} else {
			notas.add(n);
		}
	}
	
}
