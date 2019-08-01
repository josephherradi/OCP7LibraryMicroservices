package com.ocp7.clientlecteurs.Controllers;

import com.ocp7.clientlecteurs.beans.PretBean;
import com.ocp7.clientlecteurs.beans.ProlongationBean;
import com.ocp7.clientlecteurs.beans.UtilisateurBean;
import com.ocp7.clientlecteurs.proxies.PretMicroserviceProxy;
import com.ocp7.clientlecteurs.proxies.ProlongationMicroserviceProxy;
import com.ocp7.clientlecteurs.proxies.UtilisateurMircroserviceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PretCtrlTest {
    @Autowired
    PretMicroserviceProxy pretMicroserviceProxy;


    @Autowired
    ProlongationMicroserviceProxy prolongationMicroserviceProxy;
    @Autowired
    UtilisateurMircroserviceProxy utilisateurMircroserviceProxy;


    @RequestMapping(value = "getPret",method = RequestMethod.GET)
    public PretBean get(@RequestParam("pretId") int pretId){
        return pretMicroserviceProxy.getPret(pretId);

    }

    @RequestMapping(value = "userprolongationsTest",method =RequestMethod.GET)
    public List<ProlongationBean> userProlo(@RequestParam("utilisateur") String utilisateur){
       return prolongationMicroserviceProxy.userProlongations(utilisateur);
    }

    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    public UtilisateurBean getUserbyIdentifiant(@RequestParam("identifiant") String identifiant) {
        return utilisateurMircroserviceProxy.getUserbyIdentifiant(identifiant);
    }
}
