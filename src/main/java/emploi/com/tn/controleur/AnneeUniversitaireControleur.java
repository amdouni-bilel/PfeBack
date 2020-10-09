package emploi.com.tn.controleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emploi.com.tn.entities.AnneeUniversitaire;
import emploi.com.tn.entities.Salle;
import emploi.com.tn.service.IAnneeUniversitaireService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class AnneeUniversitaireControleur {

	@Autowired
	private IAnneeUniversitaireService auService;
	
	@GetMapping("/aus")
	public List<AnneeUniversitaire> getAlls() {
		List<AnneeUniversitaire> auLST = auService.getAnneeUniversitaires();
		return auLST;
	}
	
	@GetMapping("/aus/{id}")
	public AnneeUniversitaire getByID(@PathVariable("id") int id) {
		System.out.println("----------> IDD : " + id); 
		AnneeUniversitaire au = auService.getAnneeUniversitaire(id); 
		return au; 
	}

}
