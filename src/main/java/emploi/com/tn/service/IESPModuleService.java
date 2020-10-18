package emploi.com.tn.service;

import java.util.List;

import emploi.com.tn.entities.ESP_Module;

public interface IESPModuleService {

	/*public  void addESPModule(String designation, int nbrHeures, String classe);
	public  void editESPModule(int id ,String designation, int nbrHeures, String classe);*/

	public  void addESPModule(ESP_Module esp_module);
	public  void editESPModule(ESP_Module esp_module);
	public  ESP_Module getESPModule(int id);
	public  List<ESP_Module> getESPModules();
	public  void deleteESPModule(int id);


}
