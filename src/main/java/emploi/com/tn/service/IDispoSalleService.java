package emploi.com.tn.service;

import emploi.com.tn.entities.Dispo_Salle;
import emploi.com.tn.entities.ESP_Dept;
import emploi.com.tn.entities.Salle;

import java.util.Date;
import java.util.List;

public interface IDispoSalleService {

    public Dispo_Salle getDispoSalle(int id);
    public List<Dispo_Salle> getDispoSalles();
    public  void createDispoSalle(Date dateDebut, Date dateFin, String heureDebut, String heureFin, String motif, String salle);
    public  void updateDispoSalle(int id ,Date dateDebut, Date dateFin, String heureDebut, String heureFin, String motif, String salle);
    public  void deleteDispoSalle(int id);
}
