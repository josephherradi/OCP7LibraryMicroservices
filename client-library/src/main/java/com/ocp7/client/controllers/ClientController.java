package com.ocp7.client.controllers;

import com.ocp7.client.beans.PretBean;
import com.ocp7.client.beans.ProlongationBean;
import com.ocp7.client.beans.UtilisateurBean;
import com.ocp7.client.proxies.LivreMicroserviceProxy;
import com.ocp7.client.beans.LivreBean;
import com.ocp7.client.proxies.PretMicroserviceProxy;
import com.ocp7.client.proxies.ProlongationMicroserviceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    LivreMicroserviceProxy livreMicroserviceProxy;

    @Autowired
    PretMicroserviceProxy pretMicroserviceProxy;

    @Autowired
    ProlongationMicroserviceProxy prolongationMicroserviceProxy;


    @RequestMapping(value = "livres", method = RequestMethod.GET)
    public String listLivres(Model model) {

        List<LivreBean> livreBeans = livreMicroserviceProxy.listLivres();
        model.addAttribute("listLivres", livreBeans);
        return "list-livres";
    }

    @RequestMapping(value = "showFormLivre", method = RequestMethod.GET)
    public String showFormForAddLivre(Model model) {
        LivreBean leLivreBean = new LivreBean();
        List<String> categorieList = Arrays.asList("Sciences", "Gestion", "Litterature", "Magazine", "BD", "Roman");
        model.addAttribute("categorieList", categorieList);
        model.addAttribute("leLivreBean", leLivreBean);
        return "livre-form";
    }

    @RequestMapping(value = "saveFormLivre", method = RequestMethod.POST)
    public String saveLivre(@ModelAttribute("leLivreBean") LivreBean leLivreBean) {
        livreMicroserviceProxy.saveLivre(leLivreBean);
        return "redirect:/livres";

    }


    @GetMapping(value = "updateFormLivre")
    public String showFormForUpdateLivre(@RequestParam("livreId") int theId, Model theModel) {
        LivreBean leLivre = livreMicroserviceProxy.get(theId);
        List<String> categorieList = Arrays.asList("Sciences", "Gestion", "Litterature", "Magazine", "BD", "Roman");
        theModel.addAttribute("categorieList", categorieList);
        theModel.addAttribute("leLivreBean", leLivre);
        return "livre-form";
    }

    @RequestMapping(value = "deleteLivre", method = RequestMethod.GET)
    public String deleteLivre(@RequestParam("livreId") int theId) {

        livreMicroserviceProxy.delete(theId);
        return "redirect:/livres";
    }

    @RequestMapping(value = "prets", method = RequestMethod.GET)
    public String listPrets(Model model) {

        List<PretBean> pretsBeans = pretMicroserviceProxy.listPrets();
        model.addAttribute("listPrets", pretsBeans);
        return "list-prets";
    }

    @RequestMapping(value = "showFormPret", method = RequestMethod.GET)
    public String showFormForAddPret(@RequestParam("livreId") int theId, Model model) {
        LivreBean leLivreBean = livreMicroserviceProxy.get(theId);
        PretBean lePretBean = new PretBean();
        lePretBean.setTagForUpdate(Boolean.FALSE);
        lePretBean.setIdLivre(leLivreBean.getId());
        lePretBean.setNomLivre(leLivreBean.getNom());
        model.addAttribute("lePretBean", lePretBean);
        List<UtilisateurBean> listUtilisateurs = pretMicroserviceProxy.listeUtilisateurs();
        model.addAttribute("listUtilisateurs", listUtilisateurs);
        return "pret-form";
    }

    @RequestMapping(value = "saveFormPret", method = RequestMethod.POST)
    public String savePret(@ModelAttribute("lePretBean") PretBean lePretBean, BindingResult result) {
        pretMicroserviceProxy.savePret(lePretBean);
        return "redirect:/prets";

    }

    @GetMapping(value = "updateFormPret")
    public String showFormForUpdatePret(@RequestParam("pretId") int theId, Model theModel) {
        PretBean lePretBean = pretMicroserviceProxy.get(theId);
        List<UtilisateurBean> listUtilisateurs = pretMicroserviceProxy.listeUtilisateurs();
        theModel.addAttribute("listUtilisateurs", listUtilisateurs);
        theModel.addAttribute("lePretBean", lePretBean);
        return "pret-form";

    }

    @RequestMapping(value = "deletePret", method = RequestMethod.GET)
    public String deletePret(@RequestParam("pretId") int theId) {

        pretMicroserviceProxy.delete(theId);
        return "redirect:/prets";
    }

    @RequestMapping(value = "prolongationsList", method = RequestMethod.GET)
    public String prolongationsList(Model model) {
        List<ProlongationBean> prolongationsList = prolongationMicroserviceProxy.prolongationsList();
        model.addAttribute("prolongationsList", prolongationsList);
        return "list-prolongations";

    }

    @RequestMapping(value = "pret/{pretId}/prolongation/updateProlongation", method = RequestMethod.GET)
    public String getProlongation(@PathVariable("pretId") int pretId, @RequestParam("prolongationId") int prolongationId,Model model) {
        ProlongationBean laProlongation = prolongationMicroserviceProxy.getProlongation(pretId, prolongationId);
        model.addAttribute("laProlongation",laProlongation);
        return "prolongation-form";
    }

    @RequestMapping(value = "pret/{pretId}/prolongation/saveFormProlo",method =RequestMethod.POST)
    public String saveProlongation(@PathVariable("pretId") int pretId,@ModelAttribute("laProlongation")  ProlongationBean laProlongation,BindingResult result){
        prolongationMicroserviceProxy.saveProlongation(pretId,laProlongation);
        return "redirect:/prolongationsList";

    }



}
