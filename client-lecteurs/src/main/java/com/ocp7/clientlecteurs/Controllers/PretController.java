package com.ocp7.clientlecteurs.Controllers;

import com.ocp7.clientlecteurs.beans.PretBean;
import com.ocp7.clientlecteurs.proxies.PretMicroserviceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PretController {
    @Autowired
    PretMicroserviceProxy pretMicroserviceProxy;

    @RequestMapping(value="userprets",method = RequestMethod.GET)
    public String userPrets(HttpSession session, HttpServletRequest request, Model model){
        String utilisateur= (String) request.getSession().getAttribute("user");
        List<PretBean> userPrets=pretMicroserviceProxy.userPrets(utilisateur);
        model.addAttribute("userPrets",userPrets);
        return "user-prets";
    }
}
