package emploi.com.tn.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class AnneeUniversitaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAU;
	private String libelleAU ;
	private String semestre ;  
	
	@JsonIgnore
	@OneToMany(mappedBy = "anneeUniversitaire", cascade = CascadeType.ALL)
	private List<Examen> examen; 
	
	
	@ManyToOne
	@JoinColumn(name="ecole_id")
	private Ecole ecole ;
	
	@JsonIgnore
	@OneToMany(mappedBy = "anneeUniver", cascade = CascadeType.ALL)
	private List<Classe> classes;
	
	public int getIdAU() {
		return idAU;
	}
	public void setIdAU(int idAU) {
		this.idAU = idAU;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public List<Examen> getExamen() {
		return examen;
	}
	public void setExamen(List<Examen> examen) {
		this.examen = examen;
	}
	public Ecole getEcole() {
		return ecole;
	}
	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}
	public List<Classe> getClasses() {
		return classes;
	}
	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}
	public String getLibelleAU() {
		return libelleAU;
	}

	public void setLibelleAU(String libelleAU) {
		this.libelleAU = libelleAU;
	}
}
