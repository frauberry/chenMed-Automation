package website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import website.core.driver.DriverManager;
import website.utils.Log;

import static website.utils.DriverUtils.scrollDownToElement;
import static website.utils.DriverUtils.sleep;

public class HomePage {
    By forPatients = By.id("for-patients-tab");
    By findButton = By.xpath("//a[text()=' Find a Senior Center Near You ']");
    By rightArrow = By.xpath("//span[text()='Next']/parent::a");
    By carouselSecondText = By.xpath("//div[contains(@class,'active')]//blockquote[contains(text(),'My doctor…')]");
    By carouselThirdText = By.xpath("//div[contains(@class,'active')]//blockquote[contains(text(),'I feel')]");
    By carouselForthText = By.xpath("//div[contains(@class,'active')]//blockquote[contains(text(),'When I came')]");
    By carouselFirstText = By.xpath("//div[contains(@class,'active')]//blockquote[contains(text(),'My doctor is')]");
    WebDriver driver;

    public HomePage() {
        driver = DriverManager.get();
        System.out.println("Navigated to Homepage");
        Log.info("Navigated to Homepage");
    }

    public void findCenter() {
        driver.findElement(forPatients).click();
        sleep(1);
        driver.findElement(findButton).click();
    }
    public void moveCarouselToRight() {
        scrollDownToElement(rightArrow);
        sleep(2);
        driver.findElement(rightArrow).click();
        Log.info("carousel moved to the right");
    }
    public boolean isSecondSegmentDisplayed() {
        sleep(1);
        return driver.findElement(carouselSecondText).isDisplayed();
    }
    public boolean isThirdSegmentDisplayed() {
        sleep(1);
        return driver.findElement(carouselThirdText).isDisplayed();
    }
    public boolean isForthSegmentDisplayed() {
        sleep(1);
        return driver.findElement(carouselForthText).isDisplayed();
    }
    public boolean isFirstSegmentDisplayed() {
        sleep(1);
        return driver.findElement(carouselFirstText).isDisplayed();
    }
    public boolean areAllSegmentsDisplayed() {
        moveCarouselToRight();
        if (!isSecondSegmentDisplayed()) {
            return false;
        }
        Log.info("Second segment displayed");
        moveCarouselToRight();
        if (!isThirdSegmentDisplayed()) {
            return false;
        }
        Log.info("Third segment displayed");
        moveCarouselToRight();
        if (!isForthSegmentDisplayed()) {
            return false;
        }
        Log.info("Forth segment displayed");
        moveCarouselToRight();
        if (!isFirstSegmentDisplayed()) {
            return false;
        }
        Log.info("First segment displayed");
        return true;
    }
}
