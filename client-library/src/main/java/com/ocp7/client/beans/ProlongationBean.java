package com.ocp7.client.beans;

import java.util.Date;

public class ProlongationBean {

    private int prolongationId;

    private Date dateDemande;

    private String statut;

    private int pretId;

    private String nomLivre;

    private String utilisateur;

    public ProlongationBean() {
    }

    public int getProlongationId() {
        return prolongationId;
    }

    public void setProlongationId(int prolongationId) {
        this.prolongationId = prolongationId;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getPretId() {
        return pretId;
    }

    public void setPretId(int pretId) {
        this.pretId = pretId;
    }

    public String getNomLivre() {
        return nomLivre;
    }

    public void setNomLivre(String nomLivre) {
        this.nomLivre = nomLivre;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public String toString() {
        return "ProlongationBean{" +
                "prolongationId=" + prolongationId +
                ", dateDemande=" + dateDemande +
                ", statut='" + statut + '\'' +
                ", pretId=" + pretId +
                ", nomLivre='" + nomLivre + '\'' +
                ", utilisateur='" + utilisateur + '\'' +
                '}';
    }
}
