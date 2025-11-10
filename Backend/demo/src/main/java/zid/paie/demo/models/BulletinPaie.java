package zid.paie.demo.models;

import  java.time.LocalDate;
import  java.util.List;

import  jakarta.persistence.CascadeType;
import  jakarta.persistence.Entity;
import  jakarta.persistence.GeneratedValue;
import  jakarta.persistence.GenerationType;
import  jakarta.persistence.Id;
import  jakarta.persistence.JoinColumn;
import  jakarta.persistence.ManyToOne;
import  jakarta.persistence.OneToMany;
import  lombok.Data;

@Entity
@Data
public class BulletinPaie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateEdition;
    private Double salaireBrut;
    private Double salaireNet;
    
    
    
    @ManyToOne
    @JoinColumn(name = "employe_id")
    private Employe employe;
    
    @ManyToOne
    @JoinColumn(name = "lotpaieId", nullable = false)
    private LotPaie lotpaie;

    @OneToMany(mappedBy = "bulletinPaie", cascade = CascadeType.ALL )
    private List<Detaillbulletin> detaillbulletins;

}
