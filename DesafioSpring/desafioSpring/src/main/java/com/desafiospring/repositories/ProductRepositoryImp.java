package com.desafiospring.repositories;

import com.desafiospring.dto.PurchaseProductDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImp implements ProductRepository {
    private final List<HashMap<String, String>> database;

    public ProductRepositoryImp() throws IOException {
        database = loadDataBase();

    }

    @Override
    public List<HashMap<String, String>> getProducts() {
        return database;
    }


    public void updateDB(List<PurchaseProductDTO> articles){
        for (PurchaseProductDTO product: articles) {
            for (Map<String, String> productDB: database)
                if (product.getProductId().equals(productDB.get("productId"))) {
                    int quantity = Integer.parseInt(productDB.get("quantity")) -
                                    Integer.parseInt(product.getQuantity());
                    productDB.put("quantity", String.valueOf(quantity));
                }
        }
    }
    /*
    Se carga la información del archivo .csv en una lista de HashMaps donde cada HashMap es un artículo
     */
    private List<HashMap<String, String>> loadDataBase() throws IOException {
        File file = null;
        List<HashMap<String, String>> database = new ArrayList<>();
        try {
            file = ResourceUtils.getFile("classpath:dbProducts.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            boolean firstline = true;
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null){
                if (!firstline) {

                    HashMap<String, String> article= new HashMap<>();
                    String[] data = line.split(cvsSplitBy);
                    article.put("productId",data[0]);
                    article.put("name", data[1]);
                    article.put("category", data[2]);
                    article.put("brand",data[3]);
                    article.put("price", data[4].replace("$","").replace(".",""));
                    article.put("quantity",data[5]);
                    article.put("freeShipping", String.valueOf(data[6].equals("SI")));
                    article.put("prestige", String.valueOf(data[7].length()));
                    database.add(article);
                }
                else firstline = false;
            }
          
        } catch (IOException e){
            throw new IOException("Error al leer el archivo");
        }
        finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    throw new IOException("Error al cerrar el archivo");
                }
            }
        }
        return database;
    }

}
