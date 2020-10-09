package emploi.com.tn.service;

import java.util.Date;
import java.util.List;

import emploi.com.tn.entities.Examen;

public interface IExamenService {
	
	public  void addExamen(Date date, String duree, int nbrEtd, String sesmtre, String type, int au, int classe, int enseignant, int module, int salle); 
	public  void editExamen(int id, Date date, String duree, int nbrEtd, String sesmtre, String type, int au, int classe, int enseignant, int module, int salle); 
	public  Examen getExamen(int id); 
	public  List<Examen> getExamens(); 
	public  void deleteExamen(int id);

}
