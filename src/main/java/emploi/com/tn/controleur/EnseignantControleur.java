package emploi.com.tn.controleur;

import java.util.List;

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
	public boolean ajout(@RequestBody Enseignant ens) { 
		enseignantService.addEnseignant(ens); 
		return true;
	}

	@PutMapping("/enseignants")
	public boolean update(@RequestBody Enseignant ens) {   
		enseignantService.editEnseignant(ens); 
		return true;

	}

	@GetMapping("/enseignants/{id}")
	public Enseignant getById(@PathVariable("id") int id) {
		System.out.println("----------> IDD : " + id); 
		Enseignant ens = enseignantService.getEnseignant(id); 
		return ens; 

	}

	@DeleteMapping("/enseignants/{id}")
	public boolean  delet(@PathVariable int id) { 
		enseignantService.deleteEnseignant(id); 
		return true; 
	}
 
}
