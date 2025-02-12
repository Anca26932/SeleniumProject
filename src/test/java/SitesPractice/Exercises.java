package SitesPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class Exercises {

    public WebDriver driver;


    @Test

    public void callMethods (){

        selectCountryMethod();

        selectSubMenuMethod();

    }

    public void selectCountryMethod (){

        driver = new ChromeDriver();
        driver.get("https://letcode.in/forms");
        driver.manage().window().maximize();

        List<WebElement> selects = driver.findElements(By.xpath("//form//div[@class='control']//select"));
        WebElement parentOfCountryCodeSelect = selects.get(0);
        WebElement parentOfCountrySelect = selects.get(1);


        Select listOfCountryCode = new Select(parentOfCountryCodeSelect);
        parentOfCountryCodeSelect.click();
        listOfCountryCode.selectByValue("238");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");


        Select listOfCountry = new Select(parentOfCountrySelect);
        parentOfCountrySelect.click();
        listOfCountry.selectByValue("Cape Verde");

    }

    public void selectSubMenuMethod (){

        driver = new ChromeDriver();
        driver.get("https://www.barnesandnoble.com");

        WebElement subMenulink = driver.findElement(By.xpath("//a[text()='Nonfiction']/parent::li"));
        Actions actions = new Actions(driver);
        actions.moveToElement(subMenulink).perform();

        WebElement siblingElement = driver.findElement(By.xpath("//a[text()='Nonfiction']/following-sibling::div"));
        Assert.assertTrue(siblingElement.isDisplayed());


    }




}
