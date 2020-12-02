package emploi.com.tn.service;

import java.util.List;

import emploi.com.tn.entities.Etudiant; 

public interface IEtudiantService {
	
	
	public  void addEtudiant(String id, int cin, String nom, String prenom,String mailEtud, String classe);
	public  void editEtudiant(String id, int cin, String nom, String prenom,String mailEtud, String classe);
	public  Etudiant getEtudiant(String id); 
	public  List<Etudiant> getEtudiants(); 
	public  void deleteEtudiant(String id);
	public  int verifEtudiantExiste(String code, String mail, int cin);

}
