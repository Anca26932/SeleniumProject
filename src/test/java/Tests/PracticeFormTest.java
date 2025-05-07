package Tests;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptHelpers;
import Pages.CommonPage;
import Pages.HomePage;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormTest {
     WebDriver driver;  //ne defineste variabila globala driver
     ElementsMethods elementMethods;
     JavascriptHelpers javascriptHelpers;
     HomePage homePage;
     CommonPage commonPage;


    @Test
    public void automationMethod() {
        //deschidem un browser de Chrome
        driver = new ChromeDriver();
        //accesam o pagina web
        driver.get("https://demoqa.com/");
        //facem browser-ul in mod maximisize


        driver.manage().window().maximize();

        elementMethods = new ElementsMethods(driver);
        javascriptHelpers = new JavascriptHelpers(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);

//        Facem un scroll ca sa fie elementul vizibil
//        In caz ca nu incape pe pagina

//        javascriptHelpers.scrollDown(400);

          //declaram un element

//        WebElement formsElement = driver.findElement(By.xpath("//h5[text()='Forms']"));
//        elementMethods.selectElementFromListByText(formsElement);

//        List <WebElement> elements = driver.findElements(By.xpath("//h5"));
//        elementMethods.selectElementFromListByText(elements, "Forms");

        homePage.goToDesiredMenu("Forms");

//        List <WebElement> subElementsList = driver.findElements(By.xpath("//span[@class='text']"));
//        elementMethods.selectElementFromListByText(subElementsList,"Practice Form");

        commonPage.goToDesiredSubMenu("Practice Form");

        javascriptHelpers.scrollDown(400);

        WebElement addFirstName = driver.findElement(By.id("firstName"));
        elementMethods.fillElement(addFirstName, "Anca");

        WebElement addLastName = driver.findElement(By.id("lastName"));
        elementMethods.fillElement(addLastName,"Creta");

        WebElement addEmail = driver.findElement(By.id("userEmail"));
        elementMethods.fillElement(addEmail,"anca.creta@yahoo.com");

        WebElement addMobile = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        elementMethods.fillElement(addMobile,"0748549322");

        WebElement addPicture = driver.findElement(By.id("uploadPicture"));
        elementMethods.uploadPicture(addPicture);

        WebElement maleElement = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement femaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement otherElement = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
        javascriptHelpers.scrollDown(400);

        List<WebElement> genderElement = new ArrayList<>();
        genderElement.add(maleElement);
        genderElement.add(femaleElement);
        genderElement.add(otherElement);

        elementMethods.selectElementFromListByText(genderElement,"Female");



        WebElement sportsElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
        WebElement readingElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']"));
        WebElement musicElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']"));

        String hobbiesValue = "Reading";

        if (sportsElement.getText().equals(hobbiesValue)) {
            sportsElement.click();

        } else if (readingElement.getText().equals(hobbiesValue)) {
            readingElement.click();
        } else {
            musicElement.click();
        }

        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        String SubjectsValue = "Social Studies";
        subjectsElement.sendKeys(SubjectsValue);
        subjectsElement.sendKeys(Keys.ENTER);

        javascriptHelpers.scrollRight(20);

        WebElement stateElement = driver.findElement(By.id("react-select-3-input"));
        elementMethods.clickOnElement(stateElement);
        stateElement.sendKeys("NCR");
        stateElement.sendKeys(Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
        elementMethods.clickOnElement(cityElement);
        cityElement.sendKeys("Delhi");
        cityElement.sendKeys(Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        elementMethods.clickOnElement(submitElement);


        List<WebElement> getRows = driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr"));

        WebElement studentNameRow = getRows.get(0);
        String studentNameRowSecondTdValueText = studentNameRow.findElement(By.xpath("./td[2]")).getText();

        Assert.assertEquals(studentNameRowSecondTdValueText, "Anca Creta");

        WebElement studentEmailRow = getRows.get(1);
        String studentEmailRowSecondTdValueText = studentEmailRow.findElement(By.xpath("./td[2]")).getText();

        Assert.assertEquals(studentEmailRowSecondTdValueText, "anca.creta@yahoo.com");

        WebElement genderRow = getRows.get(2);
        String genderRowSecondTdValueText = genderRow.findElement(By.xpath("./td[2]")).getText();

        Assert.assertEquals(genderRowSecondTdValueText, "Other");

        WebElement mobileRow = getRows.get(3);
        String mobileRowSecondTdValueText = mobileRow.findElement(By.xpath("./td[2]")).getText();

        Assert.assertEquals(mobileRowSecondTdValueText, "0748549322");

        WebElement dateOfBirthdayRow = getRows.get(4);
        String dateOfBirthdayRowSecondTdValueText = dateOfBirthdayRow.findElement(By.xpath("./td[2]")).getText();

        Assert.assertEquals(dateOfBirthdayRowSecondTdValueText, "25 February,2025");

        WebElement subjectsRow = getRows.get(5);
        String subjectsRowSecondTdValueText = subjectsRow.findElement(By.xpath("./td[2]")).getText();

        Assert.assertEquals(subjectsRowSecondTdValueText, "Social Studies");

        WebElement hobbiesRow = getRows.get(6);
        String hobbiesRowSecondTdValueText = hobbiesRow.findElement(By.xpath("./td[2]")).getText();

        Assert.assertEquals(hobbiesRowSecondTdValueText, "Reading");


        WebElement stateRow = getRows.get(9);
        String stateRowSecondTdValueText = stateRow.findElement(By.xpath("./td[2]")).getText();

        Assert.assertEquals(stateRowSecondTdValueText, "NCR Delhi");

    }
}