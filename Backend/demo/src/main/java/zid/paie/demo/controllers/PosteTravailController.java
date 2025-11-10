package zid.paie.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import zid.paie.demo.models.Postetravail;
import zid.paie.demo.services.PosteTravailService;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins="http://frontend:4200")
@RequestMapping("/postetravails")
public class PosteTravailController {

    private final PosteTravailService posteTravailService;

    @GetMapping
    public List<Postetravail> getListePostetravail() {
        
        return posteTravailService.getListePostetravail();
        
    }

}
