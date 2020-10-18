package emploi.com.tn.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Classe {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String codeCL;
	private String libelleCL;
	private int nbrEtudiant ; 
	private String specialite  ;
	private String mail ;
	private String groupe ;




	@JsonIgnore
	@OneToMany(mappedBy = "classe", cascade = CascadeType.ALL)
	private List<Examen> examen; 
	
	@JsonIgnore
	@OneToMany(mappedBy = "classe", cascade = CascadeType.ALL)
	private List<Etudiant> etudiants;

	@JsonIgnore
	@OneToMany(mappedBy = "classe", cascade = CascadeType.ALL)
	private List<ESP_Module> ESP_Modules;

	@JsonIgnore
	@OneToMany(mappedBy = "classe", cascade = CascadeType.ALL)
	private List<Module_Classe> moduleClasse ;
	
	@ManyToOne
	@JoinColumn(name="anneeUniversitaire_id")
	private AnneeUniversitaire anneeUniver ;

	@ManyToOne
	@JoinColumn(name="code_dept")
	private ESP_Dept espdept;
	
	
	public String getCodeCL() {
		return codeCL;
	}
	public void setCodeCL(String codeCL) {
		this.codeCL = codeCL;
	}
	public String getLibelleCL() {
		return libelleCL;
	}
	public void setLibelleCL(String libelleCL) {
		this.libelleCL = libelleCL;
	}
	public int getNbrEtudiant() {
		return nbrEtudiant;
	}
	public void setNbrEtudiant(int nbrEtudiant) {
		this.nbrEtudiant = nbrEtudiant;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public List<Examen> getExamen() {
		return examen;
	}
	public void setExamen(List<Examen> examen) {
		this.examen = examen;
	}
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	public AnneeUniversitaire getAnneeUniver() {
		return anneeUniver;
	}
	public void setAnneeUniver(AnneeUniversitaire anneeUniver) {
		this.anneeUniver = anneeUniver;
	}
	public List<Module_Classe> getModuleClasse() {
		return moduleClasse;
	}
	public void setModuleClasse(List<Module_Classe> moduleClasse) {
		this.moduleClasse = moduleClasse;
	}
	public String getMail() {return mail;}
	public void setMail(String mail) {this.mail = mail;}

	public List<ESP_Module> getESP_Modules() {
		return ESP_Modules;
	}

	public void setESP_Modules(List<ESP_Module> ESP_Modules) {
		this.ESP_Modules = ESP_Modules;
	}

	public ESP_Dept getEspdept() {
		return espdept;
	}

	public void setEspdept(ESP_Dept espdept) {
		this.espdept = espdept;
	}

	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}
}
