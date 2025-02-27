package SitesPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HomePageAirBnb {

    public WebDriver driver;

    @Test
    public void selectAndValidateMenu () {


        driver = new ChromeDriver();
        driver.get("https://www.airbnb.ie");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid=\"main-cookies-banner-container\"]")));


        List<WebElement> cookiesButton = driver.findElements(By.cssSelector("[data-testid=\"main-cookies-banner-container\"] button"));
        for (WebElement button : cookiesButton) {
            if (button.getText().equals("Accept all")) {
                button.click();
                break;
            }
        }
        //Wait for the cookies popup to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[data-testid=\"main-cookies-banner-container\"]")));
        Assert.assertTrue(driver.findElements(By.cssSelector("[data-testid=\"main-cookies-banner-container\"]")).isEmpty());

        // Locate the categories description bar
        WebElement airbnbCategoriesCarousel = driver.findElement(By.cssSelector("[data-testid=\"content-scroller\"]"));

        // Get the list of categories
        List<WebElement> airbnbCategoriesButtons = airbnbCategoriesCarousel.findElements(
                By.cssSelector("#category-bar-description + div + div label"));
        Assert.assertEquals(airbnbCategoriesButtons.size(), 62, "The count does not match the expected value");

        // Print the list of categories
        for (WebElement category : airbnbCategoriesButtons) {
            System.out.println(category.getText());

            if (category.getText().equals("Countryside")) {
                category.click();
                break;
            }
        }

        Assert.assertTrue(driver.findElement(By.cssSelector("[data-testid=\"category-item--Countryside--checked\"]")).isDisplayed());

    }


}

