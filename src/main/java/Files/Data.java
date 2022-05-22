package Files;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Data {

    public static String hapikey = "431090c1-ce61-4cfe-9f77-bbc0d38712df";
    public static String contentType = "application/json";
    public static String endPoint = "/crm/v3/objects/contacts";

    Properties properties;

    public Data(Properties properties) {
        this.properties = properties;
    }
}
