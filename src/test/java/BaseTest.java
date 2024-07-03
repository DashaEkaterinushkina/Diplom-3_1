import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Random;

public class BaseTest {
    private WebDriver driver;
    String email;
    String password;
    String name;
    String json;
    User users = new User();
    String accessToken = "";
    String delete = "Bearer ";
    Entrance entrance;
    BaseTest baseTest;
    Transition transitions;// = new Transition(driver);

    @Before
    public void setUp(){
        Random random = new Random();
        name = "praktikum33";
        email = "praktikum" + random.nextInt(10000000) + "@yandex.ru";
        password = "qwerty"  + random.nextInt(10000000);
        json = "{\"email\": \"" + email + "\", \"password\": \"" + password + "\", \"name\": \"" + name + "\" }";

        baseTest = new BaseTest();
        driver = baseTest.setup("Chrome");
        entrance = new Entrance(driver);
        transitions = new Transition(driver);
    }

    public WebDriver setup(String browser){
        ChromeOptions options = new ChromeOptions(); // Драйвер для браузера
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = WebDriverFactory.getWebDriver(System.getProperty("browser", browser));
        driver.get(Config.URL_CONST);
        return driver;
    }

    @After
    public void quit(){
        if(!accessToken.isEmpty()) {
            accessToken = users.login(json)
                    .extract().body().path("accessToken");
            accessToken = accessToken.replace (delete, "");
            users.delete(accessToken,json);
        }
        driver.quit();
    }
}