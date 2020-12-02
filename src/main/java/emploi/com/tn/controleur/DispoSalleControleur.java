package emploi.com.tn.controleur;

import emploi.com.tn.entities.Dispo_Salle;
import emploi.com.tn.entities.Enseignant;
import emploi.com.tn.entities.Examen;
import emploi.com.tn.service.IDispoSalleService;
import emploi.com.tn.service.IEnseignantService;
import emploi.com.tn.service.ISalleService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class DispoSalleControleur {

    @Autowired
    private IDispoSalleService dispoSalleService;

    @Autowired
    private ISalleService salleService;

    @GetMapping("/disposalle")
    public List<Dispo_Salle> getDispoSalles() {
        return dispoSalleService.getDispoSalles();
    }


    @PostMapping("/disposalle")
    public boolean ajout(@RequestBody JSONObject obj)throws Exception {
        System.out.println("----------> Object recus : " + obj);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateDebut=null;
        try {
            dateDebut = dateFormat.parse(obj.get("dateDebut").toString());
            System.out.println("date ---------->"+dateDebut.toString());
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        Date dateFin=null;
        try {
            dateFin = dateFormat.parse(obj.get("dateFin").toString());
            System.out.println("date ---------->"+dateFin.toString());
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        String heureDebut = obj.get("heureDebut").toString();
        String heureFin = obj.get("heureFin").toString();
        String motif = obj.get("motif").toString();
        String salle = obj.get("salle").toString();

        dispoSalleService.createDispoSalle(dateDebut, dateFin, heureDebut, heureFin, motif, salle);
        return true;
    }

    @PutMapping("/disposalle")
    public boolean update(@RequestBody JSONObject obj)throws Exception {
            System.out.println("----------> Object recus : " + obj);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateDebut=null;
            try {
                dateDebut = dateFormat.parse(obj.get("dateDebut").toString());
                System.out.println("date ---------->"+dateDebut.toString());
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
                Date dateFin=null;
                try {
                    dateFin = dateFormat.parse(obj.get("dateFin").toString());
                    System.out.println("date ---------->"+dateFin.toString());
                }
                catch (ParseException r) {
                    r.printStackTrace();
                }
        int idd  = Integer.parseInt(obj.get("id").toString());
                String heureDebut = obj.get("heureDebut").toString();
                String heureFin = obj.get("heureFin").toString();
                String motif = obj.get("motif").toString();
                String salle = obj.get("salle").toString();
        dispoSalleService.updateDispoSalle(idd, dateDebut, dateFin, heureDebut, heureFin, motif, salle);
        return true;

    }

    @GetMapping("/disposalle/{id}")
    public Dispo_Salle getByID(@PathVariable("id") int id) {
        System.out.println("----------> IDD : " + id);
        Dispo_Salle dis = dispoSalleService.getDispoSalle(id);
        return dis;

    }

    @DeleteMapping("/disposalle/{id}")
    public boolean  deletee(@PathVariable int id) {
        dispoSalleService.deleteDispoSalle(id);
        return true;
    }

}
