package com.ocp7.webservices.Service;

import com.ocp7.webservices.Modele.Utilisateur;

import java.util.List;


public interface UtilisateurService {
    public Utilisateur getUser(String identifiant);
    public  Utilisateur saveUser(Utilisateur lutilisateur);
    public List<Utilisateur> listUtilisateurs();


}
