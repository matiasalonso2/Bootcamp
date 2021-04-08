package com.desafiospring.dto;

import java.util.List;

public class TicketDTO {

    private int id;
    private List<PurchaseProductDTO> articles;
    private double total;

    public TicketDTO(int id, List<PurchaseProductDTO> articles, double total) {
        this.id = id;
        this.articles = articles;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<PurchaseProductDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<PurchaseProductDTO> articles) {
        this.articles = articles;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
