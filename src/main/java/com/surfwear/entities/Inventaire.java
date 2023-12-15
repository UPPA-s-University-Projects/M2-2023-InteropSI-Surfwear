package com.surfwear.entities;

public class Inventaire {
    private Article article;
    private int qteStock;
    private int qteReserve;

    public Inventaire(Article article, int qteStock, int qteReserve) {
        this.article = article;
        this.qteStock = qteStock;
        this.qteReserve = qteReserve;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getQteStock() {
        return qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

    public int getQteReserve() {
        return qteReserve;
    }

    public void setQteReserve(int qteReserve) {
        this.qteReserve = qteReserve;
    }

    @Override
    public String toString() {
        return "Inventaire{" +
                "article=" + article +
                ", qteStock=" + qteStock +
                ", qteReserve=" + qteReserve +
                '}';
    }
}
