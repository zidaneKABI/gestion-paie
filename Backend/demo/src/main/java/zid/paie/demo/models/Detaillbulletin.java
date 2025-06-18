package zid.paie.demo.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Detaillbulletin {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rubriqueId", nullable = false)
    private Rubrique rubrique; // ex : "Salaire de base", "CNSS", "IRG"
    
    private Double taux;
    private Double base;
    private Double montantdonner;
    private Double montantretenir;
    
    @ManyToOne
    @JoinColumn(name = "bulletin_paie_id",nullable = false)
    private BulletinPaie bulletinPaie;



}
