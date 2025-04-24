package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frames {

    public WebDriver driver;
//ne defineste variabila globala driver

    @Test
    public void automationMethod() {

        //deschidem un browser de Chrome
        driver = new ChromeDriver();

        //accesam o pagina web
        driver.get("https://demoqa.com/");


        //facem browser-ul in mod maximisize
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");

        WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertFrameWindowElement.click();

        WebElement frameElement = driver.findElement(By.xpath("//span[text()='Frames']"));
        frameElement.click();

        WebElement frame1Element = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1Element);

        WebElement sampleHeadingFrameElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din new Window este: " + sampleHeadingFrameElement.getText());

     //ne ducem cu focusul inapoi pe pagina personala

        driver.switchTo().defaultContent();

        WebElement frame2Element = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(frame2Element);

        js.executeScript("window.scrollBy(200,200)");

    }

}
