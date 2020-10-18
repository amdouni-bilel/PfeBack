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

import emploi.com.tn.entities.Classe;
import emploi.com.tn.service.IClasseService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class ClasseControleur {
	
	@Autowired
	private IClasseService classeService;
	
	
	@GetMapping("/classes")
	public List<Classe> getAll() { 
		return classeService.getClasses(); 
	}

	@PostMapping("/classes")
	public boolean ajout(@RequestBody JSONObject obj)throws Exception{
		System.out.println("----------> Object recus : " + obj); 
		int nbr  = Integer.parseInt(obj.get("nbrEtudiant").toString());
		String lib  = obj.get("libelleCL").toString();
		String spec  = obj.get("specialite").toString();
		String mail  = obj.get("mail").toString();
		String groupe  = obj.get("groupe").toString();
		int au  = Integer.parseInt(obj.get("anneUniversitaire").toString());
		int espdept  = Integer.parseInt(obj.get("espdept").toString());
		classeService.addClasse(lib, nbr, spec,mail , groupe ,au , espdept);
		return true;
	}


	@PutMapping("/classes/{id}")
	public boolean update(@RequestBody JSONObject obj)throws Exception{   
		System.out.println("----------> Object recus : " + obj); 
		//String idd  = Integer.parseInt(obj.get("id").toString());
		String idd  = obj.get("id").toString();
		int nbr  = Integer.parseInt(obj.get("nbrEtudiant").toString());
		String lib  = obj.get("libelleCL").toString();
		String spec  = obj.get("specialite").toString();
		String mail  = obj.get("mail").toString();
		String groupe  = obj.get("groupe").toString();
		int au  = Integer.parseInt(obj.get("anneUniversitaire").toString());
		int espdept  = Integer.parseInt(obj.get("espdept").toString());
		classeService.editClasse(idd, lib, nbr, spec,mail, groupe ,au,espdept);
		return true;

	}

	@GetMapping("/classes/{id}")
	public Classe getByID(@PathVariable("id") String id) {
		System.out.println("----------> IDD : " + id); 
		Classe cl = classeService.getClasse(id); 
		return cl; 

	}

	@DeleteMapping("/classes/{id}")
	public boolean  deletee(@PathVariable String id) {
		classeService.deleteClasse(id);
		return true; 
	}
 
}
