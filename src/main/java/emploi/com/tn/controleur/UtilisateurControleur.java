package emploi.com.tn.controleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;

import emploi.com.tn.entities.Utilisateur;
import emploi.com.tn.service.IUtilisateurService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class UtilisateurControleur {

	@Autowired
	private IUtilisateurService userService;
	
	@GetMapping("/users")
	public List<Utilisateur> getAll() { 
		return userService.getUtilisateurs(); 
	}

	@PostMapping("/users")
	public boolean ajout(@RequestBody Utilisateur usr) { 
		userService.addUtilisateur(usr);
		return true;
	}

	@PutMapping("/users")
	public boolean update(@RequestBody Utilisateur usr) {   
		userService.editUtilisateur(usr);
		return true;

	}

	@GetMapping("/users/{id}")
	public Utilisateur getById(@PathVariable("id") int id) {
		System.out.println("----------> show IDD : " + id); 
		Utilisateur ens = userService.getUtilisateur(id) ;
		return ens; 

	}

	@DeleteMapping("/users/{id}")
	public boolean  delet(@PathVariable int id) { 
		userService.deleteUtilisateur(id);
		return true; 
	}
	
	
	@PostMapping("/users/login")
	public Utilisateur veriif(@RequestBody Utilisateur usr) {
		System.out.println("----------> MAIL : " + usr.getMail()); 
		System.out.println("----------> PASSWORD : " + usr.getPassword());   
		return userService.verifUser( usr.getMail(), usr.getPassword());
	}
}
