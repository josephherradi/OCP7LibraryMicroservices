package com.ocp7.webservices.Service;

import com.ocp7.webservices.DAO.LivreDAO;
import com.ocp7.webservices.Modele.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreServiceImpl implements  LivreService {
    @Autowired
    private LivreDAO livreDAO;

    @Override
    public List<Livre> listeLivres() {
        return livreDAO.findAll();
    }

    @Override
    public Livre saveLivre(Livre leLivre) {
    return livreDAO.save(leLivre);
    }

    @Override
    public Livre get(int theId) {
        return livreDAO.findById(theId).orElse(null);
    }

    @Override
    public void delete(int theId) {
        livreDAO.deleteById(theId);

    }

    @Override
    public List<Livre> listeLivresParCategorie(String categorie) {
        return livreDAO.findByCategorie(categorie);
    }
}
