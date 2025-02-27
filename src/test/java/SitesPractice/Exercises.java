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

//        selectCountryMethod();

       selectSubMenuMethod();

    }

    public void selectCountryMethod (){

        driver = new ChromeDriver();
        driver.get("https://letcode.in/forms");
        driver.manage().window().maximize();

//        WebElement firstNameField = driver.findElement(By.id("firstname"));
//        String firstNameValue = "Anca";
//        firstNameField.sendKeys(firstNameValue);
//
//        WebElement lastNameField = driver.findElement(By.id("lasttname"));
//        String lastNameValue = "Creta";
//        lastNameField.sendKeys(lastNameValue);
//
//        WebElement inputField = driver.findElement(By.id("email"));
//        inputField.clear();
//
//        WebElement emailField = driver.findElement(By.id("email"));
//        String emailValue = "anca.creta@yahoo.com";
//        emailField.sendKeys(emailValue);
//
//        WebElement phoneNumberField = driver.findElement(By.id("Phno"));
//        String phoneNumberValue = "+40748549322";
//        phoneNumberField.sendKeys(phoneNumberValue);
//
//        WebElement adressLine1Field = driver.findElement(By.id("Addl1"));
//        String phoneNumberValue = "+40748549322";
//        phoneNumberField.sendKeys(phoneNumberValue);


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

        WebElement postalCodefield = driver.findElement(By.id("postalcode"));
        String postalCodeValue ="407208";
        postalCodefield.sendKeys(postalCodeValue);

    }

    public void selectSubMenuMethod (){

        driver = new ChromeDriver();
        driver.get("https://www.barnesandnoble.com");

        WebElement subMenulink = driver.findElement(By.xpath("//a[text()='Nonfiction']/parent::li"));
        Actions actions = new Actions(driver);
        actions.moveToElement(subMenulink).pause(500).perform();

        WebElement siblingElement = driver.findElement(By.xpath("//a[text()='Nonfiction']/following-sibling::div"));
        Assert.assertTrue(siblingElement.isDisplayed());
        actions.moveToElement(siblingElement).pause(500).click().perform();
        Assert.assertTrue(driver.getTitle().contains("Nonfiction"));
    }
}
