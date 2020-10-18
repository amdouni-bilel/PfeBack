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
public class Ecole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEcole ; 
	private String libelle ;



	@JsonIgnore  //boucle infini
	@OneToMany(mappedBy = "ecole", cascade = CascadeType.ALL)
	private List<AnneeUniversitaire> anneeUnivs;
	
	public int getIdEcole() {
		return idEcole;
	}
	public void setIdEcole(int idEcole) {
		this.idEcole = idEcole;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public List<AnneeUniversitaire> getAnneeUnivs() {
		return anneeUnivs;
	}
	public void setAnneeUnivs(List<AnneeUniversitaire> anneeUnivs) {
		this.anneeUnivs = anneeUnivs;
	}

	

}
