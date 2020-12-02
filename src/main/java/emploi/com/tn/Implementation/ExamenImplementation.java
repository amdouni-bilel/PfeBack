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
import emploi.com.tn.entities.Etudiant;
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
	public void addExamen(Date date, String heure, String duree, String dsex, String semestre, String session, String typeExamen, String classe, String module, String surveillant, String salle, String groupe) {
		Examen e = new Examen();
		e.setDateEx(date);
		e.setHeureEx(heure); 
		e.setDureeEx(duree);
		e.setDsex(dsex);
		e.setSemestre(semestre);
		e.setSession(session);
		e.setTypeEx(typeExamen); 
		e.setClasse(classeRepository.findById(classe).get());
		e.setEspModule(esModuleRepository.findById(module).get());
		e.setEnseignant(enseignantRepository.findById(surveillant).get());
		e.setSalle(salleRepository.findById(salle).get());
		e.setGroupe(groupe);
		examenRepository.save(e);
	}

	@Override
	public void editExamen(int id, Date date, String heure, String duree, String dsex, String semestre, String session, String typeExamen, String classe, String module, String surveillant, String salle, String groupe) {
		Examen e = examenRepository.findById(id).get();
		e.setDateEx(date);
		e.setHeureEx(heure); 
		e.setDureeEx(duree);
		e.setDsex(dsex);
		e.setSemestre(semestre);
		e.setSession(session);
		e.setTypeEx(typeExamen); 
		e.setClasse(classeRepository.findById(classe).get());
		e.setEspModule(esModuleRepository.findById(module).get());
		e.setEnseignant(enseignantRepository.findById(surveillant).get());
		e.setSalle(salleRepository.findById(salle).get());
		e.setGroupe(groupe);
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

	@Override
	public int verifExistanceExamen(Date date, String heure, String classe, String groupe) {
		int x = 0;
		List<Examen> all = examenRepository.findAll();
		for(int i=0; i<all.size(); i++) {
			if(all.get(i).getClasse().getCodeCL().equals(classe) &&
					all.get(i).getDateEx().equals(date) &&
					all.get(i).getHeureEx().equals(heure)  &&
					all.get(i).getGroupe().equals(groupe)) {
				x=1; 
			}
		}
		return x;
	}
}
