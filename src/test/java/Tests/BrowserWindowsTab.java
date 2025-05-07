package Tests;

import HelperMethods.AlertMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptHelpers;
import HelperMethods.WindowsMethods;
import Pages.CommonPage;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsTab {

    public WebDriver driver;
    WindowsMethods windowsMethods;
    ElementsMethods elementsMethods;
    JavascriptHelpers javascriptHelpers;
    HomePage homePage;
    CommonPage commonPage;


    @Test
    public void automationMethod() {

        //deschidem un browser de Chrome
        driver = new ChromeDriver();

        //accesam o pagina web
        driver.get("https://demoqa.com/");

        //facem browser-ul in mod maximisize
        driver.manage().window().maximize();


        elementsMethods = new ElementsMethods(driver);
        windowsMethods = new WindowsMethods(driver);
        javascriptHelpers = new JavascriptHelpers(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);


//        javascriptHelpers.scrollDown(400);
//
//        WebElement alertsFrameAndWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        elementsMethods.clickOnElement(alertsFrameAndWindowElement);
        homePage.goToDesiredMenu("Alerts, Frame & Windows");

//        WebElement browserWindowsElement = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
//        elementsMethods.clickOnElement(browserWindowsElement);
        commonPage.goToDesiredSubMenu("Browser Windows");

        WebElement newTabButtonElement = driver.findElement(By.id("tabButton"));
        elementsMethods.clickOnElement(newTabButtonElement);

        windowsMethods.switchToOpenedTab();

//        //returneaza windowsurile deschise
//        List<String> tablist = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tablist.get(1));

        WebElement sampleHeadingElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din new tab este: " + sampleHeadingElement.getText());

//        driver.close(); =>inchide doar fereastra curenta, nu tot browserul

       windowsMethods.switchToMainTab();

        WebElement windowButtonElement = driver.findElement(By.id("windowButton"));
        windowButtonElement.click();

        List<String> windowlist = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowlist.get(1));

        WebElement sampleHeadingWindowElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din new Window este: " + sampleHeadingWindowElement.getText());

        driver.close();
        driver.switchTo().window(windowlist.get(0));

    }

}
