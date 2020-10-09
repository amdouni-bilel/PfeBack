package emploi.com.tn.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import emploi.com.tn.dao.IEnseignantDAO;
import emploi.com.tn.entities.Enseignant;
import emploi.com.tn.service.IEnseignantService;

@Service
public class EnseignantImplementation implements IEnseignantService{
	
	@Autowired
    private IEnseignantDAO enseignantRepository;

	@Override
	public void addEnseignant(Enseignant ens) {
		enseignantRepository.save(ens);
	}

	@Override
	public void editEnseignant(Enseignant ens) {
		enseignantRepository.save(ens);
	}

	@Override
	public Enseignant getEnseignant(int id) {
		// TODO Auto-generated method stub
		return enseignantRepository.findById(id).get();
	}

	@Override
	public List<Enseignant> getEnseignants() {
		// TODO Auto-generated method stub
		return enseignantRepository.findAll();
	}

	@Override
	public void deleteEnseignant(int id) {
		enseignantRepository.deleteById(id);
	}
}
