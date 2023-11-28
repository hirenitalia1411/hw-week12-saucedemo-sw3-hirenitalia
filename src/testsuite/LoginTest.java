package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {

    static String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // * Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        // * Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        // * Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        // * Verify the text “PRODUCTS”
        verifyTheStringMessage(By.xpath("//span[@class='title']"), "Products");
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() throws InterruptedException {
        // * Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        // * Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        // * Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        // * Verify that six products are displayed on page
        Thread.sleep(2000);
        countAndVerifyNumberOfProductOnPage(By.xpath("//div[@class='inventory_item']"), 6);
    }

    public void countAndVerifyNumberOfProductOnPage(By by, int actualProduct){
        List<WebElement> list = driver.findElements(by);
        Assert.assertEquals(list.size(), actualProduct);
    }
    @After
    public void tearDown() {
        //  closeBrowser();
    }
}
