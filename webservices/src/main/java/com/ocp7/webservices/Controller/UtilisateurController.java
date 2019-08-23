package com.ocp7.webservices.Controller;

import com.ocp7.webservices.Modele.Utilisateur;
import com.ocp7.webservices.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    public Utilisateur getUserbyIdentifiant(@RequestParam("identifiant") String identifiant) {
        Utilisateur lutilisateur = utilisateurService.getUser(identifiant);
        return lutilisateur;
    }


    @RequestMapping(value = "registrationForm", method = RequestMethod.GET)
    public Utilisateur showFormForAdd() {
        Utilisateur lutilisateur = new Utilisateur();
        return lutilisateur;
    }

    @PostMapping(value = "saveFormUser")
    public ResponseEntity<Utilisateur> saveUser(@RequestBody Utilisateur lutilisateur) {
        Utilisateur nouvelUtilisateur=utilisateurService.saveUser(lutilisateur);
        return new ResponseEntity<Utilisateur>(nouvelUtilisateur, HttpStatus.CREATED);

    }

    @RequestMapping(value = "utilisateurs", method = RequestMethod.GET)
    public List<Utilisateur> listUtilisateurs() {
        return utilisateurService.listUtilisateurs();

    }
}


