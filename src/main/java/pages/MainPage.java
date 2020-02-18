package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage {

    //Список тендеров
    @FindAll(
            @FindBy(xpath = "//*[@class = \"summary\"]")
    )
    private List<WebElement> tenders;

    //Наименование тендера
    @FindBy(xpath = "//input[@name='provider-period']")
    private WebElement paymentPeriod;

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElemWithText(String text, int count) throws InterruptedException {
        //Ожидания добавлены в целях наглядности при выполнении теста
        TimeUnit.SECONDS.sleep(3);
        return driver.findElement(By.xpath("(//*[text()=\"" + text + "\"])[" + count + "]"));
    }

    public void chooseTender(int index){
        index--;
        tenders.get(index).click();
    }


}
