package zid.paie.demo.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class LotPaie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle; // ex : "Juin 2025"
    private LocalDate dateDebut;
    private LocalDate dateFin;

    @OneToMany(mappedBy = "lotPaie", cascade = CascadeType.ALL)
    private List<BulletinPaie> bulletins;
    
}
