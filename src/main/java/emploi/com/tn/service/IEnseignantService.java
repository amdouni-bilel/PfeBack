package emploi.com.tn.service;
 
import java.util.List;

import emploi.com.tn.entities.Enseignant;

public interface IEnseignantService {
	
	public  void addEnseignant(String code, String nom, String prenom, int tel, String mail, String sexe, String type, int departement); 
	public  void editEnseignant(String code, String nom, String prenom, int tel, String mail, String sexe, String type, int departement); 
	public  Enseignant getEnseignant(String id); 
	public  List<Enseignant> getEnseignants(); 
	public  void deleteEnseignant(String id);
	public  List<Enseignant> getEnseignantsDisponibles(String date, String heure); 
	public  void editSurveillanceEnseignant(String code);
	public int verifEnseignantExiste(String mail, int tel, String code);
}
