package emploi.com.tn.service;

import java.util.List;

import emploi.com.tn.entities.AnneeUniversitaire; 

public interface IAnneeUniversitaireService {

	 
	public  AnneeUniversitaire getAnneeUniversitaire(int id); 
	public  List<AnneeUniversitaire> getAnneeUniversitaires();   
}
