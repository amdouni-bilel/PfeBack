package emploi.com.tn.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ESP_Module {
	@Id 
	private String codeModule;
	private String designation ;
	private int nbrHeures;
	private float coefficient;
	private String typeEpreuve;
	private String semestre;
	private String periode;


	@JsonIgnore
	@OneToMany(mappedBy = "espModule", cascade = CascadeType.ALL)
	private List<Module_Classe> moduleClasse ;

	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="classe_id")
	private Classe classe;

	
	@ManyToOne
	@JoinColumn(name="enseignant_id")
	private Enseignant enseignant;

	@JsonIgnore
    @ManyToOne
    @JoinColumn(name="ue_id")
    private UE ue;



    @JsonIgnore
	@OneToMany(mappedBy = "espModule", cascade = CascadeType.ALL)
	private List<Examen> examens ;
    
    


	public String getCodeModule() {
		return codeModule;
	}
	public void setCodeModule(String codeModule) {
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
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public float getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(float coefficient) {
		this.coefficient = coefficient;
	}

	public String getTypeEpreuve() {
		return typeEpreuve;
	}

	public void setTypeEpreuve(String typeEpreuve) {
		this.typeEpreuve = typeEpreuve;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public UE getUe() {
        return ue;
    }

    public void setUe(UE ue) {
        this.ue = ue;
    }
    
    
    
}
