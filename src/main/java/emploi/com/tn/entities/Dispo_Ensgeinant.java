package emploi.com.tn.entities;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class Dispo_Ensgeinant {
    private int DispoEns;
    private String Dispo;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    private String heureDebut;
    private String heureFin;
    private String motif;


    public int getDispoEns() {
        return DispoEns;
    }

    public void setDispoEns(int dispoEns) {
        DispoEns = dispoEns;
    }

    public String getDispo() {
        return Dispo;
    }

    public void setDispo(String dispo) {
        Dispo = dispo;
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

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }
}
