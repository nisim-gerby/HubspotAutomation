package Utilities;

import Files.Data;
import lombok.Getter;
import lombok.Setter;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.testng.Assert.assertEquals;

@Getter
@Setter
public class GenericFunctions {
    public static void assertionAllItems(Data request, Data response) {
        assertAll(
                () -> assertEquals(request.getProperties().getFirstname(), response.getProperties().getFirstname()),
                () -> assertEquals( request.getProperties().getLastname(), response.getProperties().getLastname()),
                () -> assertEquals( request.getProperties().getWebsite(), response.getProperties().getWebsite()),
                () -> assertEquals( request.getProperties().getEmail(), response.getProperties().getEmail()),
                () -> assertEquals( request.getProperties().getCompany(), response.getProperties().getCompany())
        );
    }
}
