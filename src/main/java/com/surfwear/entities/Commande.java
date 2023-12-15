package com.surfwear.entities;

import java.util.Date;

public class Commande {

    private String commandeId;
    private DetailCommande commande;
    private Date dateCommande;
    private String status;
    private double total;

    public Commande(String commandeId, DetailCommande commande, Date dateCommande, String status, double total) {
        this.commandeId = commandeId;
        this.commande = commande;
        this.dateCommande = dateCommande;
        this.status = status;
        this.total = total;
    }

    public String getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(String commandeId) {
        this.commandeId = commandeId;
    }

    public DetailCommande getCommande() {
        return commande;
    }

    public void setCommande(DetailCommande commande) {
        this.commande = commande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "commandeId='" + commandeId + '\'' +
                ", commande=" + commande +
                ", dateCommande=" + dateCommande +
                ", status='" + status + '\'' +
                ", total=" + total +
                '}';
    }
}
