package HelperMethods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class ElementsMethods {
    WebDriver driver;

    Actions actions;

    public ElementsMethods(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);

    }

    public void clickOnElement(WebElement element) {

        element.click();
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void clickOnElementWithKeyboard(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

    public void fillElement(WebElement element, String value) {
        element.sendKeys(value);

    }

    public void printText(WebElement webElement) {
        System.out.println("Textul este" + webElement.getText());
    }

    public void uploadPicture(WebElement element) {
        File file = new File("src/test/resources/1.jpeg");
        element.sendKeys(file.getAbsolutePath());

    }


    public void selectElementFromListByText(List<WebElement> elementsList, String value) {
        for (int i = 0; i < elementsList.size(); i++) {
            if (elementsList.get(i).getText().equals(value)) {
                clickOnElement(elementsList.get(i));
                break;
            }

        }

//        public void checkTableSize(List<WebElement> list1, List<WebElement> list2){
//            Integer actualTableSize =list1.size();
//        }
    }

    public void fillMultipleValues(WebElement webElement, List<String> list) {
        for (String value : list) {
            webElement.sendKeys(value);
            webElement.sendKeys(Keys.ENTER);
        }

    }

    public void displayContentOfElement(WebElement element) {
        System.out.println("Textul din element este:" + element.getText());
    }

    public void fillWithActions(WebElement webElement, String value) {
        actions.sendKeys(value).perform();
        waitForVisibilityElement(webElement);
        actions.sendKeys(Keys.ENTER).perform();

    }

    public void waitForVisibilityElement(WebElement webElement) {
//        Definim un wait explicit ca sa astepte dupa alerta
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement));

    }
    public void clickMultipleValue(List<WebElement> webElements ,List<String>list){
        for (String value: list){
            for (WebElement webElement: webElements){
                if(webElement.getText().equals(value)){
                    webElement.click();
                }
            }
        }
    }


}

