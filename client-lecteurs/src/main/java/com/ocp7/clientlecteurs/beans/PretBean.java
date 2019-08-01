package com.ocp7.clientlecteurs.beans;


import java.util.Date;

public class PretBean {

    private int id;

    private Integer idLivre;
    private String nomLivre;
    private Date datePret;
    private Date dateRetour;
    private Boolean pretProlonge;

    private String utilisateur;
    private Boolean retardPret;
    private Boolean tagForUpdate;


    public PretBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(Integer idLivre) {
        this.idLivre = idLivre;
    }

    public Date getDatePret() {
        return datePret;
    }

    public void setDatePret(Date datePret) {
        this.datePret = datePret;
    }

    public Boolean getPretProlonge() {
        return pretProlonge;
    }

    public void setPretProlonge(Boolean pretProlonge) {
        this.pretProlonge = pretProlonge;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getNomLivre() {
        return nomLivre;
    }

    public void setNomLivre(String nomLivre) {
        this.nomLivre = nomLivre;
    }

    public Boolean getRetardPret() {
        return retardPret;
    }

    public void setRetardPret(Boolean retardPret) {
        this.retardPret = retardPret;
    }

    public Boolean getTagForUpdate() {
        return tagForUpdate;
    }

    public void setTagForUpdate(Boolean tagForUpdate) {
        this.tagForUpdate = tagForUpdate;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    @Override
    public String toString() {
        return "PretBean{" +
                "id=" + id +
                ", idLivre=" + idLivre +
                ", nomLivre='" + nomLivre + '\'' +
                ", datePret=" + datePret +
                ", dateRetour=" + dateRetour +
                ", pretProlonge=" + pretProlonge +
                ", utilisateur='" + utilisateur + '\'' +
                ", retardPret=" + retardPret +
                ", tagForUpdate=" + tagForUpdate +
                '}';
    }
}

