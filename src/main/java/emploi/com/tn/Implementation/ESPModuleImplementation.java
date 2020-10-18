package emploi.com.tn.Implementation;

import java.util.List;

import emploi.com.tn.dao.IClasseDAO;
import emploi.com.tn.entities.Enseignant;
import emploi.com.tn.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emploi.com.tn.dao.IESPModuleDAO;
import emploi.com.tn.entities.ESP_Module;
import emploi.com.tn.service.IESPModuleService;

@Service
public class ESPModuleImplementation implements IESPModuleService{

	@Autowired
	private IESPModuleDAO esModuleRepository;
	@Autowired
	private IClasseDAO classeRepository;

/*	@Override
	public void addESPModule(String designation, int nbrHeures, String classe) {
		ESP_Module mdl = new ESP_Module();

		mdl.setDesignation(designation);
		mdl.setNbrHeures(nbrHeures);
		mdl.setClasse(classeRepository.findById(classe).get());
		esModuleRepository.save(mdl);
	}

	@Override
	public void editESPModule(int id ,String designation, int nbrHeures, String classe)
	{
		ESP_Module mdl = esModuleRepository.findById(id).get();

		mdl.setDesignation(designation);
		mdl.setNbrHeures(nbrHeures);
		mdl.setClasse(classeRepository.getOne(classe));

		esModuleRepository.save(mdl);
	}*/

	@Override
	public void addESPModule(ESP_Module esp_module) {
		esModuleRepository.save(esp_module);
	}

	@Override
	public void editESPModule(ESP_Module esp_module) {
		esModuleRepository.save(esp_module);
	}

	@Override
	public ESP_Module getESPModule(int id) {
		// TODO Auto-generated method stub
		return esModuleRepository.findById(id).get();
	}

	@Override
	public List<ESP_Module> getESPModules() {
		// TODO Auto-generated method stub
		return esModuleRepository.findAll();
	}

	@Override
	public void deleteESPModule(int id) {
		esModuleRepository.deleteById(id);
	}
}
