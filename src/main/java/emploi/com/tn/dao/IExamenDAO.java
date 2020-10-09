package emploi.com.tn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emploi.com.tn.entities.Examen;



public interface IExamenDAO extends JpaRepository<Examen, Integer>{

}
