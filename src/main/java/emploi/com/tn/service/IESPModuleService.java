package emploi.com.tn.service;

import java.util.List;
 
import emploi.com.tn.entities.ESP_Module;

public interface IESPModuleService {
	
	public  void addESPModule(ESP_Module espM); 
	public  void editESPModule(ESP_Module espM); 
	public  ESP_Module getESPModule(int id); 
	public  List<ESP_Module> getESPModules(); 
	public  void deleteESPModule(int id);


}
