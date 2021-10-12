import com.links.PartsUrls;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckBoxPage;


public class CheckboxesFeatureTest extends BaseConfig{
    CheckBoxPage checkBoxPage;

    @Test
    public void select_checkBox() {
        checkBoxPage = PageFactory.initElements(driver, CheckBoxPage.class);
        //getting url and open webpage
        driver.get(PartsUrls.getLink("checkboxes"));
        //verification of unselected checkbox status
        String attrStatus = checkBoxPage.getCheckbox("checkbox1").getAttribute("checked");
        if (attrStatus ==null){
            checkBoxPage.clickCheckbox("checkbox1");
        }
        //verification of selected checkbox status
        attrStatus = checkBoxPage.getCheckbox("checkbox1").getAttribute("checked");
        Assert.assertTrue(Boolean.parseBoolean(attrStatus));
    }
    @Test
    public void unselect_checkBox() {
        checkBoxPage = PageFactory.initElements(driver, CheckBoxPage.class);
        //getting url and open webpage
        driver.get(PartsUrls.getLink("checkboxes"));
        //verification of unselected checkbox status
        String attrStatus = checkBoxPage.getCheckbox("checkbox2").getAttribute("checked");
        if (attrStatus !=null){
            checkBoxPage.clickCheckbox("checkbox2");
        }
        //verification of selected checkbox status
        attrStatus = checkBoxPage.getCheckbox("checkbox2").getAttribute("checked");
        Assert.assertFalse(Boolean.parseBoolean(attrStatus));
    }

}
