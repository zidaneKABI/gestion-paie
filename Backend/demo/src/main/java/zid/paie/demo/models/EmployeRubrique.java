package zid.paie.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class EmployeRubrique {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employe_id", nullable = false)
    private Employe employe;
    
    @ManyToOne
    @JoinColumn(name = "rubrique_id", nullable = false)
    private Rubrique rubrique;

    private Double taux;
    private Double base;
    private Double gain;
    private Double retenue;
    private String statut;
}
