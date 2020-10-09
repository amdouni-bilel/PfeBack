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
public class ESP_Module {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codeModule; 
	private String designation ; 
	private int nbrHeures;
	
	@JsonIgnore
	@OneToMany(mappedBy = "espModule", cascade = CascadeType.ALL)
	private List<Module_Classe> moduleClasse ; 
	
	@JsonIgnore
	@OneToMany(mappedBy = "espModule", cascade = CascadeType.ALL)
	private List<Examen> examens ;
	public int getCodeModule() {
		return codeModule;
	}
	public void setCodeModule(int codeModule) {
		this.codeModule = codeModule;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getNbrHeures() {
		return nbrHeures;
	}
	public void setNbrHeures(int nbrHeures) {
		this.nbrHeures = nbrHeures;
	}
	public List<Module_Classe> getModuleClasse() {
		return moduleClasse;
	}
	public void setModuleClasse(List<Module_Classe> moduleClasse) {
		this.moduleClasse = moduleClasse;
	}
	public List<Examen> getExamens() {
		return examens;
	}
	public void setExamens(List<Examen> examens) {
		this.examens = examens;
	} 
	
	
}
