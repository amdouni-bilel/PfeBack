package emploi.com.tn.service;

import java.util.List;

import emploi.com.tn.entities.Enseignant;

public interface IEnseignantService {
	
	public  void addEnseignant(Enseignant ens); 
	public  void editEnseignant(Enseignant ens); 
	public  Enseignant getEnseignant(int id); 
	public  List<Enseignant> getEnseignants(); 
	public  void deleteEnseignant(int id);
}
