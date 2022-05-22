package Files;
import io.restassured.response.Response;

import static Files.SpecBuilder.getRequestSpec;
import static Files.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class RestServiceResource {
    public static Response post(Object requestName, String endingUrl){
        return given(getRequestSpec()).
                body(requestName).
                when().post(endingUrl).
                then().spec(getResponseSpec()).
                extract().
                response();
    }
    public static Response get(String endingUrl){
        return given(getRequestSpec()).
                when().get(endingUrl).
                then().spec(getResponseSpec()).
                extract().
                response();
    }
    public static Response patch(Object requestName, String endingUrl){
        return given(getRequestSpec()).
                body(requestName).
                when().patch(endingUrl).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

}
