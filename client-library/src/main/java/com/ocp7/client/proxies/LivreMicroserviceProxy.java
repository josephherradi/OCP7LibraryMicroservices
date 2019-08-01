package com.ocp7.client.proxies;

import com.ocp7.client.beans.LivreBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "microservice-prets", url = "localhost:9092")
public interface LivreMicroserviceProxy {

    @GetMapping(value="livres")
    List<LivreBean> listLivres();

    @GetMapping(value = "showFormLivre")
    LivreBean showFormForAdd();

    @PostMapping(value = "saveFormLivre")
    void saveLivre(LivreBean leLivreBean);

    @GetMapping(value = "updateFormLivre")
    LivreBean get(@RequestParam("livreId") int theId);

    @GetMapping(value = "deleteLivre")
    void delete(@RequestParam("livreId") int theId);



}
