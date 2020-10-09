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

import emploi.com.tn.entities.ESP_Module; 
import emploi.com.tn.service.IESPModuleService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class EspModuleControleur {
	
	@Autowired
	private IESPModuleService espModuleService;
	
	@GetMapping("/modules")
	public List<ESP_Module> getAll() { 
		return espModuleService.getESPModules();
	}

	@PostMapping("/modules")
	public boolean ajout(@RequestBody ESP_Module espM) { 
		espModuleService.addESPModule(espM);
		return true;
	}

	@PutMapping("/modules")
	public boolean update(@RequestBody ESP_Module espM) {   
		espModuleService.editESPModule(espM); 
		return true;

	}

	@GetMapping("/modules/{id}")
	public ESP_Module getByID(@PathVariable("id") int id) {
		System.out.println("----------> IDD : " + id); 
		ESP_Module ex = espModuleService.getESPModule(id) ;
		return ex; 

	}

	@DeleteMapping("/modules/{id}")
	public boolean  deletee(@PathVariable int id) { 
		espModuleService.deleteESPModule(id);
		return true; 
	}

}
