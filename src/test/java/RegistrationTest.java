import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class RegistrationTest extends BaseTest {

    @DisplayName("Проверка успешной регистрации")
    @Test
    public void checkPassRegistrationTest(){
        entrance.clickPrivateOffice();
        entrance.clickRegisterButton();
        entrance.registrationNameInput(name);
        entrance.inputEmailPassword(email,password);
        entrance.clickRegistration();

        entrance.clickPrivateOffice();
        entrance.inputEmailPassword(email,password);
        entrance.clickCome();

        Assert.assertTrue(entrance.checkLogin());
        //Удаление перенесено в класс BaseTest
    }

    @DisplayName("Проверка некоректного пароля при регистрации")
    @Test
    public void checkFailRegistrationTest(){
        password = "qwer";

        entrance.clickPrivateOffice();
        entrance.clickRegisterButton();

        entrance.registrationNameInput(name);
        entrance.inputEmailPassword(email,password);
        entrance.clickRegistration();

        Assert.assertTrue(entrance.issuedErrorRegistration());
    }
}