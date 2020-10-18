package emploi.com.tn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import emploi.com.tn.entities.Salle;

public interface ISalleDAO extends JpaRepository<Salle, String>{

}
