package emploi.com.tn.Implementation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emploi.com.tn.dao.IDispoSalleDAO;
import emploi.com.tn.dao.IExamenDAO;
import emploi.com.tn.dao.ISalleDAO;
import emploi.com.tn.entities.Dispo_Salle;
import emploi.com.tn.entities.Examen;
import emploi.com.tn.entities.Salle;
import emploi.com.tn.service.ISalleService;


@Service
public class SalleImplementation  implements ISalleService {

	@Autowired
    private ISalleDAO salleRepository;
	@Autowired
    private IDispoSalleDAO dispoSalleRepository;
	@Autowired
    private IExamenDAO examenRepository;
	
	@Override
	public void createSalle(Salle salle) {
		 salleRepository.save(salle);
	}

	@Override
	public void updateSalle(Salle salle) {  
		Salle s = salleRepository.getOne(salle.getCodeSalle());
		s.setCapacite(salle.getCapacite());
		s.setSite(salle.getSite());
		salleRepository.save(salle);
	}

	@Override
	public Salle getSalle(String id) {
		return salleRepository.findById(id).get(); 
	}

	@Override
	public List<Salle> getSalles() {
		// TODO Auto-generated method stub
		return  (List<Salle>)salleRepository.findAll(); 
	}

	@Override
	public void deleteSalle(String id) {
		salleRepository.deleteById(id);
	}

	@Override
	public List<Salle> getSallesDisponibles(String date, String heure) {
		List<Dispo_Salle> allDispos = dispoSalleRepository.findAll();
		List<Salle>  all = salleRepository.findAll(); 
		List<Examen>  examens = examenRepository.findAll(); 
		List<Salle>  sals = new ArrayList<Salle>();
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
			 int a = verifSalleInExamen(all.get(i).getCodeSalle(), dateSaisie, heure); 
			 int b = verifSalleInDisponibilite(all.get(i).getCodeSalle(), dateHeure);  
			 if(a==0 &&b==0) {
				 sals.add(all.get(i)); 
			 } 
		}
		  return  sals;
	}
	
	
	
	public int verifSalleInExamen(String codeSalle, Date date, String heure){
		int x=0; 
		List<Examen>  examens = examenRepository.findAll(); 
		for(int j=0; j<examens.size(); j++) {
			if(examens.get(j).getSalle().getCodeSalle().equals(codeSalle)) { 
				if(examens.get(j).getDateEx().equals(date) && (examens.get(j).getHeureEx()+":00").equals(heure)) {
					x= 1; 
				} else {
					x= 0;
				}
			}
		} 
		return x; 
	}
	
	public int verifSalleInDisponibilite(String codeSalle, Date dateHeure) {
		int y=0; 
		List<Dispo_Salle> allDispos = dispoSalleRepository.findAll();
		for(int k=0; k<allDispos.size(); k++) {   
			if(allDispos.get(k).getSalle().getCodeSalle().equals(codeSalle)) {
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
	public int verifExistanceSalle(String code) {
		int x = 0;
		List<Salle> all = salleRepository.findAll();
		for(int i=0; i<all.size(); i++) {
			if(all.get(i).getCodeSalle().equals(code) ) {
				x=1; 
			}
		}
		return x;
	}
	
	
	
	 
}
