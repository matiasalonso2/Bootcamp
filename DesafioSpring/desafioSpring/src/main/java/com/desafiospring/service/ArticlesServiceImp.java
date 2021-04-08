package com.desafiospring.service;

import com.desafiospring.dto.*;
import com.desafiospring.exceptions.InvalidParametersException;
import com.desafiospring.exceptions.InvalidRequestException;
import com.desafiospring.exceptions.OutOfStockException;
import com.desafiospring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ArticlesServiceImp implements ArticlesService {

    @Autowired
    private ProductRepository repository;

    private final AtomicInteger idTicket= new AtomicInteger(1);

    /*
    Flujo listado de artículos y filtros, se validan los parámetros ingresados,
    se filtra de acuerdo a los mismos y se ordenan los artículos según corresponda
    (llamando a métodos privados)
     */
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


    /*
    Flujo solicitud de compra, se verifica que la solicitud sea correcta y que haya stock de los
    productos solicitados, si no se encuentra alguno de los artículos se retorna el código correspondiente.
    Una vez comprobado que haya stock de todos los artículos solicitados se actualiza la base de datos
    (Lista cargada en memoria) llamando al método correspondiente del repository;
     */
    @Override
    public PurchaseResponseDTO purchaseProducts(PurchaseRequestDTO payload) throws InvalidRequestException, OutOfStockException {
        var dbProducts = repository.getProducts();
        List<PurchaseProductDTO> listOfProducts = new ArrayList<>();

        double total = 0;

        for (PurchaseProductDTO article: payload.getArticles()) {
            if (article.getName() == null || article.getProductId() == null ||
                article.getBrand() == null || article.getQuantity() == null)
                throw new InvalidRequestException("Solicitud errónea, faltan parámetros");

            boolean foundArticle=false;
            for (Map<String, String> dbProduct: dbProducts){

                if (article.getName().equals(dbProduct.get("name")) &&
                        article.getBrand().equals(dbProduct.get("brand")) &&
                        article.getProductId().equals(dbProduct.get("productId"))) {

                    foundArticle=true;
                    listOfProducts.add(article);
                    int quantity = Integer.parseInt(article.getQuantity());

                    if(quantity>Integer.parseInt(dbProduct.get("quantity")))
                        throw new OutOfStockException("No hay stock de los productos solicitados");

                    double price = Double.parseDouble(dbProduct.get("price"));
                    total = total + quantity * price;
                }
            }
            if (!foundArticle) {
                StatusCodeDTO status = new StatusCodeDTO(204, "Articulo/s no encontrado/s");
                return new PurchaseResponseDTO(null,status);
            }
        }

        TicketDTO ticket = new TicketDTO(idTicket.getAndIncrement(), listOfProducts, total);
        StatusCodeDTO status = new StatusCodeDTO(200, "La solicitud de compra se completó con éxito");

        //Update BD
        repository.updateDB(payload.getArticles());

        return new PurchaseResponseDTO(ticket,status);
    }


    /*
    Validación de parámetros, se lanzan excepciones según corresponda
     */
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

    /*
    Se filtran los artículos comparando el HashMap de los parámetros con la lista de artículos (hashmaps)
     */
    private List<ProductDTO> filter(List<HashMap<String, String>> data, HashMap<String,String> requestParams){
        List<ProductDTO> output = new ArrayList<>();
        for (Map<String, String> product: data){
            boolean exists=true;
            for (Map.Entry<String, String> entry : requestParams.entrySet()) {
                if (!entry.getKey().equals("order") && !entry.getValue().equalsIgnoreCase(product.get(entry.getKey())))
                    exists=false;
            }
            if(exists)
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
