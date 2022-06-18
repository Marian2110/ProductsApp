package ro.fasttrackid.productsapp.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.fasttrackid.productsapp.exception.custom.ResourceNotFoundException;
import ro.fasttrackid.productsapp.model.entity.Product;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product addProduct(Product product) {
        log.debug("Adding product {}", product);
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        log.debug("Retrieving all products");
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        log.debug("Retrieving product {}", id);
        return productRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.forEntity(Product.class, id));
    }

    public Product updateProduct(long id, Product product) {
        log.debug("Updating product with id {}", id);
        return productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setName(product.getName());
                    existingProduct.setDescription(product.getDescription());

                    return productRepository.save(existingProduct);
                })
                .orElseThrow(() -> ResourceNotFoundException.forEntity(Product.class, id));
    }

    public Product deleteProduct(long id) {
        log.debug("Deleting product with id {}", id);
        return productRepository.findById(id)
                .map(existingProduct -> {
                    productRepository.delete(existingProduct);
                    return existingProduct;
                })
                .orElseThrow(() -> ResourceNotFoundException.forEntity(Product.class, id));
    }
}
