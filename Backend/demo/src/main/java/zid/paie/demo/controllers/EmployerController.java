package zid.paie.demo.controllers;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import zid.paie.demo.dto.EmployeDTO;
import zid.paie.demo.models.Employe;
import zid.paie.demo.services.EmployeService;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/employes")
public class EmployerController {


    private final EmployeService employeService;

    @PostMapping
    public ResponseEntity<Employe> createEmploye(@RequestBody @Valid EmployeDTO employeDTO) {

    Employe employe = employeService.createEmploye(employeDTO);

    return ResponseEntity.status(HttpStatus.CREATED).body(employe);

    }
    
    @GetMapping
    public List<EmployeDTO> getEmployes() 
    {
        System.out.println("Je suis la");
        return employeService.liteEmployes().stream().map(this::mapToDTO).collect(Collectors.toList());

    }


        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteEmploye(@PathVariable Long id) {

              boolean delete = employeService.deleteEmploye(id);

              if(delete)
              return  ResponseEntity.noContent().build();
              else
              return  ResponseEntity.notFound().build();
           

        }
    
    

        @PutMapping()
        public ResponseEntity<EmployeDTO> modifierEmploye(@RequestBody Employe e) {
            
            Optional<Employe> employe = employeService.getEmploye(e.getIdemployer());

            if(employe.isPresent())
            {
                employeService.modiferEmploye(e);
                EmployeDTO dto = mapToDTO(employe.get());
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
            }
            else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
    
    

        @GetMapping("/matricule/{nom}")
        public ResponseEntity<String> getMatricule(@PathVariable String nom)
        {
            
            String mat ="";
            
            int i = 0;
            // Régéneration du matricule tant qu'il existe dans la base de données 
            // Pas plus de 1000 tentative pour éviter une boucle infinie.
            do 
            {
                mat = employeService.getMatricule(nom);
                i++;
            } while (employeService.ifEmployeExistBymatricule(mat) && i< 1000);


            return ResponseEntity.ok(mat);
        }

    
    
    @GetMapping("/{id}")
    public ResponseEntity<EmployeDTO> getEmploye(@PathVariable Long id) {
        
        Optional<Employe> employe = employeService.getEmploye(id);

        if (employe.isPresent()) {
            EmployeDTO dto = mapToDTO(employe.get());
            return ResponseEntity.ok(dto);
        }
        else
        return ResponseEntity.notFound().build();
    }
    
    private EmployeDTO mapToDTO(Employe e) {
        EmployeDTO dto = new EmployeDTO();
    dto.setId(e.getIdemployer());
    dto.setStructureId(e.getStructure().getIdstructure());
    dto.setPostetravailId(e.getPostetravail().getId()); // si tu en as un
    dto.setNom(e.getNom());
    dto.setPrenom(e.getPrenom());
    dto.setDatenaissance(e.getDatenaissance());
    dto.setAdresse_1(e.getAdresse_1());
    dto.setSexe(e.getSexe());
    dto.setDaterecrutement(e.getDaterecrutement());
    dto.setNss(e.getNss());
    
   // dto.setStituationfamille(e.getStituationfamille());
   // dto.setCodeirg(e.getCodeirg());
   // dto.setCodepaie(e.getCodepaie());
    dto.setPathphoto(e.getPathphoto());
    dto.setMatricule(e.getMatricule());
    dto.setTelephone(e.getTelephone());
   // dto.setDistance(e.getDistance());
   // dto.setCoderecrutement(e.getCoderecrutement());
   return dto;
    
   }

}
