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
	public void addEtudiant(int cin, String nom, String prenom,String mailEtud , String classe) {
		Etudiant e = new Etudiant();
		e.setCin(cin);
		e.setNom(nom);
		e.setPrenom(prenom);
		e.setMailEtud(mailEtud);
		e.setClasse(classeRepository.findById(classe).get());
		etudiantRepository.save(e);
	}

	@Override
	public void editEtudiant(int id, int cin, String nom, String prenom,String mailEtud ,  String classe) {
		Etudiant e =  etudiantRepository.findById(id).get();
		e.setCin(cin);
		e.setNom(nom);
		e.setPrenom(prenom);
		e.setMailEtud(mailEtud);
		e.setClasse(classeRepository.getOne(classe));
		etudiantRepository.save(e);
	}

	@Override
	public Etudiant getEtudiant(int id) {
		// TODO Auto-generated method stub
		return etudiantRepository.findById(id).get();
	}

	@Override
	public List<Etudiant> getEtudiants() {
		// TODO Auto-generated method stub
		return etudiantRepository.findAll();
	}

	@Override
	public void deleteEtudiant(int id) {
		etudiantRepository.deleteById(id);
	}
}
