package emploi.com.tn.Implementation;

import emploi.com.tn.dao.IDispoSalleDAO;
import emploi.com.tn.dao.ISalleDAO;
import emploi.com.tn.entities.Dispo_Salle;
import emploi.com.tn.entities.Examen;
import emploi.com.tn.service.IDispoSalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DispoSalleImplementation implements IDispoSalleService {

    @Autowired
    private IDispoSalleDAO dispoSalleRepository;
    @Autowired
    private ISalleDAO salleRepository;

    @Override
    public Dispo_Salle getDispoSalle(int id) {
        return dispoSalleRepository.findById(id).get();    }

    @Override
    public List<Dispo_Salle> getDispoSalles() {
        return dispoSalleRepository.findAll();
    }

    @Override
    public void createDispoSalle(Date dateDebut, Date dateFin, String heureDebut, String heureFin, String motif, String salle) {
        Dispo_Salle e = new Dispo_Salle();
        e.setDateDebut(dateDebut);
        e.setDateFin(dateFin);
        e.setHeureDebut(heureDebut);
        e.setHeureFin(heureFin);
        e.setMotif(motif);
        e.setSalle(salleRepository.findById(salle).get());
        dispoSalleRepository.save(e);
    }

    @Override
    public void updateDispoSalle(int id ,Date dateDebut, Date dateFin, String heureDebut, String heureFin, String motif, String salle) {
        Dispo_Salle e =  dispoSalleRepository.findById(id).get();
        e.setDateDebut(dateDebut);
        e.setDateFin(dateFin);
        e.setHeureDebut(heureDebut);
        e.setHeureFin(heureFin);
        e.setMotif(motif);
        e.setSalle(salleRepository.findById(salle).get());
        dispoSalleRepository.save(e);
    }

    @Override
    public void deleteDispoSalle(int id) {
dispoSalleRepository.deleteById(id);
    }
}
