package emploi.com.tn.Implementation;

import java.util.ArrayList;
import java.util.List;

import emploi.com.tn.dao.IClasseDAO;
import emploi.com.tn.entities.Enseignant;
import emploi.com.tn.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emploi.com.tn.dao.IESPModuleDAO;
import emploi.com.tn.dao.IEnseignantDAO;
import emploi.com.tn.entities.ESP_Module;
import emploi.com.tn.service.IESPModuleService;

@Service
public class ESPModuleImplementation implements IESPModuleService{

	@Autowired
	private IESPModuleDAO esModuleRepository;
	@Autowired
	private IClasseDAO classeRepository;
	@Autowired
    private IEnseignantDAO enseignantRepository;
	
	@Override
	public void addESPModule(String code, float coff, String lib, int nbHeurs, String periode, String semestre, String typeEpreuve, String classe, String enseignant) {
		ESP_Module m = new ESP_Module();
		m.setCodeModule(code);
		m.setCoefficient(coff);
		m.setDesignation(lib);
		m.setNbrHeures(nbHeurs);
		m.setPeriode(periode);
		m.setSemestre(semestre);
		m.setTypeEpreuve(typeEpreuve);
		m.setClasse(classeRepository.findById(classe).get());
		m.setEnseignant(enseignantRepository.findById(enseignant).get());
		m.setUe(null);
		esModuleRepository.save(m); 
	}

	@Override
	public void editESPModule(String code, float coff, String lib, int nbHeurs, String periode, String semestre, String typeEpreuve, String classe, String enseignant)
	{
		ESP_Module m = esModuleRepository.findById(code).get(); 
		m.setCoefficient(coff);
		m.setDesignation(lib);
		m.setNbrHeures(nbHeurs);
		m.setPeriode(periode);
		m.setSemestre(semestre);
		m.setTypeEpreuve(typeEpreuve);
		m.setClasse(classeRepository.findById(classe).get());
		m.setEnseignant(enseignantRepository.findById(enseignant).get());
		m.setUe(null);
		esModuleRepository.save(m);  
	} 

	 

	@Override
	public ESP_Module getESPModule(String id) {
		// TODO Auto-generated method stub
		return esModuleRepository.findById(id).get();
	}

	@Override
	public List<ESP_Module> getESPModules() {
		// TODO Auto-generated method stub
		return esModuleRepository.findAll();
	}

	@Override
	public void deleteESPModule(String id) {
		esModuleRepository.deleteById(id);
	}

	@Override
	public List<ESP_Module> getModulesByClasse(String classe) {
		List<ESP_Module> all = esModuleRepository.findAll();
		List<ESP_Module>  mods = new ArrayList<ESP_Module>();
		for(int i=0; i<all.size(); i++) {
			if(all.get(i).getClasse().equals(classe)) {
				mods.add(all.get(i));
			}
		}
		return mods;
	}

	@Override
	public List<Enseignant> getEnseignantByModule(String enseignant) {
		List<ESP_Module> all = esModuleRepository.findAll();
		List<Enseignant>  ens = new ArrayList<Enseignant>();
		for(int i=0; i<all.size(); i++) {
			if(all.get(i).getEnseignant().equals(enseignant)) {
				ens.add(all.get(i).getEnseignant());
			}
		}
		return ens;
	}

	@Override
	public int verifModuleExiste(String code, String lib) {
		int x = 0;
		List<ESP_Module> all = esModuleRepository.findAll();
		for(int i=0; i<all.size(); i++) {
			if(all.get(i).getCodeModule().equals(code)  || all.get(i).getDesignation().equals(lib)) {
				x=1; 
			}
		}
		return x;
	}
}
