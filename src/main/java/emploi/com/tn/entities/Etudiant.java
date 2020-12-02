package emploi.com.tn.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Etudiant {
	@Id 
	private String id; 
	private int cin ; 
	private String nom; 
	private String prenom ;
	private String mailEtud ;


	@ManyToOne
	@JoinColumn(name="classe_id")
	private Classe classe;
	
	
 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
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
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public String getMailEtud() {return mailEtud; }
	public void setMailEtud(String mailEtud) {this.mailEtud = mailEtud;	}
}
