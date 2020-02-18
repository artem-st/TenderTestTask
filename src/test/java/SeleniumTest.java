import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.MainPage;
import pages.TenderPage;

class SeleniumTest {

    private static WebDriver driver;

    @BeforeAll
    static void initDriver(){
        driver = MyFirefoxDriver.getFirefoxDriver();
        driver.get("http://www.tender.pro");
    }

    @Test
    void test() throws InterruptedException {

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);

        //Открываем страницу Процедуры
        mainPage.getElemWithText("Процедуры", 2).click();

        //Открываем выбор категории
        mainPage.getElemWithText("Выбрать", 1).click();

        //Выбираем категорию
        mainPage.getElemWithText("Инструменты", 1).click();
        mainPage.getElemWithText("Сельскохозяйственный инструмент", 1).click();
        mainPage.getElemWithText("Сельскохозяйственный ручной инструмент", 1).click();
        mainPage.getElemWithText("Вилы", 1).click();

        //Выбираем первый тендер
        mainPage.chooseTender(1);

        //Проверяем наименование тендера
        TenderPage tenderPage = PageFactory.initElements(driver, TenderPage.class);
        Assertions.assertEquals("Приобретение хоз. товаров для нужд Балаковского филиала ОАО \"Апатит\" 3 кв.", tenderPage.tenderHeader.getText(), "Значения не совпадают");

    }

    @AfterAll
    static void quitDriver(){
        driver.close();
    }
}