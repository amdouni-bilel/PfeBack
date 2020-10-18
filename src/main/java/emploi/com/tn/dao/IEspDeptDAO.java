package emploi.com.tn.dao;

import emploi.com.tn.entities.ESP_Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface IEspDeptDAO extends JpaRepository<ESP_Dept, Integer> {

}
