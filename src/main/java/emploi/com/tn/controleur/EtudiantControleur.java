package emploi.com.tn.controleur;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emploi.com.tn.entities.Enseignant;
import emploi.com.tn.entities.Etudiant;
import emploi.com.tn.service.IClasseService;
import emploi.com.tn.service.IEnseignantService;
import emploi.com.tn.service.IEtudiantService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class EtudiantControleur {
	
	@Autowired
	private IEtudiantService etudiantService;
	 

	@GetMapping("/etudiants")
	public List<Etudiant> getAll()throws Exception { 
		return etudiantService.getEtudiants(); 
	}

	@PostMapping("/etudiants")
	public boolean ajout(@RequestBody JSONObject obj)throws Exception {  
		System.out.println("----------> Object recus : " + obj); 
		int cin  = Integer.parseInt(obj.get("cin").toString());
		String nom  = obj.get("nom").toString();
		String prenom  = obj.get("prenom").toString();
		String mailEtud  = obj.get("mailEtud").toString();
		String classe  = obj.get("classe").toString();
		etudiantService.addEtudiant( cin, nom, prenom,mailEtud , classe);
		return true;
	}

	@PutMapping("/etudiants")
	public boolean update(@RequestBody JSONObject obj)throws Exception { 
		int idd  = Integer.parseInt(obj.get("idEtudiant").toString());
		int cin  = Integer.parseInt(obj.get("cin").toString());
		String nom  = obj.get("nom").toString();
		String prenom  = obj.get("prenom").toString();
		String mailEtud  = obj.get("mailEtud").toString();
		String classe  = obj.get("classe").toString();
		etudiantService.editEtudiant( idd, cin, nom, prenom,mailEtud, classe);
		return true;

	}

	@GetMapping("/etudiants/{id}")
	public Etudiant getByID(@PathVariable("id") int id) {
		System.out.println("----------> IDD : " + id); 
		Etudiant etd = etudiantService.getEtudiant(id); 
		return etd; 

	}

	@DeleteMapping("/etudiants/{id}")
	public boolean  deletee(@PathVariable int id) { 
		etudiantService.deleteEtudiant(id); 
		return true; 
	}
 
}
 
