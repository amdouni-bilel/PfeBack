package emploi.com.tn.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class UP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUP ;
    private String LibelleUP ;

    @ManyToOne
    @JoinColumn(name="espdept_id")
    private ESP_Dept espDept;


    public int getIdUP() {
        return idUP;
    }

    public void setIdUP(int idUP) {
        this.idUP = idUP;
    }

    public String getLibelleUP() {
        return LibelleUP;
    }

    public void setLibelleUP(String libelleUP) {
        LibelleUP = libelleUP;
    }

    public ESP_Dept getEspDept() {
        return espDept;
    }

    public void setEspDept(ESP_Dept espDept) {
        this.espDept = espDept;
    }
}
