package com.batch;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PretRowMapper implements RowMapper<Pret> {
    @Override
    public Pret mapRow(ResultSet resultSet, int i) throws SQLException {
       Pret pret=new Pret();
       pret.setId(resultSet.getInt("id"));
       pret.setIdLivre(resultSet.getInt("id_Livre"));
       pret.setNomLivre(resultSet.getString("nom_livre"));
       pret.setDatePret(resultSet.getDate("date_pret"));
       pret.setDateRetour(resultSet.getDate("date_retour"));
       pret.setPretProlonge(resultSet.getBoolean("pret_prolonge"));
       pret.setUtilisateur(resultSet.getString("utilisateur"));
       pret.setRetardPret(resultSet.getBoolean("retard_pret"));
       pret.setTagForUpdate(resultSet.getBoolean("tag_for_update"));

        return pret;
    }
}
