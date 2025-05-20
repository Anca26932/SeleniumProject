package Tests;

import Pages.CommonPage;
import Pages.HomePage;
import Pages.PracticeFormPage;
import ShareData.ShareData;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTest extends ShareData {

    HomePage homePage;

    CommonPage commonPage;

    PracticeFormPage practiceFormPage;

    @Test
    public void automationMethod() throws InterruptedException {

        homePage = new HomePage(getDriver());

        commonPage = new CommonPage(getDriver());

        practiceFormPage = new PracticeFormPage(getDriver());

        homePage.goToDesiredMenu("Forms");

        commonPage.goToDesiredSubMenu("Practice Form");
//        javascriptHelpers.scrollDown(400);


        practiceFormPage.completeFirstRegion("Anca", "Creta", "anca.creta@yahoo.com", "Razaoare 7B", "0737138519");
        practiceFormPage.completeGender("Male");
        practiceFormPage.completeSubject("English");

//        List<String> subject = new ArrayList<>();
//        subject.add("Maths");
//        subject.add("English");
//        practiceFormPage.completeSubjectWithList(subject);

        List<String> hobbies = new ArrayList<>();
        hobbies.add("Sports");
        hobbies.add("Music");
        hobbies.add("Reading");

        practiceFormPage.completeHobbies(hobbies);
        practiceFormPage.completeState("NCR", "New-Delhi");
        practiceFormPage.submit();


//        WebElement formsElement = driver.findElement(By.xpath("//h5[text()='Forms']"));
//        elementMethods.selectElementFromListByText(formsElement);

//        List <WebElement> elements = driver.findElements(By.xpath("//h5"));
//        elementMethods.selectElementFromListByText(elements, "Forms");

//        homePage.goToDesiredMenu("Forms");

//        List <WebElement> subElementsList = driver.findElements(By.xpath("//span[@class='text']"));
//        elementMethods.selectElementFromListByText(subElementsList,"Practice Form");
//
//        commonPage.goToDesiredSubMenu("Practice Form");
//
//        javascriptHelpers.scrollDown(400);
////
//        WebElement addFirstName = driver.findElement(By.id("firstName"));
//        elementMethods.fillElement(addFirstName, "Anca");
//
//        WebElement addLastName = driver.findElement(By.id("lastName"));
//        elementMethods.fillElement(addLastName,"Creta");
//
//        WebElement addEmail = driver.findElement(By.id("userEmail"));
//        elementMethods.fillElement(addEmail,"anca.creta@yahoo.com");
//
//        WebElement addMobile = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
//        elementMethods.fillElement(addMobile,"0748549322");
//
//        WebElement addPicture = driver.findElement(By.id("uploadPicture"));
//        elementMethods.uploadPicture(addPicture);
//
//        WebElement addressElement = driver.findElement(By.id("currentAddress"));
//        elementMethods.fillElement(addressElement,"Strada Razoare nr. 8");
//
//
//
//        WebElement maleElement = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
//        WebElement femaleElement = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
//        WebElement otherElement = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));
//        javascriptHelpers.scrollDown(400);
//
//        List<WebElement> genderElement = new ArrayList<>();
//        genderElement.add(maleElement);
//        genderElement.add(femaleElement);
//        genderElement.add(otherElement);
//
//        elementMethods.selectElementFromListByText(genderElement,"Female");
//
//
//
//        WebElement sportsElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
//        WebElement readingElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']"));
//        WebElement musicElement = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']"));
//
//        String hobbiesValue = "Reading";
//
//        if (sportsElement.getText().equals(hobbiesValue)) {
//            sportsElement.click();
//
//        } else if (readingElement.getText().equals(hobbiesValue)) {
//            readingElement.click();
//        } else {
//            musicElement.click();
//        }
//
//        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
//        elementMethods.fillElement(subjectsElement,"Social Studies");
//        elementMethods.clickOnElementWithKeyboard(subjectsElement);
//        javascriptHelpers.scrollRight(20);
//
//        WebElement stateElement = driver.findElement(By.id("react-select-3-input"));
//        elementMethods.clickOnElement(stateElement);
//        elementMethods.fillElement(stateElement ,"NCR");
//        elementMethods.clickOnElementWithKeyboard(stateElement);
//
//
//        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
//        elementMethods.clickOnElement(cityElement);
//        elementMethods.fillElement(cityElement,"Delhi");
//        elementMethods.clickOnElementWithKeyboard(cityElement);
//
//        WebElement submitElement = driver.findElement(By.id("submit"));
//        elementMethods.clickOnElement(submitElement);


//        List<WebElement> getRows = driver.findElements(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr"));
//
//        WebElement studentNameRow = getRows.get(0);
//        String studentNameRowSecondTdValueText = studentNameRow.findElement(By.xpath("./td[2]")).getText();
//
//        Assert.assertEquals(studentNameRowSecondTdValueText, "Anca Creta");
//
//        WebElement studentEmailRow = getRows.get(1);
//        String studentEmailRowSecondTdValueText = studentEmailRow.findElement(By.xpath("./td[2]")).getText();
//
//        Assert.assertEquals(studentEmailRowSecondTdValueText, "anca.creta@yahoo.com");
//
//        WebElement genderRow = getRows.get(2);
//        String genderRowSecondTdValueText = genderRow.findElement(By.xpath("./td[2]")).getText();
//
//        Assert.assertEquals(genderRowSecondTdValueText, "Other");
//
//        WebElement mobileRow = getRows.get(3);
//        String mobileRowSecondTdValueText = mobileRow.findElement(By.xpath("./td[2]")).getText();
//
//        Assert.assertEquals(mobileRowSecondTdValueText, "0748549322");
//
//        WebElement dateOfBirthdayRow = getRows.get(4);
//        String dateOfBirthdayRowSecondTdValueText = dateOfBirthdayRow.findElement(By.xpath("./td[2]")).getText();
//
//        Assert.assertEquals(dateOfBirthdayRowSecondTdValueText, "25 February,2025");
//
//        WebElement subjectsRow = getRows.get(5);
//        String subjectsRowSecondTdValueText = subjectsRow.findElement(By.xpath("./td[2]")).getText();
//
//        Assert.assertEquals(subjectsRowSecondTdValueText, "Social Studies");
//
//        WebElement hobbiesRow = getRows.get(6);
//        String hobbiesRowSecondTdValueText = hobbiesRow.findElement(By.xpath("./td[2]")).getText();
//
//        Assert.assertEquals(hobbiesRowSecondTdValueText, "Reading");
//
//
//        WebElement stateRow = getRows.get(9);
//        String stateRowSecondTdValueText = stateRow.findElement(By.xpath("./td[2]")).getText();
//
//        Assert.assertEquals(stateRowSecondTdValueText, "NCR Delhi");

    }
}