package HelperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

public class ElementsMethods {
    WebDriver driver;

    public ElementsMethods(WebDriver driver) {
        this.driver = driver;
    }

       public void clickOnElement(WebElement element){

        element.click();
    }
        public void fillElement(WebElement element, String value){
        element.sendKeys(value);

    }
    public void uploadPicture(WebElement element){
        File file = new File("src/test/resources/1.jpeg");
        element.sendKeys(file.getAbsolutePath());
    }


    public void selectElementFromListByText(List<WebElement> elementsList,String value){
        for(int i =0; i <elementsList.size();i++){
            if(elementsList.get(i).getText().equals(value)){
                clickOnElement(elementsList.get(i));
                break;
            }

        }

//    public void fillMultipleValues(WebElement element,List<String>values){
//            for (String value : values){
//                for (WebElement element:elements){
//                    if (element.getText().equals(value)){
//                        element.click();
//                    }
//                }
//            }
//
//        }

    }
    public void displayContentOfElement(WebElement element){
        System.out.println("Textul din element este:" + element.getText());
    }

}
