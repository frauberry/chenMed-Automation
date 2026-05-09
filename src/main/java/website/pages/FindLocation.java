package website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import website.core.driver.DriverManager;

import static website.utils.DriverUtils.sleep;

public class FindLocation {
    By zipcodeField = By.xpath("//input[@placeholder='zip code']");
    By searchButton = By.id("search-button");
    By zipcodeResult = By.xpath("//div[contains(@class,'results')]//address[contains(.,'33317')]");
    WebDriver driver;

    public FindLocation() { driver = DriverManager.get(); }

    public void fillOutZipcode() {
        driver.findElement(zipcodeField).sendKeys("33317");
        sleep(1);
        driver.findElement(searchButton).click();
    }
    public boolean isZipcodeDisplayed() {
        sleep(1);
        return driver.findElement(zipcodeResult).isDisplayed();
    }

}
