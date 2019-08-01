package com.ocp7.webservices.Modele;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="prolongation")
public class Prolongation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int prolongationId;

    @Column(name="dateDemande")
    private Date dateDemande;

    @Column(name="statut")
    private String statut;

    @Column(name="pret_id")
    private int pretId;

    @Column(name="nom_livre")
    private String nomLivre;

    @Column(name="utilisateur")
    private String utilisateur;


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

    public Prolongation() {
    }

    @Override
    public String toString() {
        return "Prolongation{" +
                "prolongationId=" + prolongationId +
                ", dateDemande=" + dateDemande +
                ", statut='" + statut + '\'' +
                ", pretId=" + pretId +
                ", nomLivre=" + nomLivre +
                ", utilisateur='" + utilisateur + '\'' +
                '}';
    }
}
