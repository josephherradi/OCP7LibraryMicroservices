package com.ocp7.client.proxies;

import com.ocp7.client.beans.PretBean;
import com.ocp7.client.beans.UtilisateurBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "microservice-prets", url = "localhost:9092")

public interface PretMicroserviceProxy {
    @GetMapping(value="prets")
    List<PretBean> listPrets();

    @GetMapping(value = "showFormPret")
    PretBean showFormForAdd();

    @PostMapping(value = "saveFormPret")
    void savePret(PretBean lePretBean);

    @GetMapping(value = "updateFormPret")
    PretBean get(@RequestParam("pretId") int theId);

    @GetMapping(value = "deletePret")
    void delete(@RequestParam("pretId") int theId);

    @GetMapping(value="utilisateurs")
    List<UtilisateurBean> listeUtilisateurs();
}
