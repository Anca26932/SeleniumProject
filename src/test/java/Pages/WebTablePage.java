package Pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablePage extends CommonPage {

//    WebDriver driver;
//    ElementsMethods elementsMethods;
//    JavascriptHelpers javascriptHelpers;
//    Actions actions;
//
//    public WebTablePage(WebDriver driver) {
//        this.driver = driver;
//        this.elementsMethods = new ElementsMethods(driver);
//        this.javascriptHelpers = new JavascriptHelpers(driver);
//        this.actions = new Actions(driver);
//        PageFactory.initElements(driver,this);
//    }
    @FindBy(id="addNewRecordButton")
    WebElement addNewRecoordButton;

    @FindBy(id="firstName")
    WebElement firstNamefield;

    @FindBy(id="lastName")
    WebElement lastNamefield;

    @FindBy(id="userEmail")
    WebElement emailField;

    @FindBy(id="age")
    WebElement ageField;
    @FindBy(id="salary")
    WebElement salaryfield;
    @FindBy(id="department")
    WebElement departmentField;
    @FindBy(id="submit")
    WebElement submitField;


    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    public void fillTable(String fName, String lName,String email ,String age, String salary, String department){
        elementsMethods.clickOnElement(addNewRecoordButton);

        elementsMethods.fillElement(firstNamefield, fName);
        elementsMethods.fillElement(lastNamefield, lName);
        elementsMethods.fillElement(emailField, email);
        elementsMethods.fillElement(ageField, age);
        elementsMethods.fillElement(salaryfield, salary);
        elementsMethods.clickOnElement(submitField);
    }
}
