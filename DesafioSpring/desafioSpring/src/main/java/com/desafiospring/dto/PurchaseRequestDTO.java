package com.desafiospring.dto;

import java.util.ArrayList;
import java.util.List;

public class PurchaseRequestDTO {

    private ArrayList<PurchaseProductDTO> articles;

    public PurchaseRequestDTO(ArrayList<PurchaseProductDTO> articles) {
        this.articles = articles;
    }
}
