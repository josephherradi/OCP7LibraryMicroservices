package com.ocp7.webservices.Service;

import com.ocp7.webservices.DAO.PretDAO;
import com.ocp7.webservices.Modele.Pret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PretServiceImpl implements PretService {
    @Autowired
    private PretDAO pretDAO;


    @Override
    public List<Pret> listePrets() {
        return pretDAO.findAll();
    }

    @Override
    public void savePret(Pret lePret) {
        pretDAO.save(lePret);

    }

    @Override
    public Pret get(int theId) {
        return pretDAO.findById(theId).orElse(null);
    }

    @Override
    public void delete(int theId) {
        pretDAO.deleteById(theId);

    }

    @Override
    public List<Pret> userPrets(String utilisateur) {
        return pretDAO.findByUtilisateur(utilisateur);
    }
}
