package emploi.com.tn.service;

import java.util.List;

import emploi.com.tn.entities.Etudiant; 

public interface IEtudiantService {
	
	
	public  void addEtudiant(int cin, String nom, String prenom,String mailEtud, String classe);
	public  void editEtudiant(int id, int cin, String nom, String prenom,String mailEtud, String classe);
	public  Etudiant getEtudiant(int id); 
	public  List<Etudiant> getEtudiants(); 
	public  void deleteEtudiant(int id);

}
