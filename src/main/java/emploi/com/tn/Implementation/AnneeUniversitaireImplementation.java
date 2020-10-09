package emploi.com.tn.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emploi.com.tn.dao.IAnneeUniversitaireDAO;
import emploi.com.tn.entities.AnneeUniversitaire;
import emploi.com.tn.service.IAnneeUniversitaireService;

@Service
public class AnneeUniversitaireImplementation implements IAnneeUniversitaireService{
 
	@Autowired
    private IAnneeUniversitaireDAO auRepository;

	@Override
	public AnneeUniversitaire getAnneeUniversitaire(int id) {
		// TODO Auto-generated method stub
		return auRepository.findById(id).get();
	}

	@Override
	public List<AnneeUniversitaire> getAnneeUniversitaires() {
		// TODO Auto-generated method stub
		return auRepository.findAll();
	}
}
