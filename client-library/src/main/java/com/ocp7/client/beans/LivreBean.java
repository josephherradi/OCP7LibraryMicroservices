package com.ocp7.client.beans;


public class LivreBean {
    private int id;
    private String nom;
    private String description;
    private int disponibilite;
    private String categorie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public int getDisponibilite() {
        return disponibilite;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDisponibilite(int disponibilite) {
        this.disponibilite = disponibilite;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public LivreBean() {
    }

    @Override
    public String toString() {
        return "LivreBean{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", disponibilite=" + disponibilite +
                ", categorie='" + categorie + '\'' +
                '}';
    }
}
