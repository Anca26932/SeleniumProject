package Pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JavascriptHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends CommonPage {

//    WebDriver driver;
//    ElementsMethods elementsMethods;
//    JavascriptHelpers javascriptHelpers;
//
//    public HomePage(WebDriver driver) {
//        this.driver = driver;
//        this.elementsMethods = new ElementsMethods(driver);
//        this.javascriptHelpers = new JavascriptHelpers(driver);
//        PageFactory.initElements(driver,this);
//    }
    // Identificam web elementele specifice pentru pagina

    @FindBy(xpath = "//h5")
    List<WebElement> elementsField;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Metode specifice pentru pagina
    public void goToDesiredMenu(String menu){
        javascriptHelpers.scrollDown(400);
        elementsMethods.selectElementFromListByText(elementsField,menu);
    }

}
