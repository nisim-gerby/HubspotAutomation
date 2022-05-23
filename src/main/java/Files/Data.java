package Files;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Data {

    public static String hapikey = ""; // some api-key that you get from dev documentaion of HubSpot
    public static String contentType = "application/json";
    public static String endPoint = "/crm/v3/objects/contacts";

    Properties properties;

    public Data(Properties properties) {
        this.properties = properties;
    }
}
