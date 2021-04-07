package com.desafiospring.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProductRepository {

    public List<HashMap<String, String>> getProducts();

}
