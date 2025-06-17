package zid.paie.demo.models;

import java.math.BigDecimal;
import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
public class Employe {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long idemployer;
     
     @NotNull(message = "La structure ne peux pas être null")
     
     @ManyToOne
     @JoinColumn(name="StructureId", nullable = false)
     private Structure structure;
     
     @NotBlank(message = "le nom ne peut pas être vide")
     private String nom;
     @NotBlank(message = "le nom ne peut pas être vide")
     private String    prenom;
     private Date      datenaissance;
     private String    adresse_1;
     private String    sexe;
     private String  codefilschahid;
     private Date    daterecrutement;
     private String  nss;
     private String stituationfamille;
     
     private String codeirg;
     
     @Positive(message = "le code paie doit être positif")
     @NotBlank(message = "le code paie doit être rensigné")
     private String  codepaie;
     private String  pathphoto;
     private String  matricule;
     private String  telephone;
     private String  ensurefectif;
     private byte[]  photo;
     private Double  distance;
     private String  coderecrutement;
     private String  gsp;
     private BigDecimal   aideetat;
     private String       activesdtc;

}
