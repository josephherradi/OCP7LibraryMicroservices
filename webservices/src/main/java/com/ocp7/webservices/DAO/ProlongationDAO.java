package com.ocp7.webservices.DAO;

import com.ocp7.webservices.Modele.Prolongation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProlongationDAO extends JpaRepository <Prolongation,Integer>{

    @Query("select p from Prolongation p where p.utilisateur= :user")
   Optional <List <Prolongation>> findByUtilisateur(@Param("user") String utilisateur);

}
