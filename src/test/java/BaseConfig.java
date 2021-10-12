import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;


public class BaseConfig {
    WebDriver driver;
    @BeforeTest
    @Parameters({ "os", "browser", "version" })
    public void setUp(String os, String browser, String version){
        String driverPath = null;
        if(browser.equalsIgnoreCase("chrome")){
            if (os.contains("macOS")){
                driverPath = "src/resources/chromedriver";
            }else if (os.contains("Windows")){
                driverPath = "src\\resources\\chromedriver.exe";
            }
            assert driverPath != null;
            ChromeDriverService service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(driverPath))
                    .usingAnyFreePort()
                    .build();
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(service, options);
        }else if (browser.equalsIgnoreCase("firefox")){
            if (os.contains("macOS")){
                driverPath = "src/resources/geckodriver";
            }else if (os.contains("Windows")){
                driverPath = "src\\resources\\geckodriver.exe";
            }
            assert driverPath != null;
            FirefoxOptions options = new FirefoxOptions()
                    .addArguments(driverPath)
                    .addArguments("start-maximized")
                    .addPreference("javascript.enabled", true);
            driver = new FirefoxDriver(options);
        }




    }

    @AfterTest
    public void afterTest() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
