package com.ocp7.clientlecteurs.proxies;

import com.ocp7.clientlecteurs.beans.PretBean;
import com.ocp7.clientlecteurs.beans.ProlongationBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "microservice-prets", url = "localhost:9092")

public interface ProlongationMicroserviceProxy {

    @GetMapping(value="pret/{pretId}/prolongation/showFormProlo")
    public ProlongationBean showFormForAdd(@RequestParam("pretId") int pretId);

    @PostMapping(value = "pret/{pretId}/prolongation/saveFormProlo")
    public void saveProlongation(@RequestParam("pretId") int pretId,ProlongationBean prolongationBean);

    @GetMapping(value = "userprolongations")
    public List<ProlongationBean> userProlongations(@RequestParam("utilisateur") String utilisateur);


}
