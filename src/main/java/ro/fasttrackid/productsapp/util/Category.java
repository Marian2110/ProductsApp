package ro.fasttrackid.productsapp.util;

import lombok.Getter;
import ro.fasttrackid.productsapp.exception.custom.InvalidEnumValueException;
import ro.fasttrackid.productsapp.exception.custom.ResourceNotFoundException;

import java.util.stream.Stream;

@Getter
public enum Category {
    FOOD(1),
    DRINK(2),
    CLOTHES(3),
    ELECTRONICS(4),
    TOY(5),
    BOOK(6);

    private final int id;

    Category(int id) {

        this.id = id;
    }

    public static Category getCategoryById(int id) {
        return Stream.of(Category.values())
                .filter(category -> category.getId() == id)
                .findFirst()
                .orElseThrow(() -> ResourceNotFoundException.forEntity(Category.class, (long) id));
    }

    public static Category getCategoryByName(String name) {
        return Stream.of(Category.values())
                .filter(category -> category.name().equals(name))
                .findFirst()
                .orElseThrow(() -> InvalidEnumValueException.forValue(Category.class, name));
    }
}