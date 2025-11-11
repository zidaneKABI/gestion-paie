package zid.paie.demo.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Employe {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long idemployer;
     
     @NotNull(message = "La structure ne peux pas être null")
     
     @ManyToOne
     @JoinColumn(name = "StructureId", nullable = false)
     @JsonBackReference
     private Structure structure;
      
     @ManyToOne  
     @JoinColumn(name = "PosttravailId", nullable = false)
     private Postetravail postetravail;

     @NotBlank(message = "le nom ne peut pas être vide")
     private String nom;
     @NotBlank(message = "le nom ne peut pas être vide")
     private String    prenom;
     private Date      datenaissance;
     private String    adresse;
     private String    sexe;
     
     private Date     daterecrutement;
     private String   nss;
     private String   stituationfamille;
     
     private String   codeirg;
     
     
     @NotBlank(message = "le code paie doit être rensigné")
     private String  codepaie;
     private String  pathphoto;
     private String  matricule;
     private String  telephone;
     
     private byte[]  photo;
     private Double  distance;
     private String  coderecrutement;
     
}
