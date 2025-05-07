package Pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormPage {

    WebDriver driver;
    ElementsMethods elementsMethods;
    JavascriptHelpers javascriptHelpers;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.javascriptHelpers = new JavascriptHelpers(driver);
        PageFactory.initElements(driver, this);


    }

    @FindBy(id = "firstName")
    WebElement firstNameElement;

    @FindBy(id = "lastName")
    WebElement lastNameElement;

    @FindBy(id = "userEmail")
    WebElement emailElement;

    @FindBy(css = "input[placeholder='Mobile Number']")
    WebElement mobileNumberElement;

    @FindBy(id = "uploadPicture")
    WebElement uploadPictureElement;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement maleGenderElement;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement femaleGenderElement;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement otherGenderElement;

    @FindBy(id = "currentAddress")
    WebElement currentAddressElement;

    @FindBy(id = "react-select-3-input")
    WebElement stateElement;

    @FindBy(id = "react-select-4-input")
    WebElement cityElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement sportsElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement readingElement;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement musicElement;

    @FindBy(xpath = "//div[@id='subjectsContainer']")
    WebElement subjectsElement;

//    @FindBy(id = "subjectsInput")
//    WebElement subjectsElement;

    public void completeFirstRegion(String firstName, String lastName, String email, String address, String mobileNo) {
        elementsMethods.fillElement(firstNameElement, firstName);
        elementsMethods.fillElement(lastNameElement, lastName);
        elementsMethods.fillElement(emailElement, email);
        elementsMethods.fillElement(currentAddressElement, address);
        elementsMethods.fillElement(mobileNumberElement, mobileNo);

    }

    public void completeGender(String gender) {
        switch (gender) {
            case "Male":
                elementsMethods.clickOnElement(maleGenderElement);
                break;
            case "Female":
                elementsMethods.clickOnElement(femaleGenderElement);
                break;
            case "Other":
                elementsMethods.clickOnElement(otherGenderElement);
                break;
        }

    }

    public void completeSubject(String subject) {
        elementsMethods.clickOnElement(subjectsElement);
        elementsMethods.fillWithActions(subjectsElement, subject);
    }

    public void completeSubjectWithList(List<String> list) {
        elementsMethods.fillMultipleValues(subjectsElement, list);


    }
    public void completeHobbies(List<String> hobbies){
        List<WebElement> hobbiesElement = new ArrayList<>();
                hobbiesElement.add(sportsElement);
                hobbiesElement.add(readingElement);
                hobbiesElement.add(musicElement);
                elementsMethods.clickMultipleValue(hobbiesElement ,hobbies);

    }

}
