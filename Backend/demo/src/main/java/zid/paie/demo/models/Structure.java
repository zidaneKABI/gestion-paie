package zid.paie.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Structure {

    @Id
    private Long idstructure;
    private String Libelle;
    private Structure structureparente;


}
