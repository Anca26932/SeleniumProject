package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.FramesMethods;
import HelperMethods.JavascriptHelpers;

import Pages.AlertsPage;
import Pages.CommonPage;
import Pages.FramesPage;
import Pages.HomePage;
import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frames extends ShareData {


    HomePage homePage;

    CommonPage commonPage;

    FramesPage framesPage;


    @Test
    public void automationMethod() throws InterruptedException {



        homePage = new HomePage(getDriver());

        commonPage = new CommonPage(getDriver());

        framesPage = new FramesPage(getDriver());

        homePage.goToDesiredMenu("Alerts, Frame & Windows");
        commonPage.goToDesiredSubMenu("Frames");
//        javascriptHelpers.scrollDown(400);

        framesPage.interactWithFrame1();
        framesPage.interactWithFrame2();


//        WebElement frame1Element = driver.findElement(By.id("frame1"));
//        framesMethods.switchToFrame(frame1Element);
//
//        WebElement sampleHeadingFrameElement = driver.findElement(By.id("sampleHeading"));
//        elementsMethods.displayContentOfElement(sampleHeadingFrameElement);
//

        //ne ducem cu focusul inapoi pe pagina personala
//        framesMethods.switchToMainContent();
        //driver.switchTo().defaultContent();

//        WebElement frame2Element = driver.findElement(By.id("frame2"));
//        framesMethods.switchToFrame(frame2Element);
//
//        WebElement sampleHeadingFromFrame2Element = driver.findElement(By.id("sampleHeading"));
//        elementsMethods.displayContentOfElement(sampleHeadingFromFrame2Element);
//
//        Thread.sleep(2000);
//        javascriptHelpers.scroll(50, 50);
//
//        framesMethods.switchToMainContent();


    }
}
