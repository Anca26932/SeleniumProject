package Pages;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage extends CommonPage {

//    WebDriver driver;

//    ElementsMethods elementsMethods;

//    JavascriptHelpers javascriptHelpers;
//
//    Actions actions;
//
//    AlertMethods alertMethods;

//    public AlertsPage(WebDriver driver) {
//        this.driver = driver;
//        this.elementsMethods = new ElementsMethods(driver);
//        this.javascriptHelpers = new JavascriptHelpers(driver);
//        this.alertMethods = new AlertMethods(driver);
//
//        PageFactory.initElements(driver, this);
//
//    }

    @FindBy(id = "alertButton")
    private WebElement alertOKElement;

    @FindBy(id = "timerAlertButton")
    private WebElement alertDeLayButton;

    @FindBy(id = "confirmButton")
    private WebElement alertConfirmationButton;

    @FindBy(id = "promtButton")
    private  WebElement alertPromptButton;

    public AlertsPage(WebDriver driver) {
        super(driver);
    }


    public void simpleAlert() {
        elementsMethods.clickOnElement(alertOKElement);
        alertMethods.interactWithAlertsOK();

    }

    public void alertDeLay() {
        elementsMethods.clickOnElement(alertDeLayButton);
        alertMethods.interactWithDelayAlert();

    }
    public void alertConfirmation(){
        elementsMethods.clickOnElement(alertConfirmationButton);
        alertMethods.interactWithConfirmationAlert();
    }
    public void alertPrompt(){
        elementsMethods.clickOnElement(alertPromptButton);
        alertMethods.interactWithPromptAlert();
    }
}


