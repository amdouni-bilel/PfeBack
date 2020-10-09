package emploi.com.tn.service;

import java.util.List;

import emploi.com.tn.entities.Salle;

public interface ISalleService  {
	
	public  void createSalle(Salle salle); 
	public  void updateSalle(Salle salle); 
	public  Salle getSalle(int id); 
	public  List<Salle> getSalles(); 
	public  void deleteSalle(int id);
	 
 
}
