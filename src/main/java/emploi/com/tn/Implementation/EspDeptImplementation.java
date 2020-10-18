package emploi.com.tn.Implementation;

import emploi.com.tn.dao.IEspDeptDAO;
import emploi.com.tn.entities.ESP_Dept;
import emploi.com.tn.service.IEspDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspDeptImplementation implements IEspDeptService {

    @Autowired
    private IEspDeptDAO espDeptRepository;

    @Override
    public ESP_Dept getEspDept(int id) {
      return  espDeptRepository.findById(id).get();
    }

    @Override
    public List<ESP_Dept> getEspDepts() {

        return espDeptRepository.findAll();
    }
}
