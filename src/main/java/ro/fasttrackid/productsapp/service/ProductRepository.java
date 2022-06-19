package ro.fasttrackid.productsapp.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.fasttrackid.productsapp.model.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p " +
            "where (:categoryId is null or p.categoryValue = :categoryId) " +
            "and (:maxPrice is null or p.price < :maxPrice) ")
    List<Product> findFiltered(Integer categoryId, Double maxPrice);
}
