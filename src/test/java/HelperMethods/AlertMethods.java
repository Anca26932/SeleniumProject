package HelperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertMethods {
    WebDriver driver;

    public AlertMethods(WebDriver driver) {
        this.driver = driver;
    }
    public void interactWithAlertsOK(){
        Alert alertOk = driver.switchTo().alert();
        alertOk.accept();
    }
    public void explicitAlertWait(){
//        Definim un wait explicit ca sa astepte dupa alerta
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

    }
    public void interactWithDelayAlert(){
        explicitAlertWait();
        Alert alertDelayOK = driver.switchTo().alert();
        alertDelayOK.accept();
    }
    public void interactWithConfirmationAlert(){
        Alert alertConfirmation = driver.switchTo().alert();
        alertConfirmation.dismiss();

    }
    public void interactWithPromptAlert(){
        Alert alertPrompt = driver.switchTo().alert();
        alertPrompt.sendKeys("Anca");
        alertPrompt.accept();


    }
}
