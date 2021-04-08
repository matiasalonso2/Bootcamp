package com.desafiospring.controller;

import com.desafiospring.dto.ErrorDTO;
import com.desafiospring.dto.ProductDTO;
import com.desafiospring.dto.PurchaseRequestDTO;
import com.desafiospring.dto.PurchaseResponseDTO;
import com.desafiospring.exceptions.InvalidParametersException;
import com.desafiospring.exceptions.InvalidRequestException;
import com.desafiospring.exceptions.OutOfStockException;
import com.desafiospring.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping(value = "/api/v1")
public class ArticlesController {

    @Autowired
    private ArticlesService articlesService;

    /*
    Listado y filtro de artículos
     */
    @ResponseBody
    @GetMapping("/articles")
    public ResponseEntity<List<ProductDTO>> getProducts(@RequestParam HashMap<String,String> requestParams) throws Exception {
        var response = articlesService.getProducts(requestParams);
        if (response.isEmpty())
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(response,HttpStatus.OK);
    }

    /*
    Solicitud de compra de productos
     */
   @PostMapping("/purchase-request")
    public ResponseEntity<PurchaseResponseDTO> purchaseProducts(@RequestBody PurchaseRequestDTO payload) throws OutOfStockException, InvalidRequestException {
       var response = articlesService.purchaseProducts(payload);
       if (response.getTicket() == null)
           return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
       else
           return new ResponseEntity<>(response,HttpStatus.OK);
    }


    //Excepciones

    @ExceptionHandler(value={IOException.class})
    public ResponseEntity<ErrorDTO> IOException(Exception e){
        ErrorDTO errorDTO = new ErrorDTO("Error", "Error de archivo");
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value={InvalidParametersException.class})
    public ResponseEntity<ErrorDTO> invalidParameterException(InvalidParametersException e){
        ErrorDTO errorDTO = new ErrorDTO("Error de parámetros", e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value={OutOfStockException.class})
    public ResponseEntity<ErrorDTO> OutOfStockException(OutOfStockException e){
        ErrorDTO errorDTO = new ErrorDTO("Error de stock", e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value={InvalidRequestException.class})
    public ResponseEntity<ErrorDTO> InvalidRequestException(InvalidRequestException e){
        ErrorDTO errorDTO = new ErrorDTO("Error de solicitud", e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

}
