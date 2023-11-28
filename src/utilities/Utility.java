package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {

    //****************************** Click Send & Get *******************************************//

    /**
     * This method will click on element
     */
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }

    /**
     * This method will send text on element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will get text from element
     */
    public String  getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    //******************************** Action Class ********************************************//

    /**
     * This method will mouse hover on the element
     */
    public void mouseHoverOnElement(By by) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    /**
     * This method will mouse hover and click on the element
     */
    public void mouseHoverOnElementAndClick(By by) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    //******************************** Select Class ********************************************//

    /**
     * This method will select the element from drop-down by VALUE
     */
    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    /**
     * This method will select the element from drop-down by VISIBLE TEXT
     */
    public void selectByVisibleTextFromDropDown(By by, String value) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(value);
    }

    /**
     * This method will select the element from drop-down by INDEX
     */
    public void selectByIndexFromDropDown(By by, int value) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByIndex(value);
    }

    //******************************** DropDown Menu Without Select Tag ********************************************//

    /**
     * This method will select the element from drop-down which does not have SELECT tag
     */
    public void dropDownWithList(By by, String option) {
        List<WebElement> list = driver.findElements(by);
        for (WebElement e: list) {
            if(e.getText().equalsIgnoreCase(option)) {
                e.click();
                break;
            }
        }
    }

    //**************************** Asceding and Descending order ***********************************************//

    /**
     * This method will verify whether the elements are in DESCENDING ORDER or not
     */
    public boolean verifyTheListIsDescendingOrder(By by) {
        List<WebElement> list = driver.findElements(by);

        boolean isDecending = false;

        for (int i = 0; i < list.size()-1; i++) {
            System.out.println(list.get(i).getText());
            if (list.get(i).getText().compareTo(list.get(i + 1).getText()) < 0) {
                isDecending=true;
            }
        }
        return isDecending;
    }

    /**
     * This method will verify whether the elements are in ASCENDING ORDER or not
     */
    public boolean verifyTheListIsAscedingOrder(By by) {
        List<WebElement> list = driver.findElements(by);

        boolean isAsceding = false;

        for (int i = 0; i < list.size()-1; i++) {
            // System.out.println(list.get(i).getText());
            if (list.get(i).getText().compareTo(list.get(i + 1).getText()) > 0) {
                isAsceding=true;
            }
        }
        return isAsceding;
    }

    //********************************* Relative Locator *************************************//

    /**
     * This method will find the ABOVE element with reference to the given locator
     */
    public void findToAboveofElement(By exactLocation, By referenceLocation){
        driver.findElement(RelativeLocator.with(exactLocation).above(referenceLocation));
    }

    /**
     * This method will find the BELOW element with reference to the given locator
     */
    public void findToBelowofElement(By exactLocation, By referenceLocation){
        driver.findElement(RelativeLocator.with(exactLocation).below(referenceLocation));
    }

    /**
     * This method will find the NEAR element with reference to the given locator
     */
    public void findToNearofElement(By exactLocation, By referenceLocation){
        driver.findElement(RelativeLocator.with(exactLocation).near(referenceLocation));
    }

    /**
     * This method will find the RIGHT SIDE element with reference to the given locator
     */
    public void findToRightOfElement(By exactLocation, By referenceLocation){
        driver.findElement(RelativeLocator.with(exactLocation).toRightOf(referenceLocation));
    }

    /**
     * This method will find the LEFT SIDE element with reference to the given locator
     */
    public void findToLeftOfElement(By exactLocation, By referenceLocation){
        driver.findElement(RelativeLocator.with(exactLocation).toLeftOf(referenceLocation));
    }


    //************************ Verify the Message & Number of Product **********************************//

    /**
     * This method will verify the two text from the elements
     */
    public void verifyTheStringMessage(By by, String actualMessage) {
        String expected = getTextFromElement(by);
        String expectedString = expected.substring(0, actualMessage.length());
        Assert.assertEquals(expectedString, actualMessage);
    }

    public void countAndVerifyNumberOfProductOnPage(By by, int actualProduct){
        List<WebElement> list = driver.findElements(by);
        Assert.assertEquals(list.size(), actualProduct);
    }

}