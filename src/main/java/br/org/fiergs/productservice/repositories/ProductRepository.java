package br.org.fiergs.productservice.repositories;

import br.org.fiergs.productservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<List<Product>> findByDescriptionContainingIgnoreCase(String description);

    Optional<Product> findByCode(String code);

    Optional<Product> findByDescriptionOrCode(String description, String code);

    @Query("select o from Product o where (upper(description) = upper(?1) or code = ?2) and id <> ?3")
    Optional<Product> findOneByDescriptionIgnoreCaseOrCodeAndIdNot(String description, String code, Long id);

    void deleteById(Long id);
}
