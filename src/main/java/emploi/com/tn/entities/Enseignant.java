package emploi.com.tn.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Enseignant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEns; 
	private String nom; 
	private String prenom; 
	private String typeEns ; 
	private int tel ;
	//disponibilite - absence (surveillance : present ou absent)
	private String sex ;
	private String mail ;
	private int nbrsurveillance ;
	private float  nbrHeursurveillance ;





	@JsonIgnore
	@OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL)
	private List<Examen> examens;

	@ManyToOne
	@JoinColumn(name="code_dept")
	private ESP_Dept espdept;

	public int getIdEns() {
		return idEns;
	}
	public void setIdEns(int idEns) {
		this.idEns = idEns;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTypeEns() {
		return typeEns;
	}
	public void setTypeEns(String typeEns) {
		this.typeEns = typeEns;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public List<Examen> getExamens() {
		return examens;
	}
	public void setExamens(List<Examen> examens) {
		this.examens = examens;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getNbrsurveillance() {
		return nbrsurveillance;
	}

	public void setNbrsurveillance(int nbrsurveillance) {
		this.nbrsurveillance = nbrsurveillance;
	}

	public float getNbrHeursurveillance() {
		return nbrHeursurveillance;
	}

	public void setNbrHeursurveillance(float nbrHeursurveillance) {
		this.nbrHeursurveillance = nbrHeursurveillance;
	}
}
