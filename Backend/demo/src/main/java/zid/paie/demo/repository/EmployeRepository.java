package zid.paie.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import zid.paie.demo.models.Employe;

public interface EmployeRepository  extends JpaRepository<Employe,Long>   {

    
    Optional<Employe> findByMatricule(String matricule);
   


}
