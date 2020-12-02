package emploi.com.tn.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emploi.com.tn.dao.IClasseDAO;
import emploi.com.tn.dao.IEtudiantDAO;
import emploi.com.tn.entities.Etudiant;
import emploi.com.tn.service.IEtudiantService;

@Service
public class EtudiantImplementation implements IEtudiantService{

	@Autowired
    private IEtudiantDAO etudiantRepository;
	@Autowired
    private IClasseDAO classeRepository;
	
	@Override
	public void addEtudiant(String id, int cin, String nom, String prenom,String mailEtud , String classe) {
		Etudiant e = new Etudiant();
		e.setId(id);
		e.setCin(cin);
		e.setNom(nom);
		e.setPrenom(prenom);
		e.setMailEtud(mailEtud);
		e.setClasse(classeRepository.findById(classe).get());
		etudiantRepository.save(e);
	}

	@Override
	public void editEtudiant(String id, int cin, String nom, String prenom,String mailEtud ,  String classe) {
		Etudiant e =  etudiantRepository.findById(id).get();
		e.setCin(cin);
		e.setNom(nom);
		e.setPrenom(prenom);
		e.setMailEtud(mailEtud);
		e.setClasse(classeRepository.findById(classe).get());
		etudiantRepository.save(e);
	}

	@Override
	public Etudiant getEtudiant(String id) {
		// TODO Auto-generated method stub
		return etudiantRepository.findById(id).get(); 
	}

	@Override
	public List<Etudiant> getEtudiants() {
		// TODO Auto-generated method stub
		return etudiantRepository.findAll();
	}

	@Override
	public void deleteEtudiant(String id) {
		etudiantRepository.deleteById(id);
	}

	@Override
	public int verifEtudiantExiste(String code, String mail, int cin) {
		int x = 0;
		List<Etudiant> all = etudiantRepository.findAll();
		for(int i=0; i<all.size(); i++) {
			if(all.get(i).getCin()==cin || all.get(i).getMailEtud().equals(mail) || all.get(i).getId().equals(code)) {
				x=1; 
			}
		}
		return x;
	}
}
