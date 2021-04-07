package com.desafiospring.service;

import com.desafiospring.dto.ProductDTO;
import com.desafiospring.dto.PurchaseRequestDTO;
import com.desafiospring.dto.PurchaseResponseDTO;
import com.desafiospring.exceptions.InvalidParametersException;
import com.desafiospring.repositories.ProductRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArticlesServiceImp implements ArticlesService {

    @Autowired
    private ProductRepositoryImp repository;

    @Override
    public List<ProductDTO>  getProducts(HashMap<String,String> requestParams) throws InvalidParametersException {
        if (!validateParameters(requestParams))
            throw new InvalidParametersException();
        List<ProductDTO> output = filter(repository.getProducts(), requestParams);

        if (requestParams.containsKey("order")) {
            order(output, requestParams.get("order"));
        }
        return output;
    }

    @Override
    public PurchaseResponseDTO purchaseRequest(PurchaseRequestDTO payload) {

    }


    private boolean validateParameters (Map<String,String> requestParams){
        if (requestParams.size()>3)
            return false;
        if (requestParams.size()==3 && !requestParams.containsKey("order"))
            return false;
        if (requestParams.containsKey("order") && Integer.parseInt(requestParams.get("order"))>3)
            return false;
        for (Map.Entry<String, String> params : requestParams.entrySet()) {
            if (!params.getKey().equals("productId") &&
                    !params.getKey().equals("name") &&
                    !params.getKey().equals("category") &&
                    !params.getKey().equals("brand") &&
                    !params.getKey().equals("price") &&
                    !params.getKey().equals("freeShipping") &&
                    !params.getKey().equals("prestige") &&
                    !params.getKey().equals("order"))
                return false;
        }
        return true;
    }

    private List<ProductDTO> filter(List<HashMap<String, String>> data, HashMap<String,String> requestParams){
        List<ProductDTO> output = new ArrayList<>();
        for (Map<String, String> product: data){
            boolean pertenece=true;
            for (Map.Entry<String, String> entry : requestParams.entrySet()) {
                if (!entry.getKey().equals("order") && !entry.getValue().equalsIgnoreCase(product.get(entry.getKey())))
                    pertenece=false;
            }
            if(pertenece)
                output.add(new ProductDTO(product.get("productId"),
                        product.get("name"),
                        product.get("category"),
                        product.get("brand"),
                        product.get("price"),
                        product.get("quantity"),
                        product.get("freeShipping"),
                        product.get("prestige")));
        }
        return output;
    }

    private void order(List<ProductDTO> data, String o){

        if (o.equals("0"))
            data.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));

        if (o.equals("1"))
            data.sort((p1, p2) -> p2.getName().compareTo(p1.getName()));

        if (o.equals("2"))
            data.sort((p1, p2) -> (Integer.parseInt(p2.getPrice()) - Integer.parseInt(p1.getPrice())));

        if (o.equals("3"))
            data.sort((p1, p2) -> (Integer.parseInt(p1.getPrice()) - Integer.parseInt(p2.getPrice())));

    }
}
