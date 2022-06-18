package ro.fasttrackid.productsapp.service;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackid.productsapp.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
