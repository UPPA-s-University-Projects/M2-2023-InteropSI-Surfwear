package com.surfwear.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor // Lombok annotation for no-argument constructor
@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commandeId;

    @OneToOne // ou @ManyToOne selon votre modèle
    private DetailCommande detailCommande;

    @Temporal(TemporalType.DATE) // ou TemporalType.TIMESTAMP
    private Date dateCommande;

    private String status;
    private double total;

    /**
     * @param commandeId     int id de la commande
     * @param detailCommande DetailCommande detail de la commande
     * @param dateCommande   Date date de la commande
     * @param status         String status de la commande
     * @param total          double total de la commande
     */
    public Commande(int commandeId, DetailCommande detailCommande, Date dateCommande, String status, double total) {
        this.commandeId = commandeId;
        this.detailCommande = detailCommande;
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
        if (!getDetailCommande().equals(commande.getDetailCommande())) return false;
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
        result = 31 * result + getDetailCommande().hashCode();
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
                ", commande=" + detailCommande +
                ", dateCommande=" + dateCommande +
                ", status='" + status + '\'' +
                ", total=" + total +
                '}';
    }
}
