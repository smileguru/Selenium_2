import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class RunTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup(){
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.edge.driver", "C://Users/Ivan/Desktop/ТПО/msedgedriver.exe");
        //создание экземпляра драйвера
        driver = new EdgeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек(неявное ожидание).
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get("https://devcs.avtodoria.ru/terminal/processing-queue");
    }

    @Test
    public void loginTest() throws InterruptedException {
        loginPage.inputLogin("1");
        loginPage.inputP("1");
        loginPage.clickBtn();
        System.out.println("Вы вошли в аккаунт:" + profilePage.getLogName());
        profilePage.clickBtnVideoQueue();
        System.out.println(profilePage.getClear_object());
        profilePage.clickBtnSortedData();
        profilePage.clickBtnData_month();
        profilePage.clickBtnSortedTypeTC();
        profilePage.clickBtnType_Bus();
        profilePage.clickBtnApplyFilter();
        Thread.sleep(1500);
        profilePage.returnCountEl();
        Thread.sleep(1000);
        profilePage.clickBtnDeletFilter();
    }

    @AfterClass
    public static void tearDown() {
        profilePage.clickBtnExit();
        System.out.println("Вы удачно вышли с аккаунта");
    }
}
