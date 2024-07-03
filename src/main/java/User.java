import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

public class User extends Config {
    @Step("Создание пользователя")
    public ValidatableResponse createUser(String json) {
        return RequestSpecification(json)
                .post(USER_CREATE)
                .then();
    }

    @Step("Логин пользователя")
    public ValidatableResponse login(String json) {
        return RequestSpecification(json)
                .post(USER_LOGIN)
                .then();
    }

    @Step("Удаление пользователя")
    public ValidatableResponse delete(String token,String json) {
        return RequestSpecification(json)
                .auth().oauth2(token)
                .delete(USER_DELETE)
                .then();
    }
    @Step("Получение токена")
    public String getAccessToken(String json, User users) {
        new User().createUser(json)
                .statusCode(200);
        return users.login(json)
                .extract().body().path("accessToken");
    }
}
