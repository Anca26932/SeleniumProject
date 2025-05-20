package Tests;

import Pages.CommonPage;
import Pages.HomePage;
import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class Recursivitate extends ShareData {

    HomePage homePage;
    CommonPage commonPage;


    @Test
    public void parcurgereLista() {

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        homePage.goToDesiredMenu("Interactions");
        commonPage.goToDesiredSubMenu("Sortable");

//    Declaram elemente prin Drag and Drop
        Actions actions = new Actions(getDriver());
        String listElementsxPath = "//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']";
        List<WebElement> list = getDriver().findElements(By.xpath("//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']"));
        for (int i = 0; i < list.size(); i++) {

            WebElement webElement = list.get(i);
            WebElement urmatorulElement = list.get(i++);
            System.out.println("Numarul elementului este " + webElement.getText());

            actions.clickAndHold(webElement)
                    .moveToElement(urmatorulElement)
                    .release()
                    .build()
                    .perform();
        }
//        try {
//            Thread.sleep(1000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//    }
    }
}
