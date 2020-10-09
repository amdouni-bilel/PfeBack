package emploi.com.tn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emploi.com.tn.entities.Etudiant;


public interface IEtudiantDAO extends JpaRepository<Etudiant, Integer>{

}
