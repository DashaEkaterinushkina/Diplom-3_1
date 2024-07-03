import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @DisplayName("Проверка входа с главной страницы")
    @Test
    public void checkAuthenticationMainPageTest(){
        users.createUser(json);
        entrance.clickLoginMainPage();
        entrance.inputEmailPassword(email,password);
        entrance.clickCome();

        Assert.assertTrue(entrance.checkLogin());
    }

    @DisplayName("Проверка входа через Личный кабинет")
    @Test
    public void checkAuthenticationTest(){
        users.createUser(json);
        entrance.clickPrivateOffice();
        entrance.inputEmailPassword(email,password);
        entrance.clickCome();

        Assert.assertTrue(entrance.checkLogin());
    }

    @DisplayName("Проверка входа через форму регистрации")
    @Test
    public void checkAuthenticationAfterRegister(){
        users.createUser(json);
        entrance.clickPrivateOffice();
        entrance.clickRegisterButton();
        entrance.clickLoginRegistrationPage();

        entrance.inputEmailPassword(email,password);
        entrance.clickCome();

        Assert.assertTrue(entrance.checkLogin());
    }

    @DisplayName("Проверка входа через кнопку в форме восстановления пароля")
    @Test
    public void checkAuthenticationRestorationPassword(){
        users.createUser(json);
        entrance.clickPrivateOffice();

        entrance.clickRestorationPassword();

        entrance.inputEmailPassword(email,password);
        entrance.clickCome();

        Assert.assertTrue(entrance.checkLogin());
    }
}