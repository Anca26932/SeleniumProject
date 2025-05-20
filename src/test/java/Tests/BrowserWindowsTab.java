package Tests;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptHelpers;
import HelperMethods.WindowsMethods;
import Pages.CommonPage;
import Pages.HomePage;
import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsTab extends ShareData {


    WindowsMethods windowsMethods;
    ElementsMethods elementsMethods;
    JavascriptHelpers javascriptHelpers;
    HomePage homePage;
    CommonPage commonPage;
    BrowserWindowsTab browserWindowsTab;


    @Test
    public void automationMethod() {

        elementsMethods = new ElementsMethods(driver);

        windowsMethods = new WindowsMethods(driver);

        javascriptHelpers = new JavascriptHelpers(driver);

        homePage = new HomePage(driver);

        commonPage = new CommonPage(driver);

        javascriptHelpers.scrollDown(400);

        homePage.goToDesiredMenu("Alerts, Frame & Windows");

        commonPage.goToDesiredSubMenu("Browser Windows");



        WebElement newTabButtonElement = driver.findElement(By.id("tabButton"));
        elementsMethods.clickOnElement(newTabButtonElement);
////
//        windowsMethods.switchToOpenedTab();
//
//       List<String> tablist = new ArrayList<>(driver.getWindowHandles());
//       driver.switchTo().window(tablist.get(1));
//
//        WebElement sampleHeadingElement = driver.findElement(By.id("sampleHeading"));
//        System.out.println("Textul din new tab este: " + sampleHeadingElement.getText());
//
//        driver.close();
//        driver.switchTo().window(tablist.get(0));
//        windowsMethods.switchToMainTab();
//
//        WebElement windowButtonElement = driver.findElement(By.id("windowButton"));
//        windowButtonElement.click();
//
//        List<String> windowlist = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(windowlist.get(1));
//
//        WebElement sampleHeadingWindowElement = driver.findElement(By.id("sampleHeading"));
//        System.out.println("Textul din new Window este: " + sampleHeadingWindowElement.getText());
//        driver.close();
//
//        driver.switchTo().window(windowlist.get(0));
//
    }
}
