package emploi.com.tn.Implementation;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import emploi.com.tn.dao.ISalleDAO;
import emploi.com.tn.entities.Salle;
import emploi.com.tn.service.ISalleService;


@Service
public class SalleImplementation  implements ISalleService {

	@Autowired
    private ISalleDAO salleRepository;

	@Override
	public void createSalle(Salle salle) {
		 salleRepository.save(salle);
	}

	@Override
	public void updateSalle(Salle salle) {  
		Salle s = salleRepository.getOne(salle.getCodeSalle());
		s.setCapacite(salle.getCapacite());
		s.setSite(salle.getSite());
		salleRepository.save(salle);
	}

	@Override
	public Salle getSalle(String id) {
		return salleRepository.findById(id).get(); 
	}

	@Override
	public List<Salle> getSalles() {
		// TODO Auto-generated method stub
		return  (List<Salle>)salleRepository.findAll(); 
	}

	@Override
	public void deleteSalle(String id) {
		salleRepository.deleteById(id);
	}

	 
	 
}
