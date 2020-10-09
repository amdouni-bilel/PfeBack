package emploi.com.tn.controleur;
 
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import emploi.com.tn.entities.Enseignant;
import emploi.com.tn.entities.Salle;
import emploi.com.tn.service.ISalleService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class SalleControleur {
	@Autowired
	private ISalleService salleService;

	@GetMapping("/salles")
	public ResponseEntity<Object> getSalles() {
		List<Salle> employeeList = salleService.getSalles();
		return new ResponseEntity<>(employeeList, HttpStatus.OK);
	}
	
	
	@PostMapping("/salles")
	public boolean ajout(@RequestBody Salle salle) {
		salleService.createSalle(salle); 
		return true;
	}
	
 
 

	@PutMapping("/salles")
	public boolean updateSalle(@RequestBody Salle salle) { 
		System.out.println("----------> Capacite : " + salle.getCapacite());
		System.out.println("----------> Type : " + salle.getTypeSalle());
		System.out.println("----------> ID : " + salle.getCodeSalle()); 
		salleService.updateSalle(salle);
		return true;

	}

	@GetMapping("/salles/{id}")
	public Salle getSalle(@PathVariable("id") int id) {
		System.out.println("----------> IDD : " + id); 
		Salle salle = salleService.getSalle(id); 
		return salle; 

	}

	@DeleteMapping("/salles/{id}")
	public boolean  deleteSalle(@PathVariable int id) { 
		salleService.deleteSalle(id); 
		return true; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*
	 @RequestMapping(value = "/salles", method = RequestMethod.GET)
	public ResponseEntity<Object> getSalles() {
		List<Salle> employeeList = salleService.getSalles();
		return new ResponseEntity<>(employeeList, HttpStatus.OK);
	}

	@RequestMapping(value = "/salles", method = RequestMethod.POST)
	public ResponseEntity<Object> createSalle(@RequestBody Salle salle) {
		System.out.println("----------> Capacite : " + salle.getCapacite());
		System.out.println("----------> Type : " + salle.getTypeSalle());
		salle = salleService.createSalle(salle);
		Map<String, String> response = new HashMap<>();
		response.put("result", "SUCCESS");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/salles/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateSalle(@PathVariable("id") int id, @RequestBody Salle salle) {
		boolean isSalleExist = salleService.isSalleExist(id);
		System.out.println("----------> Capacite : " + salle.getCapacite());
		System.out.println("----------> Type : " + salle.getTypeSalle());
		System.out.println("----------> ID : " + id);
		if (isSalleExist) {
			salle.setCodeSalle(id);
			salleService.updateSalle(salle);
			Map<String, String> response = new HashMap<>();
			response.put("result", "SUCCESS");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			Map<String, String> response = new HashMap<>();
			response.put("result", "ERREUR");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/salles/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getSalle(@PathVariable("id") int id) {
		System.out.println("----------> IDD : " + id);
		boolean isEmployeeExist = salleService.isSalleExist(id);
		if (isEmployeeExist) {
			Salle employee = salleService.getSalle(id);
			return new ResponseEntity<>(employee, HttpStatus.OK);
		} else {
			Map<String, String> response = new HashMap<>();
			response.put("result", "ERREUR");
			return response;
		}

	}

	@RequestMapping(value = "/salles/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteSalle(@PathVariable("id") int id) {
		boolean isSalleExist = salleService.isSalleExist(id);
		if (isSalleExist) {
			salleService.deleteSalle(id);
			Map<String, String> response = new HashMap<>();
			response.put("result", "SUCCESS");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			Map<String, String> response = new HashMap<>();
			response.put("result", "ERREUR");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

	}
	 */
}
