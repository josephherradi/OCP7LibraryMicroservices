package com.ocp7.clientlecteurs.beans;

public class UtilisateurBean {
    private int id;
    private String identifiant;
    private String mail;
    private String password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UtilisateurBean() {
    }


    @Override
    public String toString() {
        return "UtilisateurBean{" +
                "id=" + id +
                ", identifiant='" + identifiant + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
