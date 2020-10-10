package emploi.com.tn.service;

import java.util.List;

import emploi.com.tn.entities.Classe;

public interface IClasseService {
	
	public  void addClasse(String lib, int nbrEtd, String specialite,String mail, int anneUniv);
	public  void editClasse(int id, String lib, int nbrEtd, String specialite,String mail, int anneUniv);
	public  Classe getClasse(int id); 
	public  List<Classe> getClasses(); 
	public  void deleteClasse(int id);

}
