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
import emploi.com.tn.service.IEnseignantService;  

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class EnseignantControleur {
	 
	@Autowired
	private IEnseignantService enseignantService;

	@GetMapping("/enseignants")
	public List<Enseignant> getAll() { 
		return enseignantService.getEnseignants(); 
	}

	@PostMapping("/enseignants")
	public boolean ajout(@RequestBody JSONObject obj)throws Exception {  
		System.out.println("----------> Object recus : " + obj); 
		String  id  =  obj.get("idEns").toString() ; 
		String nom  = obj.get("nom").toString();
		String prenom  = obj.get("prenom").toString();
		String mail  = obj.get("mail").toString();
		int tel  = Integer.parseInt(obj.get("tel").toString());
		String sexe  = obj.get("sex").toString();
		String type  = obj.get("typeEns").toString();
		int depart  = Integer.parseInt(obj.get("esp_dept").toString());
		int test = enseignantService.verifEnseignantExiste(mail, tel, id);
		if(test==1) {
			return false;
		}else {
			enseignantService.addEnseignant(id, nom, prenom, tel, mail, sexe, type, depart);
			return true;
		}
	}

	@PutMapping("/enseignants")
	public boolean update(@RequestBody JSONObject obj)throws Exception {  
		System.out.println("----------> Object recus : " + obj); 
		String  id  =  obj.get("idEns").toString() ; 
		String nom  = obj.get("nom").toString();
		String prenom  = obj.get("prenom").toString();
		String mail  = obj.get("mail").toString();
		int tel  = Integer.parseInt(obj.get("tel").toString());
		String sexe  = obj.get("sex").toString();
		String type  = obj.get("typeEns").toString();
		int depart  = Integer.parseInt(obj.get("esp_dept").toString()); 
		enseignantService.editEnseignant(id, nom, prenom, tel, mail, sexe, type, depart);
		return true;
	}
	
	@PostMapping("/verifEnseignant")
	public List<Enseignant> goooo(@RequestBody JSONObject obj)throws Exception {
		System.out.println("-----OK-----");  
		String dd= obj.get("date").toString();
		String hh= obj.get("heure").toString()+":00";   
		List<Enseignant> enss = enseignantService.getEnseignantsDisponibles(dd, hh);
		return enss;
	}

	@GetMapping("/enseignants/{id}")
	public Enseignant getById(@PathVariable("id") String id) {
		System.out.println("----------> IDD : " + id); 
		Enseignant ens = enseignantService.getEnseignant(id); 
		return ens; 

	}

	@DeleteMapping("/enseignants/{id}")
	public boolean  delet(@PathVariable String id) { 
		enseignantService.deleteEnseignant(id); 
		return true; 
	}
 
}
