package com.desafiospring.controller;

import com.desafiospring.dto.ErrorDTO;
import com.desafiospring.dto.ProductDTO;
import com.desafiospring.dto.PurchaseRequestDTO;
import com.desafiospring.dto.PurchaseResponseDTO;
import com.desafiospring.exceptions.InvalidParametersException;
import com.desafiospring.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping(value = "/api/v1")
public class ArticlesController {

    @Autowired
    private ArticlesService articlesService;

    @ResponseBody
    @GetMapping("/articles")
    public ResponseEntity<List<ProductDTO>> getProducts(@RequestParam HashMap<String,String> requestParams) throws Exception {
        return new ResponseEntity<>(articlesService.getProducts(requestParams),HttpStatus.OK);
    }

   @PostMapping("/purchase-request")
    public ResponseEntity<PurchaseResponseDTO> purchaseProducts(@RequestBody PurchaseRequestDTO payload){
        return new ResponseEntity<>(articlesService.purchaseProducts(payload), HttpStatus.OK);
    }

    @ExceptionHandler(value={InvalidParametersException.class})
    public ResponseEntity<ErrorDTO> invalidParameterException(InvalidParametersException e){
        ErrorDTO errorDTO = new ErrorDTO("error", e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

}
