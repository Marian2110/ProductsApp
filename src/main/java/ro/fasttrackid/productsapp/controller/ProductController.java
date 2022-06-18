package ro.fasttrackid.productsapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackid.productsapp.model.dto.ProductDTO;
import ro.fasttrackid.productsapp.model.mapper.ProductMapper;
import ro.fasttrackid.productsapp.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
@Validated
public class ProductController {
    private final ProductService productService;

    private final ProductMapper productMapper;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productMapper.toDTOs(productService.getAllProducts());
    }

    @GetMapping(path = "{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return productMapper.toDTO(productService.getProduct(id));
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productMapper.toDTO(
                productService.addProduct(
                        productMapper.toEntity(productDTO)));
    }

    @PutMapping(path = "{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return productMapper.toDTO(
                productService.updateProduct(
                        id,
                        productMapper.toEntity(productDTO)));
    }

    @DeleteMapping(path = "{id}")
    public ProductDTO deleteProduct(@PathVariable Long id) {
        return productMapper.toDTO(
                productService.deleteProduct(id));
    }
}