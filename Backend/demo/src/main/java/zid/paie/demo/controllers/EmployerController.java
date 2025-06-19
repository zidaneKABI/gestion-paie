package zid.paie.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import zid.paie.demo.dto.EmployeDTO;
import zid.paie.demo.models.Employe;
import zid.paie.demo.services.EmployeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employes")
public class EmployerController {


    private final EmployeService employeService;

    @PostMapping
    public ResponseEntity<Employe> createEmploye(@RequestBody @Valid EmployeDTO employeDTO) {
        
        Employe employe = employeService.createEmploye(employeDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(employe);


    }

}
