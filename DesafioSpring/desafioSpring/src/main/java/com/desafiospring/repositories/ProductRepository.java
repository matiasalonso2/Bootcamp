package com.desafiospring.repositories;

import com.desafiospring.dto.PurchaseProductDTO;

import java.util.HashMap;
import java.util.List;

public interface ProductRepository {

    public List<HashMap<String, String>> getProducts();

    public void updateDB(List<PurchaseProductDTO> articles);

}
