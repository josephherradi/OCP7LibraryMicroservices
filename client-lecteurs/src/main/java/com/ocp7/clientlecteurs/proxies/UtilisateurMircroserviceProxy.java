package com.ocp7.clientlecteurs.proxies;

import com.ocp7.clientlecteurs.beans.UtilisateurBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "microservice-prets", url = "localhost:9092")

public interface UtilisateurMircroserviceProxy {
    @GetMapping(value = "getUser")
    UtilisateurBean getUserbyIdentifiant(@RequestParam("identifiant") String identifiant);

    @GetMapping(value = "registrationForm")
    UtilisateurBean showFormForAdd();

    @PostMapping(value = "saveFormUser")
    public void saveUser(@RequestBody UtilisateurBean lutilisateurBean);

}
