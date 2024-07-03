import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class Config {
    public static final String URL_CONST = "https://stellarburgers.nomoreparties.site/";
    static final String USER_CREATE = "/api/auth/register";
    static final String USER_LOGIN = "/api/auth/login";
    static final String USER_DELETE = "/api/auth/user";

    public RequestSpecification RequestSpecification(String json){
        return given()
                .header("Content-type", "application/json")
                .baseUri(URL_CONST)
                .body(json);
    }
}
