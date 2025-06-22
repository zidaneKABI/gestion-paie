package zid.paie.demo.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeDTO {

    @NotNull
    private Long structureId;

    @NotNull
    private Long postetravailId;

    @NotBlank
    private String nom;

    @NotBlank
    private String prenom;

    private Date   datenaissance;
    private String adresse_1;
    private String sexe;
    private Date   daterecrutement;
    private String nss;
   
    private String pathphoto;
    private String matricule;
    private String telephone;
   
   
}
