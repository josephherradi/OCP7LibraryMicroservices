package com.ocp7.webservices.DAO;

import com.ocp7.webservices.Modele.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivreDAO extends JpaRepository<Livre,Integer> {
    @Query("select l from Livre l where l.categorie= :livreCategorie")
    List<Livre> findByCategorie(@Param("livreCategorie") String categorie);


}
