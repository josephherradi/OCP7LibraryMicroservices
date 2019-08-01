package com.ocp7.webservices.Service;

import com.ocp7.webservices.DAO.UtilisateurDAO;
import com.ocp7.webservices.Modele.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    @Autowired
    private UtilisateurDAO utilisateurDAO;




    @Override
    public Utilisateur getUser(String identifiant) {
        Utilisateur theUser = new Utilisateur();
        List<Utilisateur> ResultList =utilisateurDAO.findByIdentifiant(identifiant);
        try {
            theUser = ResultList.get(0);
        } catch (IndexOutOfBoundsException e) {
        }
        return theUser;
    }

    @Override
    public void saveUser(Utilisateur lutilisateur) {
        utilisateurDAO.save(lutilisateur);

    }

    @Override
    public List<Utilisateur> listUtilisateurs() {
        return utilisateurDAO.findAll();

    }
}
