package hello.itemservice.domain.item;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BeanValidationTest {
    
    @Test
    public void beanValidation() {
        // given
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // when
        Item item = new Item();
        item.setItemName(" ");
        item.setPrice(0);
        item.setQuantity(10000);
        Set<ConstraintViolation<Item>> violations = validator.validate(item);

        //then
        for (ConstraintViolation<Item> violation : violations) {
            System.out.println("violation: " + violation);
            System.out.println("violation message: " + violation.getMessage());
        }
    }

}