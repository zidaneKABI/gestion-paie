package zid.paie.demo.services;

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

        public Employe createEmploye(EmployeDTO empoyedto) {
          
        Structure structure = structureRepository.getReferenceById(empoyedto.getStructureId());
        Postetravail postetravail = postTravailRepository.getReferenceById(empoyedto.getPostetravailId());
        
        Employe employe = new Employe();
        employe.setAdresse_1(empoyedto.getAdresse_1());
        employe.setCodeirg(empoyedto.getCodeirg());
        employe.setCodepaie(empoyedto.getCodepaie());
        employe.setCoderecrutement(empoyedto.getCoderecrutement());
        employe.setDistance(empoyedto.getDistance());
        employe.setMatricule(empoyedto.getMatricule());
        employe.setNom(empoyedto.getNom());
        employe.setNss(empoyedto.getNss());
        employe.setPathphoto(empoyedto.getPathphoto());
        employe.setPostetravail(postetravail);
        employe.setStructure(structure);

        return employeRepository.save(employe);
    }

}
