package zid.paie.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import zid.paie.demo.models.Rubrique;

public interface RubriqueRepository extends JpaRepository<Rubrique, Long> {
    

}
