package br.org.fiergs.productservice.controllers;

import br.org.fiergs.productservice.entities.Product;
import br.org.fiergs.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping
    public List<Product> list() {
        return productService.findAll();
    }

    @GetMapping("/description/{description}")
    public List<Product> listByDescription(@PathVariable("description") String description) {
        return productService.findByDescription(description);
    }

    @GetMapping("/code/{code}")
    public Product findByCode(@PathVariable("code") String code) {
        return productService.findByCode(code);
    }

    @PostMapping
    public Product save(@RequestBody @Valid Product product) {
        return productService.save(product);
    }

    @PutMapping
    public Product update(@RequestBody @Valid Product product) {
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
