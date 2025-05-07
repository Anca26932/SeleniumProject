package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.FramesMethods;
import HelperMethods.JavascriptHelpers;

import Pages.CommonPage;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frames {

    WebDriver driver;

    JavascriptHelpers javascriptHelpers;

    ElementsMethods elementsMethods;

    FramesMethods framesMethods;

    HomePage homePage;

    CommonPage commonPage;



//ne defineste variabila globala driver

    @Test
    public void automationMethod() throws InterruptedException {

        //deschidem un browser de Chrome
        driver = new ChromeDriver();

        //facem browser-ul in mod maximisize
        driver.manage().window().maximize();

        //accesam o pagina web
        driver.get("https://demoqa.com/");

        javascriptHelpers = new JavascriptHelpers(driver);
        elementsMethods = new ElementsMethods(driver);
        framesMethods = new FramesMethods(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);

//
//        javascriptHelpers.scrollDown(400);

//        WebElement alertFramesAndWindowsElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
//        elementsMethods.clickOnElement(alertFramesAndWindowsElement);
        homePage.goToDesiredMenu("Alerts, Frame & Windows");

//        WebElement framesElement = driver.findElement(By.xpath("//span[text()='Frames']"));
//        elementsMethods.clickOnElement(framesElement);
//
        commonPage.goToDesiredSubMenu("Frames");

        javascriptHelpers.scrollDown(400);

        WebElement frame1Element = driver.findElement(By.id("frame1"));
        framesMethods.switchToFrame(frame1Element);

        WebElement sampleHeadingFrameElement = driver.findElement(By.id("sampleHeading"));
        elementsMethods.displayContentOfElement(sampleHeadingFrameElement);


        //ne ducem cu focusul inapoi pe pagina personala
        framesMethods.switchToMainContent();
        //driver.switchTo().defaultContent();

        WebElement frame2Element = driver.findElement(By.id("frame2"));
        framesMethods.switchToFrame(frame2Element);

        WebElement sampleHeadingFromFrame2Element = driver.findElement(By.id("sampleHeading"));
        elementsMethods.displayContentOfElement(sampleHeadingFromFrame2Element);

        Thread.sleep(2000);
        javascriptHelpers.scroll(50, 50);

        framesMethods.switchToMainContent();

        Thread.sleep(5000);
        driver.quit();

    }

}
