package ro.fasttrackid.productsapp.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ro.fasttrackid.productsapp.model.dto.ProductDTO;
import ro.fasttrackid.productsapp.model.entity.Product;
import ro.fasttrackid.productsapp.util.Category;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO toDTO(Product product);

    default Product toEntity(ProductDTO productDto) {
        if (productDto == null) {
            return null;
        } else {
            Product product = new Product();
            product.setId(productDto.getId());
            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product.setDescription(productDto.getDescription());
            if (productDto.getCategory() != null) {
                product.setCategory(Category.getCategoryByName(productDto.getCategory()));
            }

            return product;
        }
    }

    List<ProductDTO> toDTOs(List<Product> products);
    
    List<Product> toEntities(List<ProductDTO> productDtos);
}
