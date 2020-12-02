package emploi.com.tn.service;

import java.util.Date;
import java.util.List;

import emploi.com.tn.entities.Examen;

public interface IExamenService {
	
	public  void addExamen(Date date, String heure, String duree, String dsex, String semestre, String session, String typeExamen, String classe, String module, String surveillant, String salle, String groupe);
	public  void editExamen(int id, Date date, String heure, String duree, String dsex, String semestre, String session, String typeExamen, String classe, String module, String surveillant, String salle, String groupe);
	public  Examen getExamen(int id); 
	public  List<Examen> getExamens(); 
	public  void deleteExamen(int id);
	public  int  verifExistanceExamen(Date date, String heure, String classe, String groupe);

}
