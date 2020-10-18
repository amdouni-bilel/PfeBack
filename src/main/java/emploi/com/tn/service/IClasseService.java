package emploi.com.tn.service;

import java.util.List;

import emploi.com.tn.entities.Classe;

public interface IClasseService {
	
	public  void addClasse(String lib, int nbrEtd, String specialite,String mail, String groupe, int anneUniv , int espdept);
	public  void editClasse(String id, String lib, int nbrEtd, String specialite,String mail, String groupe,int anneUniv , int espdept );
	public  Classe getClasse(String id);
	public  List<Classe> getClasses(); 
	public  void deleteClasse(String id);

}
