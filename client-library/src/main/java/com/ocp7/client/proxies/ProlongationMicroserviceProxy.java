package com.ocp7.client.proxies;

import com.ocp7.client.beans.ProlongationBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "microservice-prets", url = "localhost:9092")

public interface ProlongationMicroserviceProxy {
    @GetMapping(value="prolongationsList")
    List<ProlongationBean> prolongationsList();

    @GetMapping(value="pret/{pretId}/prolongation/updateProlongation")
    ProlongationBean getProlongation(@PathVariable("pretId") int pretId, @RequestParam("prolongationId") int prolongationId);

    @GetMapping(value = "pret/{pretId}/prolongation/saveFormProlo")
    void saveProlongation(@PathVariable("pretId") int pretId, ProlongationBean laProlongation);
}
