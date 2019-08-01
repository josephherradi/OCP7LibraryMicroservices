package com.ocp7.webservices.Controller;

import com.ocp7.webservices.Modele.Prolongation;
import com.ocp7.webservices.Service.ProlongationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProlongationController {
    @Autowired
    private ProlongationService prolongationService;

    @RequestMapping(value="pret/{pretId}/prolongation/showFormProlo",method = RequestMethod.GET)
    public Prolongation showFormForAdd(@PathVariable("pretId") int pretId, Model model){
        Prolongation laProlongation= new Prolongation();

        return laProlongation;
    }

    @RequestMapping(value = "pret/{pretId}/prolongation/saveFormProlo",method =RequestMethod.POST)
    public void saveProlongation(@PathVariable("pretId") int pretId,@RequestBody Prolongation laProlongation){

    prolongationService.saveProlongation(pretId,laProlongation);
    }

    @RequestMapping(value = "userprolongations",method = RequestMethod.GET)
    public @ResponseBody List<Prolongation> userProlongations(String utilisateur){
    return prolongationService.userProlongation(utilisateur);
    }


}
