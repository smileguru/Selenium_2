import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.ls.LSOutput;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProfilePage {
    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "grid")
    private WebElement BtnVideoQueue;

    public void clickBtnVideoQueue() {
        BtnVideoQueue.click();
    }

    @FindBy(xpath = "/html/body/app-root/div/div/div/main/app-processing-queue-page/app-processing-queue/div/mat-table/div")
    private WebElement clear_object;

    public String getClear_object() {
        return clear_object.getText();
    }

    @FindBy(id = "date_picker_input")
    private WebElement BtnSortedData;

    public void clickBtnSortedData() {
        BtnSortedData.click();
    }

    @FindBy(xpath = "/html/body/app-root/div/div/div/main/app-processing-queue-page/app-queue-filter/div/form/div/ngx-daterangepicker-material/div/div[1]/ul/li[4]/button")
    private WebElement BtnData_month;

    public void clickBtnData_month() {
        BtnData_month.click();
    }

    @FindBy(xpath = "/html/body/app-root/div/div/div/main/app-processing-queue-page/app-queue-filter/div/form/ngx-select-dropdown[3]/div/button/span[1]")
    private WebElement BtnSortedTypeTC;

    public void clickBtnSortedTypeTC() {
        BtnSortedTypeTC.click();
    }

    @FindBy(xpath = "/html/body/app-root/div/div/div/main/app-processing-queue-page/app-queue-filter/div/form/ngx-select-dropdown[3]/div/div/ul[2]/li[1]")
    private WebElement BtnType_Bus;

    public void clickBtnType_Bus() {
        BtnType_Bus.click();
    }

    @FindBy(xpath = "//*[@id=\"filter_button\"]/button/span")
    private WebElement BtnApplyFilter;

    public void clickBtnApplyFilter() {
        BtnApplyFilter.click();
    }

    @FindBy(xpath = "//*[@id=\"clear_button\"]/button")
    private WebElement BtnDeletFilter;

    public void clickBtnDeletFilter() {
        BtnDeletFilter.click();
    }


    @FindBy(xpath = "/html/body/app-root/div/div/div/app-top-panel/div/app-user-menu/i")
    private WebElement BtnMenu;
    @FindBy(xpath = "/html/body/app-root/div/div/div/app-top-panel/div/app-user-menu/div/app-ui-button/button")
    private WebElement BtnExit;

    public void clickBtnExit() {
        BtnMenu.click();
        BtnExit.click();
    }


    //Задание 2
    @FindBy(xpath = "/html/body/app-root/div/div/div/main/app-processing-queue-page/app-queue-filter/div/form/input")
    WebElement NumberEntriesPerPage;

    @FindBy(xpath = "/html/body/app-root/div/div/div/main/app-processing-queue-page/app-processing-queue/div/mat-table/mat-row")
    List<WebElement> listElementov_1str;

    @FindBy(id = "next_page")
    WebElement NextPage;

    @FindBy(id = "last_page")
    WebElement LastPage;

    public void set3ElementaToPage(int i) {
        NumberEntriesPerPage.clear();
        NumberEntriesPerPage.sendKeys(String.valueOf(i));
        BtnApplyFilter.click();
    }

    public String getLogName(){
        return driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-top-panel/div/app-user-menu/app-user-info/p")).getText();
    }

    public void returnCountEl() throws InterruptedException {
        List<WebElement> elements = driver.findElements(By.xpath("/html/body/app-root/div/div/div/main/app-processing-queue-page/app-processing-queue/div/mat-table/div")); // Находим все элементы, соответствующие локатору
        if (elements.size() != 0) {
            System.out.println("Объекты не найдены.");
        } else {



//                2 Вариант c помощью получения эл-тов страницы
        set3ElementaToPage(10);
        Thread.sleep(1000);
        int xpathCount = listElementov_1str.size();
        boolean n_p = driver.findElements(By.id("next_page")).size() != 0;
        boolean l_p = driver.findElements(By.id("last_page")).size() != 0;
        if (l_p) {
            int f = Integer.parseInt(LastPage.getText()) - 1;
            System.out.println("Кол-во страниц = "+(f+1));
            LastPage.click();
            Thread.sleep(1500);
            xpathCount = xpathCount * f + listElementov_1str.size();
        } else if (n_p) {
            System.out.println("Кол-во страниц = "+n_p);
            NextPage.click();
            Thread.sleep(1500);
            xpathCount = xpathCount + listElementov_1str.size();
        }else {
            System.out.println("Кол-во страниц = 1");
        }
            System.out.println("Количесво записей = " + xpathCount);
        }


//                1 Вариант с циклом For

//            set3ElementaToPage(10);
//            int xpathCount = Integer.parseInt(NumberEntriesPerPage.getAttribute("value"));
//            boolean n_p = driver.findElements(By.id("next_page")).size() != 0;
//            boolean l_p = driver.findElements(By.id("last_page")).size() != 0;
//            if (l_p) {
//                int f = Integer.parseInt(LastPage.getText()) - 1;
//                System.out.println(f);
//                LastPage.click();
//                xpathCount = xpathCount * f + getCountLP(xpathCount);
//            } else if (n_p) {
//                NextPage.click();
//                xpathCount = xpathCount + getCountLP(xpathCount);
//            }else{
//                xpathCount = getCountLP(xpathCount);
//            }
    }


//    private int getCountLP(int j) throws InterruptedException {
//        Thread.sleep(1500);
//        int x = 0;
//        for (int i = 0; i <= j; i++){
//            if (driver.findElements( By.id("checkbox_"+i)).size() == 0){
//                if (i == 0) {
//                    x = 1;
//                }else{
//                    x = i;
//                }
//                break;
//            }
//        }
//        return x;
//    }
}
