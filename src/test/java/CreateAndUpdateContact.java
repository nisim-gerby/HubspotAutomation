import Files.Data;
import Files.Properties;
import Files.RestServiceResource;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import java.util.Locale;

import static Utilities.GenericFunctions.assertionAllItems;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.testng.AssertJUnit.assertEquals;


@Getter
@Setter
public class CreateAndUpdateContact {
    String randomMail = RandomStringUtils.randomAlphabetic(5);

    @Test
    public void createNewContact() {
        Properties p = new Properties("Biglytics", randomMail.toLowerCase(Locale.ROOT) + "@gmail.com", "Adi", "Adi", "(877) 929-0687", "http://biglytics.net");
        Data data = new Data(p);
        Response response = RestServiceResource.post(data, Data.endPoint);
        assertAll(
                () -> assertEquals(response.statusCode(), 201),
                () -> assertionAllItems(data, response.as(Data.class))
        );

    }

    @Test
    public void updateAnExcitedContact() {
        Properties p = new Properties("Gigya", randomMail + "@gmail.com", "Nisim", "Gigya", "(877) 929-0687", "sap.com");
        Data data = new Data(p);

        Response getContacts = RestServiceResource.get(Data.endPoint);
        JsonPath js = getContacts.jsonPath();
        String contactId = js.get("results[0].id");

        Response responseUpdate = RestServiceResource.patch(data, Data.endPoint + "/" + contactId);
        JsonPath jp = responseUpdate.jsonPath();
        String responseContactId = jp.get("id");
        assertAll(
                () -> assertEquals(responseUpdate.statusCode(), 200),
                () -> assertionAllItems(data, responseUpdate.as(Data.class)),
                () -> assertEquals(responseContactId, contactId)
        );
    }
}


