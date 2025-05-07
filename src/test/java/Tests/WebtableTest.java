package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptHelpers;
import Pages.CommonPage;
import Pages.HomePage;
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

    WebDriver driver;
    JavascriptHelpers javascriptHelpers;
    ElementsMethods elementsMethods;
    HomePage homePage;

    CommonPage commonPage;


    @Test
    public void automationMethod (){

        //deschidem un browser de Chrome
        driver=new ChromeDriver();

        //accesam o pagina web
        driver.get("https://demoqa.com/");

        //facem browser-ul in mod maximisize
        driver.manage().window().maximize();

        elementsMethods = new ElementsMethods(driver);
        javascriptHelpers = new JavascriptHelpers(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);


//       javascriptHelpers.scrollDown(400);
       //declaram un element

//        WebElement elementsField=driver.findElement(By.xpath("//h5[text()='Elements']"));
//        elementsMethods.clickOnElement(elementsField);
        homePage.goToDesiredMenu("Elements");

//        WebElement webTablesField=driver.findElement(By.xpath("//span[text()='Web Tables']"));
//        elementsMethods.clickOnElement(webTablesField);
        commonPage.goToDesiredSubMenu("Web Tables");

        List<WebElement> tableElements = driver.findElements(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[contains(@class, 'rt-tr -even') or contains(@class, 'rt-tr -odd')]"));
        Integer actualTableSize = tableElements.size();
        Assert.assertEquals(tableElements.size(), 3);

        WebElement addNewRecoordButton=driver.findElement(By.id("addNewRecordButton"));
        elementsMethods.clickOnElement(addNewRecoordButton);

//        Declarearea valorilor cu care se populeaza formul
        String firstNameValue = "Anca";
        String lastNameValue = "Creta";
        String emailValue = "anca.creta@yahoo.com";
        String ageValue = "30";
        String salaryValue = "1000";
        String departamentValue = "Marketing";


        WebElement firstNamefield=driver.findElement(By.id("firstName"));
        elementsMethods.fillElement(firstNamefield,firstNameValue);

        WebElement lastNamefield=driver.findElement(By.id("lastName"));
        elementsMethods.fillElement(lastNamefield,lastNameValue);

        WebElement emailField=driver.findElement(By.id("userEmail"));
        elementsMethods.fillElement(emailField,emailValue);

        WebElement ageField=driver.findElement(By.id("age"));
       elementsMethods.fillElement(ageField,ageValue);

        WebElement salaryfield=driver.findElement(By.id("salary"));
        elementsMethods.fillElement(salaryfield,salaryValue);


        WebElement departmentField=driver.findElement(By.id("department"));
        elementsMethods.fillElement(departmentField,departamentValue);


        WebElement Submmitfield=driver.findElement(By.id("submit"));
        Submmitfield.click();

        List<WebElement> expectedTableElements = driver.findElements(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']/div[@class='rt-tr -even' or @class='rt-tr -odd']"));

        Integer expectedTableSize = actualTableSize +1;
        Assert.assertEquals(expectedTableElements.size(),expectedTableSize);

        String actualTableValue = expectedTableElements.get(3).getText();
        Assert.assertTrue(actualTableValue.contains(firstNameValue));
        Assert.assertTrue(actualTableValue.contains(lastNameValue));
        Assert.assertTrue(actualTableValue.contains(emailValue));
        Assert.assertTrue(actualTableValue.contains(ageValue));
        Assert.assertTrue(actualTableValue.contains(salaryValue));
        Assert.assertTrue(actualTableValue.contains(departamentValue));


    }

}
