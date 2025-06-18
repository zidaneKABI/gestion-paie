package zid.paie.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Rubrique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private Long id;
    
    private String  code;
    private String  libelle;
    private String  sens;
    private String  active;
    private String  typerubrique;
    private String  categorie;
    private Integer Ordre;


}
