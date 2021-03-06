package ro.fasttrackid.productsapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
public class ProductDTO {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @NotBlank(message = "Description is mandatory")
    @Size(max = 255, message = "Description must be less than 255 characters")
    private String description;

    @NotBlank(message = "Category is mandatory")
    private String category;

    @NotBlank(message = "Price is mandatory")
    @Positive(message = "Price must be positive")
    private Double price;

}
