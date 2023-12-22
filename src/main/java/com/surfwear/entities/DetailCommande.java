package com.surfwear.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // Lombok annotation for no-argument constructor
@Entity
public class DetailCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detailCommandeId;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    private int qte;

    @Column(precision = 10, scale = 2)
    private double prixUnitaire;

    /**
     * @param detailCommandeId int id du detail de la commande
     * @param article          Article article du detail de la commande
     * @param qte              int quantite du detail de la commande
     * @param prixUnitaire     double prix unitaire du detail de la commande
     */
    public DetailCommande(int detailCommandeId, Article article, int qte, double prixUnitaire) {
        this.detailCommandeId = detailCommandeId;
        this.article = article;
        this.qte = qte;
        this.prixUnitaire = prixUnitaire;
    }

    /**
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetailCommande that)) return false;

        if (getDetailCommandeId() != that.getDetailCommandeId()) return false;
        if (getQte() != that.getQte()) return false;
        if (Double.compare(getPrixUnitaire(), that.getPrixUnitaire()) != 0) return false;
        return getArticle().equals(that.getArticle());
    }

    /**
     * @return int
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getDetailCommandeId();
        result = 31 * result + getArticle().hashCode();
        result = 31 * result + getQte();
        temp = Double.doubleToLongBits(getPrixUnitaire());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "DetailCommande{" +
                "detailCommandeId=" + detailCommandeId +
                ", article=" + article +
                ", qte=" + qte +
                ", prixUnitaire=" + prixUnitaire +
                '}';
    }
}
