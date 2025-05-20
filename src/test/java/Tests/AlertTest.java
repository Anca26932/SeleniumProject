package Tests;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptHelpers;
import Pages.AlertsPage;
import Pages.CommonPage;
import Pages.HomePage;
import ShareData.ShareData;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest extends ShareData {

    ElementsMethods elementsMethods;
    AlertMethods alertMethods;
    JavascriptHelpers javascriptHelpers;
    HomePage homePage;
    CommonPage commonPage;
    AlertsPage alertsPage;


    @Test
    public void automationMethod() {

        elementsMethods = new ElementsMethods(driver);
        alertMethods = new AlertMethods(driver);
        javascriptHelpers = new JavascriptHelpers(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        alertsPage = new AlertsPage(driver);

//        javascriptHelpers.scrollDown(400);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");

        commonPage.goToDesiredSubMenu("Alerts");

        alertsPage.simpleAlert();
        alertsPage.alertDeLay();
        alertsPage.alertConfirmation();
        alertsPage.alertPrompt();

//        trigaruieste o alerta
//        Cum interactionam cu alerta : Alert alertOk = driver.SwitchTo.alert()
//        switch to se muta cu focusul pe o alerta
//        ce putem face cu aceasta alerta? sa apasam ok pe ea
//        ne mutam cu focusul si apoi luam o decizie .in cazul nostru functioneaza doar cu ok
//        alertOk.accept();

//        WebElement alertOKElement = driver.findElement(By.id("alertButton"));
//        elementsMethods.clickOnElement(alertOKElement);
//        alertMethods.interactWithAlertsOK();

//        Definim un wait explicit ca sa astepte dupa alerta
        //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.alertIsPresent());
//        Alert alertDelayOK = driver.switchTo().alert();
//        alertDelayOK.accept();

//       WebElement alertDelayOKElement = driver.findElement(By.id("timerAlertButton"));
//       elementsMethods.clickOnElement(alertDelayOKElement);
//       alertMethods.interactWithDelayAlert();


//
//        WebElement alertConfirmationElement = driver.findElement(By.id("confirmButton"));
//        alertConfirmationElement.click();
//        Alert alertConfirmation = driver.switchTo().alert();
//        alertConfirmation.dismiss();
//        elementsMethods.clickOnElement(alertConfirmationElement);
//        alertMethods.interactWithConfirmationAlert();


//        WebElement alertPromptElement = driver.findElement(By.id("promptButton"));
//        elementsMethods.clickOnElement(alertPromptElement);
//        alertMethods.interactWithPromptAlert();

//        Alert alertPrompt = driver.switchTo().alert();
//        alertPrompt.sendKeys("Anca");
//        alertPrompt.accept();

    }
}
