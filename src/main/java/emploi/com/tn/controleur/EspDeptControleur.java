package emploi.com.tn.controleur;


import emploi.com.tn.Implementation.EspDeptImplementation;
import emploi.com.tn.entities.ESP_Dept;
import emploi.com.tn.service.IEspDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class EspDeptControleur {

    @Autowired
    private IEspDeptService espdeptService;

    @GetMapping("/espdept")
    public List<ESP_Dept> getAll() {

        List <ESP_Dept> espDepts = espdeptService.getEspDepts();
        return espDepts ;
    }

    @GetMapping("/espdept/{id}")
    public ESP_Dept getByID(@PathVariable("id") int id) {
        System.out.println("----------> IDD : " + id);
        ESP_Dept espDept = espdeptService.getEspDept(id);
        return espDept;
    }

}


