package com.ocp7.webservices.Controller;

import com.ocp7.webservices.Controller.exceptions.ImpossibleAjouterUtilisateurException;
import com.ocp7.webservices.Controller.exceptions.UtilisateurNotFoundException;
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
        if(lutilisateur==null) throw new UtilisateurNotFoundException("cet utilisateur n'existe pas");
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
        if(lutilisateur==null) throw new ImpossibleAjouterUtilisateurException("Erreur, impossible d'ajouter cet utilisateur");
        return new ResponseEntity<Utilisateur>(nouvelUtilisateur, HttpStatus.CREATED);

    }

    @RequestMapping(value = "utilisateurs", method = RequestMethod.GET)
    public List<Utilisateur> listUtilisateurs() {
        List<Utilisateur> listUsers=utilisateurService.listUtilisateurs();
        if(listUsers==null) throw new UtilisateurNotFoundException("Aucun utilisateur n'existe");
        return listUsers ;

    }
}


