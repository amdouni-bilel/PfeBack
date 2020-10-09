package emploi.com.tn.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Salle { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codeSalle; 
	private int capacite;  
	private String  typeSalle;
	//disponibilite -- motifDisp
	
	@JsonIgnore
	@OneToMany(mappedBy = "salle", cascade = CascadeType.ALL)
	private List<Examen> examens;
	
	
	public int getCodeSalle() {
		return codeSalle;
	}
	public void setCodeSalle(int codeSalle) {
		this.codeSalle = codeSalle;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public String getTypeSalle() {
		return typeSalle;
	}
	public void setTypeSalle(String typeSalle) {
		this.typeSalle = typeSalle;
	}
	public List<Examen> getExamens() {
		return examens;
	}
	public void setExamens(List<Examen> examens) {
		this.examens = examens;
	} 
	
	
	

}
