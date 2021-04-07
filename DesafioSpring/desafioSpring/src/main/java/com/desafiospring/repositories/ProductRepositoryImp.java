package com.desafiospring.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImp implements ProductRepository {
    private final List<HashMap<String, String>> database;

    public ProductRepositoryImp() {
        database = loadDataBase();

    }

    @Override
    public List<HashMap<String, String>> getProducts() {
        return database;
    }

    private List<HashMap<String, String>> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:dbProducts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<HashMap<String, String>> data = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            data = mapper.readValue(file, new TypeReference<>(){});

        } catch (IOException e) {
            e.printStackTrace();
        }
        normalize(data);
        return data;
    }

    private void normalize (List<HashMap<String, String>> data){
        for (Map<String, String> m: data) {
            m.put("prestige",String.valueOf(m.get("prestige").length()));
            String price = m.get("price").replace("$","").
                    replace(".","");
            m.put("price",price);

            if (m.get("freeShipping").equals("SI"))
                m.put("freeShipping", "true");
            else
                m.put("freeShipping", "false");
        }
    }
}
