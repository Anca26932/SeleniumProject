package Pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonPage {

    WebDriver driver;
    ElementsMethods elementsMethods;
    JavascriptHelpers javascriptHelpers;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.javascriptHelpers = new JavascriptHelpers(driver);
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//span[@class='text']")
    List<WebElement> elementsField;

    public void goToDesiredSubMenu(String submenu){
        javascriptHelpers.scrollDown(400);
        elementsMethods.selectElementFromListByText(elementsField,submenu);
    }

}





