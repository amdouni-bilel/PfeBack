package emploi.com.tn.Implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emploi.com.tn.dao.IAnneeUniversitaireDAO;
import emploi.com.tn.dao.IClasseDAO;
import emploi.com.tn.dao.IESPModuleDAO;
import emploi.com.tn.dao.IEnseignantDAO;
import emploi.com.tn.dao.IExamenDAO;
import emploi.com.tn.dao.ISalleDAO;
import emploi.com.tn.entities.Examen; 
import emploi.com.tn.service.IExamenService;

@Service
public class ExamenImplementation implements IExamenService{

	@Autowired
    private IExamenDAO examenRepository;
	@Autowired
    private IAnneeUniversitaireDAO auRepository;
	@Autowired
    private IClasseDAO classeRepository;
	@Autowired
    private IEnseignantDAO enseignantRepository;
	@Autowired
    private IESPModuleDAO esModuleRepository;
	@Autowired
    private ISalleDAO salleRepository;

	@Override
	public void addExamen(Date date, String duree, int nbrEtd, String sesmtre, String type, int au, String classe, int enseignant, int module, int salle) {
		Examen e = new Examen();
		e.setDateEx(date);
		e.setDureeEx(duree);
		e.setNbrEtdEx(nbrEtd);
		e.setSemestre(sesmtre);
		e.setTypeEx(type);
		e.setAnneeUniversitaire(auRepository.findById(au).get());
		e.setClasse(classeRepository.findById(classe).get());
		e.setEnseignant(enseignantRepository.findById(enseignant).get());
		e.setEspModule(esModuleRepository.findById(module).get());
		//e.setSalle(salleRepository.findById(salle).get());
		examenRepository.save(e);
	}

	@Override
	public void editExamen(int id, Date date, String duree, int nbrEtd, String sesmtre, String type, int au, String classe, int enseignant, int module, int salle) {
		Examen e = examenRepository.findById(id).get();
		e.setDateEx(date);
		e.setDureeEx(duree);
		e.setNbrEtdEx(nbrEtd);
		e.setSemestre(sesmtre);
		e.setTypeEx(type);
		e.setAnneeUniversitaire(auRepository.findById(au).get());
		e.setClasse(classeRepository.findById(classe).get());
		e.setEnseignant(enseignantRepository.findById(enseignant).get());
		e.setEspModule(esModuleRepository.findById(module).get());
		//e.setSalle(salleRepository.findById(salle).get());
		examenRepository.save(e);
	}

	@Override
	public Examen getExamen(int id) {
		return examenRepository.findById(id).get();
	}

	@Override
	public List<Examen> getExamens() {
		return examenRepository.findAll();
	}

	@Override
	public void deleteExamen(int id) {
		examenRepository.deleteById(id);
	}
}
