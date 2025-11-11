package zid.paie.demo.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeDTO {

    private Long id;
    @NotNull
    private Long structureId;

    @NotNull
    private Long postetravailId;

    @NotBlank
    private String nom;

    @NotBlank
    private String prenom;

    private Date   datenaissance;
    private String adresse;
    private String sexe;
    private Date   daterecrutement;
    private String nss;
   
    private String pathphoto;
    private String matricule;
    private String telephone;
    private String codepaie;
    private String codeirg;
    private String coderecrutement;
    private double distance;   
   
}
