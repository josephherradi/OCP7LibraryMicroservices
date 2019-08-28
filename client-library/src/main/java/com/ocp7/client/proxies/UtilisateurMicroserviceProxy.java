package com.ocp7.client.proxies;

import com.ocp7.client.beans.UtilisateurBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "microservice-prets", url = "localhost:9092")

public interface UtilisateurMicroserviceProxy {
@GetMapping(value ="registrationForm")
 UtilisateurBean showFormForAdd();

@GetMapping(value = "saveFormUser")
void saveUser(UtilisateurBean utilisateurBean);

@GetMapping(value = "utilisateurs")
List<UtilisateurBean> listUtilisateurs();


}
