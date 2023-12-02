package com.surfwear.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Commande {

    private int commandeId;
    private DetailCommande commande;
    private Date dateCommande;
    private String status;
    private double total;

    /**
     * @param commandeId int id de la commande
     * @param commande DetailCommande detail de la commande
     * @param dateCommande Date date de la commande
     * @param status String status de la commande
     * @param total double total de la commande
     */
    public Commande(int commandeId, DetailCommande commande, Date dateCommande, String status, double total) {
        this.commandeId = commandeId;
        this.commande = commande;
        this.dateCommande = dateCommande;
        this.status = status;
        this.total = total;
    }

    /**
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Commande commande)) return false;

        if (getCommandeId() != commande.getCommandeId()) return false;
        if (Double.compare(commande.getTotal(), getTotal()) != 0) return false;
        if (!getCommande().equals(commande.getCommande())) return false;
        if (!getDateCommande().equals(commande.getDateCommande())) return false;
        return getStatus().equals(commande.getStatus());
    }

    /**
     * @return int
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getCommandeId();
        result = 31 * result + getCommande().hashCode();
        result = 31 * result + getDateCommande().hashCode();
        result = 31 * result + getStatus().hashCode();
        temp = Double.doubleToLongBits(getTotal());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Commande{" +
                "commandeId=" + commandeId +
                ", commande=" + commande +
                ", dateCommande=" + dateCommande +
                ", status='" + status + '\'' +
                ", total=" + total +
                '}';
    }
}
