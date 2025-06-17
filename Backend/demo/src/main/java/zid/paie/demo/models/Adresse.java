package zid.paie.demo.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Adresse {
    
    @Id    
    private Long idadresse;
    private String adresse;

}
