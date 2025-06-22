package zid.paie.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import zid.paie.demo.dto.EmployeDTO;
import zid.paie.demo.models.Employe;
import zid.paie.demo.models.Postetravail;
import zid.paie.demo.models.Structure;
import zid.paie.demo.repository.EmployeRepository;
import zid.paie.demo.repository.PostTravailRepository;
import zid.paie.demo.repository.StructureRepository;

@Service
@RequiredArgsConstructor
public class EmployeService {

        private final EmployeRepository employeRepository;
        private final StructureRepository structureRepository;
        private final PostTravailRepository postTravailRepository;

        
        
        
        public List<Employe> liteEmployes() {
            

            return employeRepository.findAll();

        }
        
        
        
        public Employe createEmploye(EmployeDTO employedto) {
          
            Structure structure = structureRepository.findById(employedto.getStructureId()).orElseThrow(
                    () -> new RuntimeException("La structure demandée n'existe pas"));
            

            Postetravail postetravail = postTravailRepository.findById(employedto.getPostetravailId()).orElseThrow(()-> new RuntimeException("Le poste de travail n'existe pas"));
        
        Employe employe = new Employe();
        employe.setAdresse_1(employedto.getAdresse_1());
        
        /**  employe.setCodeirg(employedto.getCodeirg());
        // employe.setCodepaie(employedto.getCodepaie());
        // employe.setCoderecrutement(employedto.getCoderecrutement());
        employe.setDistance(employedto.getDistance());
        */
        
        employe.setMatricule(employedto.getMatricule());
        employe.setNom(employedto.getNom());
        employe.setPrenom(employedto.getPrenom());
        employe.setNss(employedto.getNss());
        employe.setPathphoto(employedto.getPathphoto());
        employe.setPostetravail(postetravail);
        employe.setStructure(structure);
        employe.setSexe(employedto.getSexe());
        employe.setDaterecrutement(employedto.getDaterecrutement());
        employe.setDatenaissance(employedto.getDatenaissance());
        employe.setTelephone(employedto.getTelephone());
        //employe.setStituationfamille(employedto.getStituationfamille());

        System.out.println("------------------------------------ "+employedto.toString());
        return employeRepository.save(employe);
    }



    public Optional<Employe> getEmploye(Long id) {
        return this.employeRepository.findById(id);
    }



    public boolean deleteEmploye(Long id) {
        
        Optional<Employe> employe = employeRepository.findById(id);

        if(employe.isPresent())
        {
            employeRepository.deleteById(employe.get().getIdemployer());
            return true;

        }
        else
        return false;

        



}



public Employe modiferEmploye(Employe e) {
    // TODO Auto-generated method stub
    return this.employeRepository.save(e);

}


}
