import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "username")
    private WebElement loginF;

    public void inputLogin(String login) {
        loginF.sendKeys(login);
    }

    @FindBy(id = "password")
    private WebElement passwordF;

    public void inputP(String password) {
        passwordF.sendKeys(password);
    }

    @FindBy(id = "kc-login")
    private WebElement SingIn;

    public void clickBtn(){
        SingIn.click();
    }
}
