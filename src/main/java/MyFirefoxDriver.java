import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class MyFirefoxDriver {

    public static FirefoxDriver getFirefoxDriver(){

        String path = new File("src/main/resources/geckodriver.exe").getAbsolutePath();
        System.setProperty("webdriver.gecko.driver", path);
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;

    }
}
