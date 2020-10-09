package emploi.com.tn.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
  
import emploi.com.tn.dao.IUtilisateurDAO;
import emploi.com.tn.entities.Utilisateur;
import emploi.com.tn.service.IUtilisateurService;

@Service
public class UtilisateurImplementation implements IUtilisateurService{
	@Autowired
    private IUtilisateurDAO userRepository;

	@Override
	public void addUtilisateur(Utilisateur usr) {
		userRepository.save(usr);
	}

	@Override
	public void editUtilisateur(Utilisateur usr) {
		userRepository.save(usr);
	}

	@Override
	public Utilisateur getUtilisateur(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public List<Utilisateur> getUtilisateurs() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public void deleteUtilisateur(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public Utilisateur verifUser(String mail, String password) {
		System.out.println("----------> MAIL : " + mail); 
		System.out.println("----------> PASSWORD : " + password); 
		List<Utilisateur> users = userRepository.findAll();
		Utilisateur u  = new Utilisateur() ; 
		for(int i=0;i<users.size();i++) {
			if(users.get(i).getMail().equals(mail)  && users.get(i).getPassword().equals(password)) {
				u = users.get(i) ;
			} 
		}
		return u;
	}
}
