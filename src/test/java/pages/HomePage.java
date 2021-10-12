package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath=".//img[@alt='Fork me on GitHub']")
    WebElement gitHubLink;

}
