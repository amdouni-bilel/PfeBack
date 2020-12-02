package emploi.com.tn.Implementation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emploi.com.tn.dao.IDispoEnseignant;
import emploi.com.tn.dao.IEnseignantDAO;
import emploi.com.tn.dao.IEspDeptDAO;
import emploi.com.tn.dao.IExamenDAO;
import emploi.com.tn.entities.Dispo_Ensgeinant;
import emploi.com.tn.entities.Dispo_Salle;
import emploi.com.tn.entities.Enseignant;
import emploi.com.tn.entities.Etudiant;
import emploi.com.tn.entities.Examen;
import emploi.com.tn.entities.Salle;
import emploi.com.tn.service.IEnseignantService;

@Service
public class EnseignantImplementation implements IEnseignantService{
	
	@Autowired
    private IEnseignantDAO enseignantRepository;
	@Autowired
    private IDispoEnseignant dispoEnstRepository;
	@Autowired
    private IExamenDAO examenRepository;
	@Autowired
    private IEspDeptDAO deprtRepository;
	
	@Override
	public void addEnseignant(String code, String nom, String prenom, int tel, String mail, String sexe, String type, int departement) {
		Enseignant e = new Enseignant();
		e.setIdEns(code);
		e.setNom(nom);
		e.setPrenom(prenom);
		e.setTel(tel);
		e.setMail(mail);
		e.setSex(sexe);
		e.setTypeEns(type);
		e.setNbrHeursurveillance(0);
		e.setNbrsurveillance(0);
		e.setEspdept(deprtRepository.findById(departement).get()); 
		enseignantRepository.save(e);
	}

	@Override
	public void editEnseignant(String code, String nom, String prenom, int tel, String mail, String sexe, String type, int departement) {
		Enseignant e = enseignantRepository.findById(code).get() ; 
		e.setNom(prenom);
		e.setPrenom(prenom);
		e.setTel(tel);
		e.setMail(mail);
		e.setSex(sexe);
		e.setTypeEns(type);
		e.setNbrHeursurveillance(0);
		e.setNbrsurveillance(0);
		e.setEspdept(deprtRepository.findById(departement).get()); 
		enseignantRepository.save(e);
	}

	@Override
	public Enseignant getEnseignant(String id) {
		// TODO Auto-generated method stub
		return enseignantRepository.findById(id).get();
	}

	@Override
	public List<Enseignant> getEnseignants() {
		// TODO Auto-generated method stub
		return enseignantRepository.findAll();
	}

	@Override
	public void deleteEnseignant(String id) {
		enseignantRepository.deleteById(id);
	}

 

	@Override
	public List<Enseignant> getEnseignantsDisponibles(String date, String heure) {
		List<Dispo_Ensgeinant> allDispos = dispoEnstRepository.findAll();
		List<Enseignant>  all = enseignantRepository.findAll(); 
		List<Examen>  examens = examenRepository.findAll(); 
		List<Enseignant>  enseignants = new ArrayList<Enseignant>();
		// conversion date et heure en dateTime 
		DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		Date dateHeure = null ;
		Date dateSaisie = null ; 
		try { 
			dateHeure = dateTimeFormat.parse(date+" "+heure);
			dateSaisie = dateFormat.parse(date);
		    System.out.println("date time apres conversion---------->"+dateHeure);  
		} 
		catch (ParseException e) {
		    e.printStackTrace();
		}   
	 
		for(int i=0; i<all.size(); i++) { 
			 int a = verifSalleInExamen(all.get(i).getIdEns(), dateSaisie, heure); 
			 int b = verifSalleInDisponibilite(all.get(i).getIdEns(), dateHeure);  
			 if(a==0 &&b==0) {
				 enseignants.add(all.get(i)); 
			 } 
		}
		  return  enseignants;
	}
	
	
	
	public int verifSalleInExamen(String codeEns, Date date, String heure){
		int x=0; 
		List<Examen>  examens = examenRepository.findAll(); 
		for(int j=0; j<examens.size(); j++) {
			if(examens.get(j).getEnseignant().getIdEns().equals(codeEns)) { 
				if(examens.get(j).getDateEx().equals(date) && (examens.get(j).getHeureEx()+":00").equals(heure)) {
					x= 1; 
				} else {
					x= 0;
				}
			}
		} 
		return x; 
	}
	
	public int verifSalleInDisponibilite(String codeEns, Date dateHeure) {
		int y=0; 
		List<Dispo_Ensgeinant> allDispos = dispoEnstRepository.findAll();
		for(int k=0; k<allDispos.size(); k++) {   
			if(allDispos.get(k).getEns().getIdEns().equals(codeEns))  {
				if(dateHeure.equals(allDispos.get(k).getDateDebut())  ||  (dateHeure.after(allDispos.get(k).getDateDebut()) && dateHeure.before(allDispos.get(k).getDateFin()))) {  
					y= 1; 
				} else {
					y= 0;
				}
			
			}
		} 
		return y;
	}

	@Override
	public void editSurveillanceEnseignant(String code) {
		Enseignant e = enseignantRepository.findById(code).get();
		int a = ((int) e.getNbrHeursurveillance()) +1; 
		int b = (e.getNbrsurveillance())+1; 
		e.setNbrHeursurveillance(a);
		e.setNbrsurveillance(b);
		enseignantRepository.save(e);
		
	}

	@Override
	public int verifEnseignantExiste(String mail, int tel, String code) {
		int x = 0;
		List<Enseignant> all = enseignantRepository.findAll();
		for(int i=0; i<all.size(); i++) {
			if(all.get(i).getIdEns().equals(code)|| all.get(i).getMail().equals(mail) || all.get(i).getTel()== tel) {
				x=1; 
			}
		}
		return x;
	}
}
