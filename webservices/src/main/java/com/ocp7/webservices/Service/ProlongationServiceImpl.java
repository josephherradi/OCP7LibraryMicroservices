package com.ocp7.webservices.Service;

import com.ocp7.webservices.DAO.PretDAO;
import com.ocp7.webservices.DAO.ProlongationDAO;
import com.ocp7.webservices.Modele.Pret;
import com.ocp7.webservices.Modele.Prolongation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Service
public class ProlongationServiceImpl implements ProlongationService {
    @Autowired
    private ProlongationDAO prolongationDAO;



    @Autowired
    private PretDAO pretDAO;

    @Override
    public List<Prolongation> ProlongationList() {
        return prolongationDAO.findAll();
    }

    @Override
    public Prolongation saveProlongation(Integer preId,Prolongation laProlongation) {

        Pret lePret=pretDAO.findById(preId).orElse(null);
        laProlongation.setPretId(preId);
        laProlongation.setNomLivre(pretDAO.findById(preId).orElse(null).getNomLivre());
        return prolongationDAO.save(laProlongation);
    }

    @Override
    public Prolongation getProlongation(int id) {
        return prolongationDAO.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        prolongationDAO.deleteById(id);

    }

    @Override
    public @ResponseBody List<Prolongation> userProlongation(String utilisateur) {
        return prolongationDAO.findByUtilisateur(utilisateur).orElse(null);
    }
}
