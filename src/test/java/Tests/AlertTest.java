package Tests;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class AlertTest {
    public WebDriver driver;
    public ElementsMethods elementsMethods;
    public AlertMethods alertMethods;

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

        WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        elementsMethods.clickOnElements(alertFrameWindowElement);


        WebElement alertElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
        elementsMethods.clickOnElements(alertElement);


        WebElement alertOKElement = driver.findElement(By.id("alertButton"));
        elementsMethods.clickOnElements(alertOKElement);
        alertMethods.interractWithAlertsOK();


        WebElement alertDelayOKElement = driver.findElement(By.id("timerAlertButton"));
        elementsMethods.clickOnElements(alertDelayOKElement);

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
