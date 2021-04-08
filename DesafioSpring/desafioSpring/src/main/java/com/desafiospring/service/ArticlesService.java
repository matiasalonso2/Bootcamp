package com.desafiospring.service;

import com.desafiospring.dto.ProductDTO;
import com.desafiospring.dto.PurchaseRequestDTO;
import com.desafiospring.dto.PurchaseResponseDTO;
import com.desafiospring.exceptions.InvalidRequestException;
import com.desafiospring.exceptions.OutOfStockException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ArticlesService {

    public List<ProductDTO> getProducts(HashMap<String,String> requestParams) throws Exception;

    public PurchaseResponseDTO purchaseProducts(PurchaseRequestDTO payload) throws InvalidRequestException, OutOfStockException;
}
