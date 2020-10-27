package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.*;

public class Sample3Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void assertEqualsTask() throws Exception {
//         TODO:
//         check how many element with class "test" there are on page (5)
//         check that value of second button is "This is also a button"

        int expectedNumberOfElements = 5;
        int actualNumberOfElements = driver.findElements(By.className("randomButton2")).size();
        assertEquals(expectedNumberOfElements, actualNumberOfElements);
    }

    @Test
    public void assertTrueTask() throws Exception {
//         TODO:
//         check that it is True that value of second button is
//         "this is Also a Button" if you ignore Caps Locks
//         fail with custom error message:
        String elementTextOnPage = driver.findElement(By.cssSelector("randomButton2")).getText();
        assertTrue(elementTextOnPage.equals("This is also a button"));
//        assertTrue("Expecting the element with class 'unbelievable' to have text 'ajshdka'", elementTextOnPage.contains("ajshdka"));
        assertTrue(elementTextOnPage.equalsIgnoreCase("This is ALso a buTTon"));
        // pass:
        assertTrue(true);
        // fail:
//        assertTrue(false);

    }

    @Test
    public void assertFalseTask() throws Exception {
//         TODO:
//        check that it is False that value of second button is "This is a button"
        String elementTextOnPage = driver.findElement(By.cssSelector("randomButton2")).getText();
        assertFalse(!elementTextOnPage.equals("This is also a button"));
        assertFalse(elementTextOnPage.equals("wrong text"));
        assertFalse(elementTextOnPage.contains("wrong text"));
        // fail:
//        assertFalse(true);
        // pass:
        assertFalse(false);
    }

    @Test
    public void failTask() throws Exception {
//        TODO:
//        check that none of items with class "test"
//        contain number 190
        String elementTextOnPage = driver.findElement(By.cssSelector("test")).getText();
        assertFalse(!elementTextOnPage.equals("190"));
        assertFalse(elementTextOnPage.equals("wrong text"));
        assertFalse(elementTextOnPage.contains("wrong text"));
        // fail:
//        assertFalse(true);
        // pass:
        assertFalse(false);
    }
}
