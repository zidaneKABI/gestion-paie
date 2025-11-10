package zid.paie.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import zid.paie.demo.models.BulletinPaie;

public interface BulletinRepository extends JpaRepository<BulletinPaie, Long> {
    
    @EntityGraph(attributePaths = {"details", "employe"})
    List<BulletinPaie> findAll();

}
