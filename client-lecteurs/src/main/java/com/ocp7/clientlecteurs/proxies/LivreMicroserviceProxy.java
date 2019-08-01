package com.ocp7.clientlecteurs.proxies;

import com.ocp7.clientlecteurs.beans.LivreBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "microservice-prets", url = "localhost:9092")
public interface LivreMicroserviceProxy {

    @GetMapping(value="livres")
    List<LivreBean> listLivres();

    @GetMapping(value = "searchByCategorie")
    List<LivreBean> searchLivres(@RequestParam("categorie") String categorie);




}
