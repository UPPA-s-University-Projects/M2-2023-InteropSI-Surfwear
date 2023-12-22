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
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paiementId;

    @OneToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;

    private double montant;
    private String methode;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datePaiement;

    /**
     * @param PaiementId   int id du paiement
     * @param commande     Commande commande du paiement
     * @param montant      double montant du paiement
     * @param methode      String methode du paiement
     * @param datePaiement Date date du paiement
     */
    public Paiement(int PaiementId, Commande commande, double montant, String methode, Date datePaiement) {
        this.paiementId = PaiementId;
        this.commande = commande;
        this.montant = montant;
        this.methode = methode;
        this.datePaiement = datePaiement;
    }

    public Paiement(Commande commande) {
        this.commande = commande;
    }

    /**
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paiement paiement)) return false;

        if (getPaiementId() != paiement.getPaiementId()) return false;
        if (Double.compare(paiement.getMontant(), getMontant()) != 0) return false;
        if (!getCommande().equals(paiement.getCommande())) return false;
        if (!getMethode().equals(paiement.getMethode())) return false;
        return getDatePaiement().equals(paiement.getDatePaiement());
    }

    /**
     * @return int
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getPaiementId();
        result = 31 * result + getCommande().hashCode();
        temp = Double.doubleToLongBits(getMontant());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getMethode().hashCode();
        result = 31 * result + getDatePaiement().hashCode();
        return result;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Paiement{" +
                "PaiementId=" + paiementId +
                ", commande=" + commande +
                ", montant=" + montant +
                ", methode='" + methode + '\'' +
                ", datePaiement=" + datePaiement +
                '}';
    }
}
