package com.ocp7.clientlecteurs.Controllers;

import com.ocp7.clientlecteurs.beans.PretBean;
import com.ocp7.clientlecteurs.beans.ProlongationBean;
import com.ocp7.clientlecteurs.proxies.PretMicroserviceProxy;
import com.ocp7.clientlecteurs.proxies.ProlongationMicroserviceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class ProlongationController {
    @Autowired
    ProlongationMicroserviceProxy prolongationMicroserviceProxy;

    @Autowired
    PretMicroserviceProxy pretMicroserviceProxy;

    @RequestMapping(value="pret/{pretId}/prolongation/showFormProlo",method = RequestMethod.GET)
    public String showFormForAdd(@PathVariable("pretId") int pretId, Model model){
        ProlongationBean laProlongationBean=new ProlongationBean();
        model.addAttribute("laProlongationBean",laProlongationBean);
        return "prolongation-form";
    }

    @RequestMapping(value = "pret/{pretId}/prolongation/saveFormProlo",method = RequestMethod.POST)
    private String saveProlongation(@PathVariable("pretId") int pretId, @ModelAttribute ProlongationBean laProlongationBean, BindingResult result,HttpSession session, HttpServletRequest request){
       laProlongationBean.setDateDemande(new Date());
       laProlongationBean.setStatut("en attente");
        String utilisateur= (String) request.getSession().getAttribute("user");
        laProlongationBean.setUtilisateur(utilisateur);
        prolongationMicroserviceProxy.saveProlongation(pretId,laProlongationBean);
        return "redirect:/userprets";
    }

    @RequestMapping(value = "userprolongations",method = RequestMethod.GET)
    public String userPrologations(HttpSession session, HttpServletRequest request, Model model){
        String utilisateur= (String) request.getSession().getAttribute("user");
        List<ProlongationBean> userProlongations=prolongationMicroserviceProxy.userProlongations(utilisateur);
        model.addAttribute("userProlongations",userProlongations);
        return "user-prolongations";
    }
}
