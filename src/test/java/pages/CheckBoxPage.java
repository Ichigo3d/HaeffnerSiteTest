package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBoxPage extends BasePage{
    WebDriverWait w;

    @FindBy(xpath="//form[@id='checkboxes']/input[1]")
    public static WebElement checkbox1;

    @FindBy(xpath="//form[@id='checkboxes']/input[2]")
    public static WebElement checkbox2;

    public CheckBoxPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        w = new WebDriverWait(driver,10);

    }

    public void clickCheckbox(String checkboxName){

            w.until(ExpectedConditions.visibilityOf(getCheckbox(checkboxName))).click();

    }
    public boolean isMarked(String checkboxName){
        return getCheckbox(checkboxName).isSelected();
    }
    public WebElement getCheckbox(String checkboxName){
        WebElement result = null;
        if(checkboxName.equals("checkbox1")){
            result = checkbox1;
        }else if (checkboxName.equals("checkbox2")){
            result = checkbox2;
        }
        return result;
    }



}
