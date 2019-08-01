package com.ocp7.clientlecteurs.proxies;


import com.ocp7.clientlecteurs.beans.PretBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "microservice-prets", url = "localhost:9092")

public interface PretMicroserviceProxy {
    @GetMapping(value="userprets")
    List<PretBean> userPrets(@RequestParam("utilisateur") String utilisateur);

    @GetMapping(value = "getPret")
    public PretBean getPret(@RequestParam("pretId") int id);

}
