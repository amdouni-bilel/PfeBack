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
	public boolean ajout(@RequestBody JSONObject obj)throws Exception {
		System.out.println("----------> Object recus : " + obj);
		String code  = obj.get("codeModule").toString();
		String lib  = obj.get("designation").toString();
		int nbHeurs  = Integer.parseInt(obj.get("nbrHeures").toString());
		float coff  = Integer.parseInt(obj.get("coefficient").toString());
		String typeEpreuve  = obj.get("typeEpreuve").toString();
		String semestre  = obj.get("semestre").toString();
		String periode  = obj.get("periode").toString();
		String classe  = obj.get("classe").toString();
		String enseignant  = obj.get("enseignant").toString(); 
		int test = espModuleService.verifModuleExiste(code, lib);
		if(test==1) {
			return false;
		}else {
			espModuleService.addESPModule(code, coff, lib, nbHeurs, periode, semestre, typeEpreuve, classe, enseignant);
			return true;
		} 
	}

	@PutMapping("/modules")
	public boolean update(@RequestBody JSONObject obj)throws Exception {
		String code  = obj.get("codeModule").toString();
		String lib  = obj.get("designation").toString();
		int nbHeurs  = Integer.parseInt(obj.get("nbrHeures").toString());
		float coff  = Integer.parseInt(obj.get("coefficient").toString());
		String typeEpreuve  = obj.get("typeEpreuve").toString();
		String semestre  = obj.get("semestre").toString();
		String periode  = obj.get("periode").toString();
		String classe  = obj.get("classe").toString();
		String enseignant  = obj.get("enseignant").toString(); 
		espModuleService.editESPModule(code, coff, lib, nbHeurs, periode, semestre, typeEpreuve, classe, enseignant);;
		return true;
	}

	/*
	@PostMapping("/espmodule")
	public boolean ajout(@RequestBody ESP_Module esp_module) {
		espModuleService.addESPModule(esp_module);
		return true;
	}

	@PutMapping("/espmodule/{id}")
	public boolean update(@RequestBody ESP_Module esp_module) {
		espModuleService.addESPModule(esp_module);
		return true;
	}*/
	
	
	@GetMapping("/modules/{id}")
	public ESP_Module getByID(@PathVariable("id") String id) {
		System.out.println("----------> IDD : " + id);
		ESP_Module espM = espModuleService.getESPModule(id) ;
		return espM;
	}

	@DeleteMapping("/modules/{id}")
	public boolean  deletee(@PathVariable String id) {
		espModuleService.deleteESPModule(id);
		return true;
	}

}
