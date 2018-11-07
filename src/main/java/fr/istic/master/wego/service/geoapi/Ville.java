package fr.istic.master.wego.service.geoapi;

import java.util.List;

public class Ville {
    private String nom;
    private List<String> codesPostaux;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<String> getCodesPostaux() {
        return codesPostaux;
    }

    public void setCodesPostaux(List<String> codesPostaux) {
        this.codesPostaux = codesPostaux;
    }

}