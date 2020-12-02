package emploi.com.tn.controleur;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import emploi.com.tn.entities.Examen;
import emploi.com.tn.service.IEnseignantService;
import emploi.com.tn.service.IExamenService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class ExamenControleur {

	@Autowired
	private IExamenService examenService;
	@Autowired
	private IEnseignantService enseignantService;
	
	@GetMapping("/examens")
	public List<Examen> getAll() { 
		return examenService.getExamens(); 
	}

	@PostMapping("/examens")
	public boolean ajout(@RequestBody JSONObject obj)throws Exception {  
		System.out.println("----------> Object recus : " + obj); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateEx=null;
		try {
			dateEx = dateFormat.parse(obj.get("dateEx").toString());
		    System.out.println("date ---------->"+dateEx.toString());  
		} 
		catch (ParseException e) {
		    e.printStackTrace();
		} 
		String heure  = obj.get("heureEx").toString();
		String duree  = obj.get("dureeEx").toString(); 
		String dsex  = obj.get("dsex").toString(); 
		String semestre  = obj.get("semestre").toString();
		String session  = obj.get("session").toString();
		String typeEx  = obj.get("typeEx").toString();
		String classe  = obj.get("classe").toString();
		String mod  =  obj.get("espModule").toString() ;
		String ens  =  obj.get("enseignant").toString() ;
		String salle  = obj.get("salle").toString();
		String groupe  = obj.get("groupe").toString();
		int test = examenService.verifExistanceExamen(dateEx, heure, classe, groupe);
		if(test==1) {
			return false;
		}else {
			examenService.addExamen(dateEx, heure, duree, dsex, semestre, session, typeEx, classe, mod, ens, salle, groupe);
			enseignantService.editSurveillanceEnseignant(ens);
			return true;
		}
		 
	}

	@PutMapping("/examens")
	public boolean update(@RequestBody JSONObject obj)throws Exception {  
		System.out.println("----------> Object recus : " + obj); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateEx=null;
		try {
			dateEx = dateFormat.parse(obj.get("dateEx").toString());
		    System.out.println("date ---------->"+dateEx.toString());  
		} 
		catch (ParseException e) {
		    e.printStackTrace();
		} 
		int idd  = Integer.parseInt(obj.get("idExamen").toString()); 
		String heure  = obj.get("heureEx").toString();
		String duree  = obj.get("dureeEx").toString(); 
		String dsex  = obj.get("dsex").toString(); 
		String semestre  = obj.get("semestre").toString();
		String session  = obj.get("session").toString();
		String typeEx  = obj.get("typeEx").toString();
		String classe  = obj.get("classe").toString();
		String mod  =  obj.get("espModule").toString() ;
		String ens  =  obj.get("enseignant").toString() ;
		String salle  = obj.get("salle").toString();
		String groupe  = obj.get("groupe").toString();
		examenService.editExamen(idd, dateEx, heure, duree, dsex, semestre, session, typeEx, classe, mod, ens, salle, groupe);
		return true;

	}

	@GetMapping("/examens/{id}")
	public Examen getByID(@PathVariable("id") int id) {
		System.out.println("----------> IDD : " + id); 
		Examen ex = examenService.getExamen(id); 
		return ex; 

	}

	@DeleteMapping("/examens/{id}")
	public boolean  deletee(@PathVariable int id) { 
		examenService.deleteExamen(id);
		return true; 
	}
}
