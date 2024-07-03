import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class TransitionTest extends BaseTest {
    @DisplayName("Проверка перехода по клику на Личный кабинет")
    @Test
    public void checkTransitionPrivateOfficeTest() {
        users.getAccessToken(json, users);
        entrance.clickLoginMainPage();
        entrance.inputEmailPassword(email, password);
        entrance.clickCome();

        entrance.clickPrivateOffice();
        Assert.assertTrue(transitions.checkProfile());
    }

    @DisplayName("Проверь переход из Личного кабинета по клику на Конструктор")
    @Test
    public void checkTransitionConstructor() {
        users.getAccessToken(json, users);
        entrance.clickLoginMainPage();
        entrance.inputEmailPassword(email, password);
        entrance.clickCome();
        entrance.clickPrivateOffice();

        transitions.clickConstructor();

        Assert.assertTrue(entrance.checkLogin());
    }

    @DisplayName("Проверь переход из Личного кабинета по клику на логотип Stellar Burgers")
    @Test
    public void checkTransitionLogotypeText() {
        users.getAccessToken(json, users);
        entrance.clickLoginMainPage();
        entrance.inputEmailPassword(email, password);
        entrance.clickCome();
        entrance.clickPrivateOffice();

        entrance.clickLogotypeBurger();     //Клик по логотипу

        Assert.assertTrue(entrance.checkLogin());
    }

    @DisplayName("Проверка выхода по кнопке Выйти в личном кабинете")
    @Test
    public void checkExitTest() {
        users.getAccessToken(json, users);
        entrance.clickLoginMainPage();
        entrance.inputEmailPassword(email, password);
        entrance.clickCome();
        entrance.clickPrivateOffice();

        transitions.clickExit();

        Assert.assertTrue(entrance.checkExit());
    }

    @Test
    @DisplayName("Проверка переходок к разделам")
    public void checkIngredientMainPageTest() {
        Assert.assertEquals("Соусы", transitions.checkSauce());
        Assert.assertEquals("Булки", transitions.checkBun());
        Assert.assertEquals("Начинки", transitions.checkTopping());
    }

}
