package emploi.com.tn.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class UP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUP ;
    private String libelleUP ;

    @ManyToOne
    @JoinColumn(name="code_dept")
    private ESP_Dept espdept;


    public int getIdUP() {
        return idUP;
    }

    public void setIdUP(int idUP) {
        this.idUP = idUP;
    }

   

    public String getLibelleUP() {
		return libelleUP;
	}

	public void setLibelleUP(String libelleUP) {
		this.libelleUP = libelleUP;
	}

	public ESP_Dept getEspdept() {
        return espdept;
    }

    public void setEspdept(ESP_Dept espdept) {
        this.espdept = espdept;
    }
}
