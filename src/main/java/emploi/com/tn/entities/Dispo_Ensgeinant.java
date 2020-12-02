package emploi.com.tn.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class Dispo_Ensgeinant {
	
	@Id
    private String refDispo; 
	private Date dateDebut; 
    private Date dateFin; 
    private String motif;
    
    @ManyToOne
    @JoinColumn(name="enseignant_id")
    private Enseignant ens ;

	public String getRefDispo() {
		return refDispo;
	}

	public void setRefDispo(String refDispo) {
		this.refDispo = refDispo;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Enseignant getEns() {
		return ens;
	}

	public void setEns(Enseignant ens) {
		this.ens = ens;
	}

	 
    
    
}
