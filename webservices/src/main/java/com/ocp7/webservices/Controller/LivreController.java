package com.ocp7.webservices.Controller;


import com.ocp7.webservices.Controller.exceptions.ImpossibleAJouterLivreException;
import com.ocp7.webservices.Controller.exceptions.LivreNotFoundException;
import com.ocp7.webservices.DAO.LivreDAO;
import com.ocp7.webservices.Modele.Livre;
import com.ocp7.webservices.Service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LivreController {
@Autowired
    private LivreService livreService;
    @RequestMapping(value="livres", method= RequestMethod.GET)
    public List<Livre> listeLivres() {

        List<Livre> listeLivres=livreService.listeLivres();

        if (listeLivres.isEmpty()) throw new LivreNotFoundException("Il n'existe aucun livre");

        return listeLivres;
    }

    @RequestMapping(value = "showFormLivre", method = RequestMethod.GET)
    public Livre showFormForAdd() {
        Livre leLivre=new Livre();
        return leLivre;
    }

    @PostMapping(value = "saveFormLivre")
    public ResponseEntity<Livre> saveLivre(@RequestBody Livre leLivre) {

        Livre nouveauLivre=livreService.saveLivre(leLivre);
        if(nouveauLivre==null) throw new ImpossibleAJouterLivreException("Impossible d'ajouter ce livre");
        return new ResponseEntity<Livre>(nouveauLivre, HttpStatus.CREATED);
    }

    @GetMapping(value = "updateFormLivre")
    public Livre showFormForUpdate(@RequestParam("livreId") int livreId) {
        Livre livre=livreService.get(livreId);
        if(livre==null) throw  new LivreNotFoundException("ce livre n'existe pas");

        return livre;
    }

    @RequestMapping(value = "deleteLivre", method = RequestMethod.GET)
    public void delete(@RequestParam("livreId") int theId) {
        livreService.delete(theId);
    }

    @RequestMapping(value ="searchByCategorie",method = RequestMethod.GET)
    public List<Livre> searchLivres(@RequestParam(value="categorie",required = false) String categorie){
        List<Livre> livresTrouves=livreService.listeLivresParCategorie(categorie);
        return livresTrouves;
    }
}
