package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class PracticeFormTest {

    public WebDriver driver;
//ne defineste variabila globala driver

    @Test
    public void automationMethod () {

        //deschidem un browser de Chrome
        driver = new ChromeDriver();

        //accesam o pagina web
        driver.get("https://demoqa.com/");

        //facem browser-ul in mod maximisize
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        WebElement formElement=driver.findElement(By.xpath("//h5[text()='Forms']"));
        formElement.click();

        WebElement practiceformElement=driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceformElement.click();

        WebElement firstNameElement=driver.findElement(By.id("firstName"));
        String firstnameValue="Anca";
        firstNameElement.sendKeys(firstnameValue);

        WebElement lastNameElement=driver.findElement(By.id("lastName"));
        String lastNamevalue="Creta";
        lastNameElement.sendKeys(lastNamevalue);

        WebElement userEmailElement=driver.findElement(By.id("userEmail"));
        String userEmailValue="anca.creta@yahoo.com";
        userEmailElement.sendKeys(userEmailValue);

        WebElement mobilenumberElement=driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobilenumberValue="0748549322";
        mobilenumberElement.sendKeys(mobilenumberValue);

        WebElement pictureElement=driver.findElement(By.id("uploadPicture"));

        File file = new File("src/test/resources/1.jpeg");
        pictureElement.sendKeys(file.getAbsolutePath());





    }


}
