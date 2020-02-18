package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TenderPage {

    //Наименование тендера
    @FindBy(xpath = "//*[@class=\"name\"]")
    public WebElement tenderHeader;

    private final WebDriver driver;

    public TenderPage(WebDriver driver) {
        this.driver = driver;
    }

}
