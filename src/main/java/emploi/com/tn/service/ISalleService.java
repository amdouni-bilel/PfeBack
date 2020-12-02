package emploi.com.tn.service;
 
import java.util.List;
 
import emploi.com.tn.entities.Salle;

public interface ISalleService  {
	
	public  void createSalle(Salle salle); 
	public  void updateSalle(Salle salle); 
	public  Salle getSalle(String codeSalle);
	public  List<Salle> getSalles(); 
	public  void deleteSalle(String codeSalle);
	public  List<Salle> getSallesDisponibles(String date, String heure); 
	public int verifExistanceSalle(String code);
	 
 
}
