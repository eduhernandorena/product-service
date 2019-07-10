package br.org.fiergs.productservice.services;

import br.org.fiergs.productservice.entities.Product;
import br.org.fiergs.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findByDescription(String description) {
        Optional<List<Product>> optAddressType = productRepository.findByDescriptionContainingIgnoreCase(description);
        return optAddressType.orElse(new ArrayList<>());
    }

    public Product findByCode(String code) {
        Optional<Product> optAddressType = productRepository.findByCode(code);
        return optAddressType.orElse(null);
    }

    public Product save(Product addressType) {
        Optional<Product> optAddressType = productRepository.findByDescriptionOrCode(addressType.getDescription(), addressType.getCode());
        if (optAddressType.isEmpty()) {
            return productRepository.save(addressType);
        } else {
            throw new RuntimeException("Produto já cadastrado!");
        }
    }

    public Product update(Product addressType) {
        Optional<Product> optAddressType = productRepository.findOneByDescriptionIgnoreCaseOrCodeAndIdNot(addressType.getDescription(), addressType.getCode(), addressType.getId());
        if (optAddressType.isEmpty()) {
            return productRepository.save(addressType);
        } else {
            throw new RuntimeException("Produto já cadastrado!");
        }
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
