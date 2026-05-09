package website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import website.core.driver.DriverManager;

import static website.utils.DriverUtils.sleep;

public class ThankYouPage {
    By thankYouText = By.xpath("//p[contains(text(),'Thanks for signing up')]");
    By thankYouContactForm = By.xpath("//p[contains(text(),'Thank you for contacting')]");
    WebDriver driver;

    public ThankYouPage() {
        driver = DriverManager.get();
    }

    public boolean isThankYouPageDisplayed() {
        sleep(3);
        return driver.findElement(thankYouText).isDisplayed();
    }
    public boolean isThankYouContactFormDisplayed() {
        sleep(3);
        return driver.findElement(thankYouContactForm).isDisplayed();
    }
}
