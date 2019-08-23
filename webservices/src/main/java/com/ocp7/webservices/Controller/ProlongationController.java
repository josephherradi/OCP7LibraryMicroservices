package com.ocp7.webservices.Controller;

import com.ocp7.webservices.Modele.Pret;
import com.ocp7.webservices.Modele.Prolongation;
import com.ocp7.webservices.Service.PretService;
import com.ocp7.webservices.Service.ProlongationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
public class ProlongationController {
    @Autowired
    private ProlongationService prolongationService;

    @Autowired
    private PretService pretService;

    @RequestMapping(value="pret/{pretId}/prolongation/showFormProlo",method = RequestMethod.GET)
    public Prolongation showFormForAdd(@PathVariable("pretId") int pretId, Model model){
        Prolongation laProlongation= new Prolongation();

        return laProlongation;
    }

    @RequestMapping(value = "pret/{pretId}/prolongation/saveFormProlo",method =RequestMethod.POST)
    public ResponseEntity<Prolongation> saveProlongation(@PathVariable("pretId") int pretId, @RequestBody Prolongation laProlongation){
        Pret lePret=pretService.get(pretId);
        if(laProlongation.getStatut().equalsIgnoreCase("Validee")&&lePret.getPretProlonge().equals(Boolean.FALSE)){
            Calendar cal = Calendar.getInstance();
            cal.setTime(lePret.getDateRetour());
            cal.add(Calendar.WEEK_OF_MONTH,4);
            lePret.setDateRetour(cal.getTime());
            lePret.setPretProlonge(Boolean.TRUE);
            pretService.savePret(lePret);
        }

        Prolongation newProlongation=prolongationService.saveProlongation(pretId,laProlongation);
        return new ResponseEntity<Prolongation>(newProlongation, HttpStatus.CREATED);

    }

    @RequestMapping(value = "userprolongations",method = RequestMethod.GET)
    public List<Prolongation> userProlongations(String utilisateur){
    return prolongationService.userProlongation(utilisateur);
    }

    @RequestMapping(value="prolongationsList",method=RequestMethod.GET)
    public List<Prolongation> prolongationsList(){
        return prolongationService.ProlongationList();
    }

    @RequestMapping(value="pret/{pretId}/prolongation/updateProlongation",method=RequestMethod.GET)
    public Prolongation getProlongation(@PathVariable("pretId") int pretId,@RequestParam("prolongationId") int prolongationId) {
        return prolongationService.getProlongation(prolongationId);
    }
}
