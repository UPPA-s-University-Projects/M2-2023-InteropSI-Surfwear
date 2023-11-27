package com.surfwear.graphql.entities;
import java.util.Date;
import java.util.List;
public class Paiment {
    private int paimentId;
    private int CommandeId;
    private double montant;
    private String methode;
    private Date datePaiment;

    public Paiment(int paimentId, int commandeId, double montant, String methode, Date datePaiment) {
        this.paimentId = paimentId;
        CommandeId = commandeId;
        this.montant = montant;
        this.methode = methode;
        this.datePaiment = datePaiment;
    }

    public int getPaimentId() {
        return paimentId;
    }

    public void setPaimentId(int paimentId) {
        this.paimentId = paimentId;
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

    public Date getDatePaiment() {
        return datePaiment;
    }

    public void setDatePaiment(Date datePaiment) {
        this.datePaiment = datePaiment;
    }

    @Override
    public String toString() {
        return "Paiment{" +
                "paimentId=" + paimentId +
                ", CommandeId=" + CommandeId +
                ", montant=" + montant +
                ", methode='" + methode + '\'' +
                ", datePaiment=" + datePaiment +
                '}';
    }
}
