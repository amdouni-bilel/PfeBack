package emploi.com.tn.service;

import java.util.List;

import emploi.com.tn.entities.Utilisateur;

public interface IUtilisateurService {
	
	public  void addUtilisateur(Utilisateur usr); 
	public  void editUtilisateur(Utilisateur usr); 
	public  Utilisateur getUtilisateur(int id); 
	public  List<Utilisateur> getUtilisateurs(); 
	public  void deleteUtilisateur(int id);
	public  Utilisateur verifUser(String mail, String password);

}
