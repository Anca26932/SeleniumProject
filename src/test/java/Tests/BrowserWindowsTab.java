package Tests;

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
        js.executeScript("window.scrollBy(0,400)");

        WebElement alertFrameWindowElement = driver.findElement(By.xpath("//h5[text()='Alerts, Frame & Windows']"));
        alertFrameWindowElement.click();

        WebElement browserWindowsElement = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        browserWindowsElement.click();

        WebElement tabButtonElement = driver.findElement(By.id("tabButton"));
        tabButtonElement.click();

        //returneaza windowsurile deschise
        List<String> tablist = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tablist.get(1));


        WebElement sampleHeadingElement = driver.findElement(By.id("sampleHeading"));
        System.out.println("Textul din new tab este: " + sampleHeadingElement.getText());

        driver.close();

        driver.switchTo().window(tablist.get(0));

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
