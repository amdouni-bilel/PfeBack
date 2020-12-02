package emploi.com.tn.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Module_Classe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ; 
	private int nbrsHeures; 
	private String semestre;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="classe_id")
	private Classe classe ;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="espModule_id")
	private ESP_Module espModule ;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNbrsHeures() {
		return nbrsHeures;
	}
	public void setNbrsHeures(int nbrsHeures) {
		this.nbrsHeures = nbrsHeures;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public ESP_Module getEspModule() {
		return espModule;
	}
	public void setEspModule(ESP_Module espModule) {
		this.espModule = espModule;
	}
	
	

}
