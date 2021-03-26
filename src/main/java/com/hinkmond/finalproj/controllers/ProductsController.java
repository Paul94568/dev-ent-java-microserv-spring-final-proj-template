package com.hinkmond.finalproj.controllers;

import com.hinkmond.finalproj.models.Product;
import com.hinkmond.finalproj.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {

        List<Product> products = productRepository.findAll();

        if (products == null || products.isEmpty())
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<Product> getById(@PathVariable int id) {

        Product product = productRepository.findById(id).orElse(null);

        if (product == null)
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping
    @RequestMapping("name/{name}")
    public ResponseEntity<List<Product>> getByName(@PathVariable("name") String name) {

        List<Product> sessions = productRepository.findProductByProductNameContains(name);

        if (sessions == null || sessions.isEmpty())
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Product>>(sessions, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody final Product product) {

        Product newProduct = productRepository.saveAndFlush(product);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newProduct.getProductId())
                .toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable int id) {

        //TODO: Also need to check for children records before deleting

        Product currentProduct = productRepository.findById(id).orElse(null);

        if (currentProduct == null)
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

        productRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Product> update(@PathVariable int id, @Valid @RequestBody Product product) {

        //TODO: Add validation that all attributes are passed in; otherwise, return a 400 bad payload.
        //TODO: Add validation that no 3rd party modification took place; otherwise, return a 409 conflict.

        Product currentProduct = productRepository.findById(id).orElse(null);

        if (currentProduct == null)
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);

        BeanUtils.copyProperties(product, currentProduct, "sessionId");
        productRepository.saveAndFlush(currentProduct);

        return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
    }
}

