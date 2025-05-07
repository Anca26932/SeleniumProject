package Tests;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptHelpers;
import Pages.CommonPage;
import Pages.HomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class AlertTest {
    public WebDriver driver;
    ElementsMethods elementsMethods;
    AlertMethods alertMethods;
    JavascriptHelpers javascriptHelpers;
    HomePage homePage;
    CommonPage commonPage;

    @Test
    public void automationMethod() {
        //deschidem un browser de Chrome
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");
        //definim un wait implicit pentru un interval maxim de timp
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //facem browser-ul in mod maximisize
        driver.manage().window().maximize();
        elementsMethods = new ElementsMethods(driver);
        alertMethods = new AlertMethods(driver);
        javascriptHelpers = new JavascriptHelpers(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);

//        javascriptHelpers.scrollDown(400);
//
//        WebElement alertFrameAndWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        elementsMethods.clickOnElements(alertFrameAndWindowElement);
        homePage.goToDesiredMenu("Alerts, Frame & Windows");
//

//        WebElement alertsElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
//        elementsMethods.clickOnElements(alertsElement);
        commonPage.goToDesiredSubMenu("Alerts");


        WebElement alertOKElement = driver.findElement(By.id("alertButton"));
        elementsMethods.clickOnElement(alertOKElement);
        alertMethods.interractWithAlertsOK();


        WebElement alertDelayOKElement = driver.findElement(By.id("timerAlertButton"));
        elementsMethods.clickOnElement(alertDelayOKElement);

//        Definim un wait explicit ca sa astepte dupa alerta
        alertMethods.interrectWithDelayAlert();
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.alertIsPresent());
//
//        Alert alertDelayOK = driver.switchTo().alert();
//        alertDelayOK.accept();

        WebElement alertConfirmationElement = driver.findElement(By.id("confirmButton"));
        alertConfirmationElement.click();

        Alert alertConfirmation = driver.switchTo().alert();
        alertConfirmation.dismiss();


        WebElement alertPromtElement = driver.findElement(By.id("promtButton"));
        alertPromtElement.click();

        Alert alertPromt = driver.switchTo().alert();
        alertPromt.sendKeys("Anca");
        alertPromt.accept();

    }
}
