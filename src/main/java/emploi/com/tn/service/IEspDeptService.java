package emploi.com.tn.service;

import emploi.com.tn.entities.ESP_Dept;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IEspDeptService {

    public ESP_Dept getEspDept(int id);
    public List<ESP_Dept> getEspDepts();
}
