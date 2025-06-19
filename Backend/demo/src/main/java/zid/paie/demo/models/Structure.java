package zid.paie.demo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Structure {

    @Id
    private Long idstructure;
    private String Libelle;
    
    
   
    @OneToMany(mappedBy = "structure", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Employe> employes;


}
