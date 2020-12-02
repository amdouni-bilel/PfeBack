package emploi.com.tn.entities;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Examen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idExamen; 
	@Temporal(TemporalType.DATE)
	private Date dateEx; 
	private String heureEx;
	/*@Column(name="TestName")*/
	private String dureeEx; 
	private String dsex;
	private String semestre ;
	private String session ;
	private String typeEx ;
	private String groupe ;
	
	

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

	
	public String getDsex() {
		return dsex;
	}

	public void setDsex(String dsex) {
		this.dsex = dsex;
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


	public ESP_Module getEspModule() {
		return espModule;
	}

	public void setEspModule(ESP_Module espModule) {
		this.espModule = espModule;
	}

	public String getTypeEx() {
		return typeEx;
	}

	public void setTypeEx(String typeEx) {
		this.typeEx = typeEx;
	}

	public String getHeureEx() {
		return heureEx;
	}

	public void setHeureEx(String heureEx) {
		this.heureEx = heureEx;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}
	
	
	
	
	

}
