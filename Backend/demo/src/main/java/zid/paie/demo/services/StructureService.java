package zid.paie.demo.services;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import zid.paie.demo.models.Structure;
import zid.paie.demo.repository.StructureRepository;

@Service
@RequiredArgsConstructor
public class StructureService {

    private  final StructureRepository structureRepository;
    
    public List<Structure> getListeStructure() {
    return structureRepository.findAll();
    }
    
    public  Optional<Structure> getStructure(Long idstructure)
    {
        return structureRepository.findById(idstructure);
    }
    
    public boolean deleteStructure(Long idstructure)
    {

        Optional<Structure> structure = structureRepository.findById(idstructure);

        if (structure.isPresent()) {
            structureRepository.delete(structure.get());
            return true;

        } else {
            return false;
        }

    }

    public Structure createStructure(Structure structure)
    {
        return structureRepository.save(structure);
    }
    
    public Structure  updateStructure(Structure structure)
    {
    
    return structureRepository.save(structure);

    }


}
