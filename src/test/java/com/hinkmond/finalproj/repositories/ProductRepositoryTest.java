package com.hinkmond.finalproj.repositories;

import com.hinkmond.finalproj.models.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testList() throws Exception {
        List<Product> products = repository.findAll();
        Assertions.assertTrue(products.size() > 0);
    }

    @Test
    @Transactional
    public void testSaveAndGetAndDelete() throws Exception {
        Product product = new Product();
        product.setProductName("Hanes Premium Men's X-Temp Ultra Cushion Crew Socks");
        product.setProductDescription("Pack of 6 pairs");
        product = repository.saveAndFlush(product);

        // clear the persistence context so we don't return the previously cached location object
        // this is a test only thing and normally doesn't need to be done in prod code
        entityManager.clear();

        Product otherProduct = repository.getOne(product.getProductId());
        Assertions.assertEquals("Hanes Premium Men's X-Temp Ultra Cushion Crew Socks", otherProduct.getProductName());

        repository.deleteById(otherProduct.getProductId());
    }
}
