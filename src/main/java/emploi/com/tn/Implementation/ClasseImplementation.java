package emploi.com.tn.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emploi.com.tn.dao.IAnneeUniversitaireDAO;
import emploi.com.tn.dao.IClasseDAO;
import emploi.com.tn.entities.Classe;
import emploi.com.tn.service.IClasseService;

@Service
public class ClasseImplementation implements IClasseService{

	@Autowired
    private IClasseDAO classeRepository;
	@Autowired
    private IAnneeUniversitaireDAO auRepository;
	
	@Override
	public void addClasse(String lib, int nbrEtd, String specialite, int anneUniv) {
		Classe c = new Classe();
		c.setLibelleCL(lib);
		c.setNbrEtudiant(nbrEtd);
		c.setSpecialite(specialite);
		c.setAnneeUniver(auRepository.findById(anneUniv).get());
		classeRepository.save(c);
	}

	@Override
	public void editClasse(int id, String lib, int nbrEtd, String specialite, int anneUniv) {
		Classe c = classeRepository.findById(id).get();
		c.setLibelleCL(lib);
		c.setNbrEtudiant(nbrEtd);
		c.setSpecialite(specialite);
		c.setAnneeUniver(auRepository.findById(anneUniv).get());
		classeRepository.save(c);
	}

	@Override
	public Classe getClasse(int id) {
		// TODO Auto-generated method stub
		return classeRepository.findById(id).get();
	}

	@Override
	public List<Classe> getClasses() {
		// TODO Auto-generated method stub
		return classeRepository.findAll();
	}

	@Override
	public void deleteClasse(int id) {
		classeRepository.deleteById(id);
	}
}
