package com.ocp7.clientlecteurs.Controllers;

import com.ocp7.clientlecteurs.beans.LivreBean;
import com.ocp7.clientlecteurs.proxies.LivreMicroserviceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller

public class LivreController {

    @Autowired
    LivreMicroserviceProxy livreMicroserviceProxy;

    @RequestMapping(value = "livres",method = RequestMethod.GET)
    public  String livresList(Model model){
        List<LivreBean> livresList=livreMicroserviceProxy.listLivres();
        model.addAttribute("livresList",livresList);
        return "list-livres";
    }
    @RequestMapping(value = "searchByCategorie",method = RequestMethod.GET)
    public  String searchLivres(@RequestParam(value="categorie",required = false) String categorie,Model model){
        List<LivreBean> livresperCategorie=livreMicroserviceProxy.searchLivres(categorie);
        model.addAttribute("livresList",livresperCategorie);
        return "list-livres";

    }
}
