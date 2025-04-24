package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {
    public WebDriver driver;
//ne defineste variabila globala driver

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

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertFrameWindowElement.click();

        WebElement alertElement = driver.findElement(By.xpath("//span[text()='Alerts']"));
        alertElement.click();

        WebElement alertOKElement = driver.findElement(By.id("alertButton"));
        alertElement.click();


        Alert alertOk = driver.switchTo().alert();
        //ne mutam cu focusul pe alerta
        alertOk.accept();

        WebElement alertDelayOKElement = driver.findElement(By.id("timerAlertButton"));
        alertDelayOKElement.click();

        //definim un wait explicit ca sa astepte alerta
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alertDelayOK = driver.switchTo().alert();
        alertDelayOK.accept();

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
