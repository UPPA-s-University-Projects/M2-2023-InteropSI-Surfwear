package com.uppa.surfwear.entities;

import java.util.Date;
public class Paiement {
    private int PaiementId;
    private int CommandeId;
    private double montant;
    private String methode;
    private Date datePaiement;

    public Paiement(int PaiementId, int commandeId, double montant, String methode, Date datePaiement) {
        this.PaiementId = PaiementId;
        CommandeId = commandeId;
        this.montant = montant;
        this.methode = methode;
        this.datePaiement = datePaiement;
    }

    public int getPaiementId() {
        return PaiementId;
    }

    public void setPaiementId(int PaiementId) {
        this.PaiementId = PaiementId;
    }

    public int getCommandeId() {
        return CommandeId;
    }

    public void setCommandeId(int commandeId) {
        CommandeId = commandeId;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getMethode() {
        return methode;
    }

    public void setMethode(String methode) {
        this.methode = methode;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    @Override
    public String toString() {
        return "Paiement{" +
                "PaiementId=" + PaiementId +
                ", CommandeId=" + CommandeId +
                ", montant=" + montant +
                ", methode='" + methode + '\'' +
                ", datePaiement=" + datePaiement +
                '}';
    }
}
