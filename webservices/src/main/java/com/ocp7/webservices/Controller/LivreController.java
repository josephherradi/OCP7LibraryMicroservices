package com.ocp7.webservices.Controller;


import com.ocp7.webservices.DAO.LivreDAO;
import com.ocp7.webservices.Modele.Livre;
import com.ocp7.webservices.Service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LivreController {
@Autowired
    private LivreService livreService;
    @RequestMapping(value="livres", method= RequestMethod.GET)
    public List<Livre> listeLivres() {

        return livreService.listeLivres();
    }

    @RequestMapping(value = "showFormLivre", method = RequestMethod.GET)
    public Livre showFormForAdd() {
        Livre leLivre=new Livre();
        return leLivre;
    }

    @PostMapping(value = "saveFormLivre")
    public  void saveLivre(@RequestBody Livre leLivre) {
        livreService.saveLivre(leLivre);
    }

    @GetMapping(value = "updateFormLivre")
    public Livre showFormForUpdate(@RequestParam("livreId") int livreId) {
        return livreService.get(livreId);
    }

    @RequestMapping(value = "deleteLivre", method = RequestMethod.GET)
    public void delete(@RequestParam("livreId") int theId) {
        livreService.delete(theId);
    }

    @RequestMapping(value ="searchByCategorie",method = RequestMethod.GET)
    public List<Livre> searchLivres(@RequestParam(value="categorie",required = false) String categorie){
        return livreService.listeLivresParCategorie(categorie);
    }
}
