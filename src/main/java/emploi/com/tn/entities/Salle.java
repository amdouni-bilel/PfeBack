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
	private String codeSalle;
	private int capacite;  
	private String  site;
	//disponibilite -- motifDisp
	
	@JsonIgnore
	@OneToMany(mappedBy = "salle", cascade = CascadeType.ALL)
	private List<Examen> examens;
	
	@JsonIgnore
	@OneToMany(mappedBy = "salle", cascade = CascadeType.ALL)
	private List<Dispo_Salle> dispoSalles ;

	public String getCodeSalle() {
		return codeSalle;
	}

	public void setCodeSalle(String codeSalle) {
		this.codeSalle = codeSalle;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public List<Examen> getExamens() {
		return examens;
	}

	public void setExamens(List<Examen> examens) {
		this.examens = examens;
	}

	public List<Dispo_Salle> getDispoSalles() {
		return dispoSalles;
	}

	public void setDispoSalles(List<Dispo_Salle> dispoSalles) {
		this.dispoSalles = dispoSalles;
	}
	
	
	
	
	

}
