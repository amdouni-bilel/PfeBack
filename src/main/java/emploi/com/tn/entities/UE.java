package emploi.com.tn.entities;

import javax.persistence.*;

@Entity
public class UE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUE ;
    private String libelleUE ;

    public int getIdUE() {
        return idUE;
    }

    public void setIdUE(int idUE) {
        this.idUE = idUE;
    }

	public String getLibelleUE() {
		return libelleUE;
	}

	public void setLibelleUE(String libelleUE) {
		this.libelleUE = libelleUE;
	}

    

  }
