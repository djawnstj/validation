package hello.itemservice.validation;

import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

import static org.assertj.core.api.Assertions.*;

public class MessageCodesResolverTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    public void messageCodesResolverObject() {
        // given
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");

        // when

        //then
        assertThat(messageCodes).containsExactly("required.item", "required");
    }

    @Test
    public void messageCodesResolverField() {
        // given
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);
        for (String messageCode : messageCodes) {
            System.out.println("messageCode = " + messageCode);
        }

        // when

        //then
        assertThat(messageCodes).containsExactly(
                "required.item.itemName",
                        "required.itemName",
                        "required.java.lang.String",
                        "required");

    }

}
