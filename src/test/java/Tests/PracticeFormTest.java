package Tests;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class PracticeFormTest {

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

        WebElement formElement = driver.findElement(By.xpath("//h5[text()='Forms']"));
        formElement.click();

        WebElement practiceformElement = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceformElement.click();

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstnameValue = "Anca";
        firstNameElement.sendKeys(firstnameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNamevalue = "Creta";
        lastNameElement.sendKeys(lastNamevalue);

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        String userEmailValue = "anca.creta@yahoo.com";
        userEmailElement.sendKeys(userEmailValue);

        WebElement mobilenumberElement = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobilenumberValue = "0748549322";
        mobilenumberElement.sendKeys(mobilenumberValue);

        WebElement pictureElement = driver.findElement(By.id("uploadPicture"));

        File file = new File("src/test/resources/1.jpeg");
        pictureElement.sendKeys(file.getAbsolutePath());

        WebElement maleElement = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement femaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement otherElement = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
        js.executeScript("window.scrollBy(0,400)");

        String genderValue = "Other";

        if (maleElement.getText().equals(genderValue)) {
            maleElement.click();

        } else if (femaleElement.getText().equals(genderValue)) {
            femaleElement.click();
        } else {
            otherElement.click();
        }


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

        js.executeScript("window.scrollBy(0,400)");

        WebElement stateElement = driver.findElement(By.id("react-select-3-input"));
        js.executeScript("arguments[0].click()", stateElement);
        stateElement.sendKeys("NCR");
        stateElement.sendKeys(Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
        js.executeScript("arguments[0].click()", cityElement);
        cityElement.sendKeys("Delhi");
        cityElement.sendKeys(Keys.ENTER);

        WebElement submitElement = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click()", submitElement);


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