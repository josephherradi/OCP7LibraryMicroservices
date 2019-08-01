package com.ocp7.clientlecteurs.Controllers;

import com.ocp7.clientlecteurs.beans.LivreBean;
import com.ocp7.clientlecteurs.beans.PretBean;
import com.ocp7.clientlecteurs.beans.UtilisateurBean;

import com.ocp7.clientlecteurs.proxies.LivreMicroserviceProxy;
import com.ocp7.clientlecteurs.proxies.PretMicroserviceProxy;
import com.ocp7.clientlecteurs.proxies.UtilisateurMircroserviceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

@Controller

public class UtilisateurController {
    @Autowired
    UtilisateurMircroserviceProxy utilisateurMircroserviceProxy;

    @Autowired
    PretMicroserviceProxy pretMicroserviceProxy;

    @Autowired
    LivreMicroserviceProxy livreMicroserviceProxy;

    public static String encrypt(String source) {
        String md5 = null;
        try {
            MessageDigest mdEnc = MessageDigest.getInstance("MD5");
            mdEnc.update(source.getBytes(), 0, source.length());
            md5 = new BigInteger(1, mdEnc.digest()).toString(16);
        } catch (Exception ex) {
            return null;
        }
        return md5;
    }
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "login-form";
    }



    @RequestMapping(value = "registrationForm", method = RequestMethod.GET)
    public String showFormForAdd(){
        UtilisateurBean lutilisateur=new UtilisateurBean();
        return "register-form";
    }



    @PostMapping(value = "saveFormUser")
    public void saveUser(@RequestBody UtilisateurBean lutilisateur){
        utilisateurMircroserviceProxy.saveUser(lutilisateur);
    }



    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String loginUser(@RequestParam("identifiant") String identifiant, @RequestParam("password") String password,
                            HttpSession session, ModelMap theModelMap) {
        UtilisateurBean registredUserId = utilisateurMircroserviceProxy.getUserbyIdentifiant(identifiant);
        try {
            String registredID = registredUserId.getIdentifiant();
            String registredPWD = registredUserId.getPassword();
            String encryptedPwd=encrypt(password);
            if (identifiant.equalsIgnoreCase(registredID) && encrypt(password).equalsIgnoreCase(registredPWD)) {
                session.setAttribute("user", identifiant);
                session.setAttribute("theUser", registredUserId);

                return "redirect:/userprets";

            } else {
                theModelMap.put("error", "Please check Id & password");
                return "login-form";

            }

        } catch (NullPointerException e) {
            theModelMap.put("error", "Please register account first");


        }
        return "login-form";

    }
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();

        return "redirect:/login";

    }



}

