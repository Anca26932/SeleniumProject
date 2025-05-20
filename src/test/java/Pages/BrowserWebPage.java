package Pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptHelpers;
import HelperMethods.WindowsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class BrowserWebPage extends CommonPage {
//    WebDriver driver;
//    ElementsMethods elementsMethods;
//    JavascriptHelpers javascriptHelpers;
//    Actions actions;
//    WindowsMethods windowsMethods;

//    public BrowserWebPage(WebDriver driver){
//        this.driver = driver;
//        this.elementsMethods = new ElementsMethods(driver);
//        this.javascriptHelpers = new JavascriptHelpers(driver);
//        this.actions = new Actions(driver);
//        this.windowsMethods = new WindowsMethods(driver);
//        PageFactory.initElements(driver,this);
//    }

    @FindBy(id="tabButton")
    private WebElement newTabButtonElement;

    @FindBy(id="sampleHeading")
    private WebElement sampleHeadingElement;

    @FindBy(id="windowButton")
    private WebElement windowButtonElement;

    public BrowserWebPage(WebDriver driver) {
        super(driver);
    }
    public void displayedTextFromNewTab(){
        elementsMethods.clickOnElement(newTabButtonElement);
        windowsMethods.switchToOpenedTab();
        elementsMethods.displayContentOfElement(sampleHeadingElement);
    }
    public void displayedTextFromWindow(){
        elementsMethods.clickOnElement(windowButtonElement);


    }
}
