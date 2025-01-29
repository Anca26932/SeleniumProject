package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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

        List<WebElement> tableElements = driver.findElements(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[contains(@class, 'rt-tr -even') or contains(@class, 'rt-tr -odd')]"));

        Integer actualTableSize = tableElements.size();
        Assert.assertEquals(tableElements.size(), 3);

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

        List<WebElement> expectedTableElements = driver.findElements(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -even' or @class='rt-tr -odd']"));

        Integer expectedTableSize = actualTableSize +1;
        Assert.assertEquals(expectedTableElements.size(),expectedTableSize);

        String actualTableValue = expectedTableElements.get(3).getText();
        Assert.assertTrue(actualTableValue.contains(firstnameValue));
        Assert.assertTrue(actualTableValue.contains(lastnameValue));
        Assert.assertTrue(actualTableValue.contains(emailValue));
        Assert.assertTrue(actualTableValue.contains(ageValue));
        Assert.assertTrue(actualTableValue.contains(sallaryValue));
        Assert.assertTrue(actualTableValue.contains(departamentValue));


    }

}
