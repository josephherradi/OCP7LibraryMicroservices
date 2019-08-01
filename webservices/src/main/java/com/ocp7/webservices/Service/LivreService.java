package com.ocp7.webservices.Service;

import com.ocp7.webservices.Modele.Livre;

import java.util.List;

public interface LivreService {
    public List<Livre> listeLivres();
    public  void saveLivre(Livre leLivre);
    public Livre get(int theId);
    public void delete(int theId);
    public List<Livre> listeLivresParCategorie(String categorie);




}
