package emploi.com.tn.service;

import java.util.List;

import emploi.com.tn.entities.ESP_Module;
import emploi.com.tn.entities.Enseignant;

public interface IESPModuleService {

	public  void addESPModule(String code, float coff, String lib, int nbHeurs, String periode, String semestre, String typeEpreuve, String classe, String enseignant);
	public  void editESPModule(String code, float coff, String lib, int nbHeurs, String periode, String semestre, String typeEpreuve, String classe, String enseignant);
 
	public  ESP_Module getESPModule(String id);
	public  List<ESP_Module> getESPModules();
	public  void deleteESPModule(String id);
	public  List<ESP_Module> getModulesByClasse(String classe);
	public  List<Enseignant> getEnseignantByModule(String module);
	public  int verifModuleExiste(String code, String lib );


}
