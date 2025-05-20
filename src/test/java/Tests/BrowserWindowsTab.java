package Tests;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptHelpers;
import HelperMethods.WindowsMethods;
import Pages.BrowserWebPage;
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

    HomePage homePage;
    CommonPage commonPage;
    BrowserWebPage browserWebPage;


    @Test
    public void automationMethod() {


        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        browserWebPage = new BrowserWebPage(getDriver());
        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        commonPage.goToDesiredSubMenu("Browser Windows");
        browserWebPage.displayedTextFromNewTab();
        browserWebPage.displayedTextFromWindow();



//        WebElement newTabButtonElement = driver.findElement(By.id("tabButton"));
//        elementsMethods.clickOnElement(newTabButtonElement);
//////
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
