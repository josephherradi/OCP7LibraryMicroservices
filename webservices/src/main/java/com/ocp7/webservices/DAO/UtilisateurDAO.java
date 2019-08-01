package com.ocp7.webservices.DAO;

import com.ocp7.webservices.Modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UtilisateurDAO  extends  JpaRepository<Utilisateur,Integer>{
    @Query("select u from Utilisateur u where u.identifiant= :userId")
    List<Utilisateur> findByIdentifiant(@Param("userId") String identifiant);
}