package emploi.com.tn.Implementation;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emploi.com.tn.dao.IESPModuleDAO;
import emploi.com.tn.entities.ESP_Module;
import emploi.com.tn.service.IESPModuleService;

@Service
public class ESPModuleImplementation implements IESPModuleService{

	@Autowired
    private IESPModuleDAO esModuleRepository;

	@Override
	public void addESPModule(ESP_Module espM) {
		esModuleRepository.save(espM);
	}

	@Override
	public void editESPModule(ESP_Module espM) {
		esModuleRepository.save(espM);
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
