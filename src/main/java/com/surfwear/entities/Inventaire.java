package com.surfwear.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // Lombok annotation for no-argument constructor
@Entity
public class Inventaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inventaireId;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    private int qteStock;
    private int qteReserve;

    /**
     * @param inventaireId int id de l'inventaire
     * @param article      Article article de l'inventaire
     * @param qteStock     int quantite en stock de l'inventaire
     * @param qteReserve   int quantite reservee de l'inventaire
     */
    public Inventaire(int inventaireId, Article article, int qteStock, int qteReserve) {
        this.inventaireId = inventaireId;
        this.article = article;
        this.qteStock = qteStock;
        this.qteReserve = qteReserve;
    }

    /**
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inventaire inventaire)) return false;

        if (getInventaireId() != inventaire.getInventaireId()) return false;
        if (getQteStock() != inventaire.getQteStock()) return false;
        if (getQteReserve() != inventaire.getQteReserve()) return false;
        return getArticle().equals(inventaire.getArticle());
    }

    /**
     * @return int
     */
    @Override
    public int hashCode() {
        int result = getInventaireId();
        result = 31 * result + getArticle().hashCode();
        result = 31 * result + getQteStock();
        result = 31 * result + getQteReserve();
        return result;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Inventaire{" +
                "inventaireId=" + inventaireId +
                ", article=" + article +
                ", qteStock=" + qteStock +
                ", qteReserve=" + qteReserve +
                '}';
    }
}
