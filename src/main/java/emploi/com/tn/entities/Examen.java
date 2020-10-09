package emploi.com.tn.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Examen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idExamen; 
	@Temporal(TemporalType.DATE)
	private Date dateEx; 
	private String dureeEx; 
	private int nbrEtdEx; 
	private String typeEx; 
	private String semestre ;

	//Enseignant : dispo et ne peut pas surveiller  2 examens en mm temps)
	@ManyToOne
	@JoinColumn(name="salle_id")
	private Salle salle; 
	
	@ManyToOne
	@JoinColumn(name="enseignant_id")
	private Enseignant enseignant; 
	
	@ManyToOne
	@JoinColumn(name="classe_id")
	private Classe classe; 
	
	@ManyToOne
	@JoinColumn(name="anneeUniversitaire_id")
	private AnneeUniversitaire anneeUniversitaire;  
	
	@ManyToOne
	@JoinColumn(name="espModule_id")
	private ESP_Module espModule;

	public int getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}

	public Date getDateEx() {
		return dateEx;
	}

	public void setDateEx(Date dateEx) {
		this.dateEx = dateEx;
	}

	public String getDureeEx() {
		return dureeEx;
	}

	public void setDureeEx(String dureeEx) {
		this.dureeEx = dureeEx;
	}

	public int getNbrEtdEx() {
		return nbrEtdEx;
	}

	public void setNbrEtdEx(int nbrEtdEx) {
		this.nbrEtdEx = nbrEtdEx;
	}

	public String getTypeEx() {
		return typeEx;
	}

	public void setTypeEx(String typeEx) {
		this.typeEx = typeEx;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public AnneeUniversitaire getAnneeUniversitaire() {
		return anneeUniversitaire;
	}

	public void setAnneeUniversitaire(AnneeUniversitaire anneeUniversitaire) {
		this.anneeUniversitaire = anneeUniversitaire;
	}

	public ESP_Module getEspModule() {
		return espModule;
	}

	public void setEspModule(ESP_Module espModule) {
		this.espModule = espModule;
	}
	
	
	
	

}
