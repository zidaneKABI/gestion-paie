package zid.paie.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import zid.paie.demo.models.Structure;
import zid.paie.demo.services.StructureService;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://frontend:4200")
@RequestMapping("/structures")
public class StructureController {

    private final StructureService structureService;

    @GetMapping()
    public List<Structure> getStructures(  )
    {
        return structureService.getListeStructure();
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Structure> getStructure(@PathVariable Long id)
    {
        Optional<Structure> structure = structureService.getStructure(id);

        if (structure.isPresent()) {
            return ResponseEntity.ok(structure.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
    
    @PostMapping
    public ResponseEntity<Structure> createStructure(@RequestBody @Valid Structure structure)
    {
        Structure s = structureService.createStructure(structure);

        if (s != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(s);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
    
    @PutMapping
    public ResponseEntity<Structure> updateStructure(@RequestBody  Structure structure)
    {
        Optional<Structure> s = structureService.getStructure(structure.getIdstructure());
        if(s.isPresent())
        {
            Structure structure2 = structureService.updateStructure(structure);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(structure2);
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

}
