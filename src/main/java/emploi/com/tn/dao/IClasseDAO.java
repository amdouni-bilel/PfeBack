package emploi.com.tn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emploi.com.tn.entities.Classe;


public interface IClasseDAO extends JpaRepository<Classe, Integer>{

}
