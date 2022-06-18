package ro.fasttrackid.productsapp.exception.custom;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Builder
public class InvalidEnumValueException extends RuntimeException {
    private final String enumClassName;
    private final String enumValue;

    public InvalidEnumValueException(String enumClassName, String enumValue) {
        super(enumClassName + " with value " + enumValue + " not found");
        this.enumClassName = enumClassName;
        this.enumValue = enumValue;
    }

    public static <T> InvalidEnumValueException forValue(Class<T> enumClass, String name) {
        String enumClassName = enumClass.getSimpleName();
        return createException(enumClassName, name);
    }

    private static InvalidEnumValueException createException(String enumClassName, String name) {
        InvalidEnumValueException invalidEnumValue = InvalidEnumValueException.builder()
                .enumClassName(enumClassName)
                .enumValue(name)
                .build();
        log.error("Could not find " + enumClassName + " with value " + name, invalidEnumValue);
        return invalidEnumValue;
    }
}
