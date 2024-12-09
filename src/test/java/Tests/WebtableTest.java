package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static java.awt.SystemColor.window;

public class WebtableTest {

    public WebDriver driver;

    @Test
    public void automationMethod (){

        //deschidem un browser de Chrome
        driver=new ChromeDriver();

        //accesam o pagina web
        driver.get("https://demoqa.com/");

        //facem browser-ul in mod maximisize
        driver.manage().window().maximize();

        //
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");



        //declaram un element

        WebElement Elementsfield=driver.findElement(By.xpath("//h5[text()='Elements']"));
        Elementsfield.click();

        WebElement Webtablefield=driver.findElement(By.xpath("//span[text()='Web Tables']"));
        Webtablefield.click();

        WebElement Addfield=driver.findElement(By.id("addNewRecordButton"));
        Addfield.click();

        WebElement FirstNamefield=driver.findElement(By.id("firstName"));
        String firstnameValue="Anca";
        FirstNamefield.sendKeys(firstnameValue);

        WebElement LastNamefield=driver.findElement(By.id("lastName"));
        String lastnameValue="Creta";
        LastNamefield.sendKeys(lastnameValue);

        WebElement Emailfield=driver.findElement(By.id("userEmail"));
        String emailValue="anca.creta@yahoo.com";
        Emailfield.sendKeys(emailValue);

        WebElement Agefield=driver.findElement(By.id("age"));
        String ageValue="30";
        Agefield.sendKeys(ageValue);

        WebElement Sallaryfield=driver.findElement(By.id("salary"));
        String sallaryValue="8000";
        Sallaryfield.sendKeys(sallaryValue);

        WebElement Departmentfield=driver.findElement(By.id("department"));
        String departamentValue="QA";
        Departmentfield.sendKeys(departamentValue);

        WebElement Submmitfield=driver.findElement(By.id("submit"));
        Submmitfield.click();





    }

}
