package website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import website.core.driver.DriverManager;

public class Subscribe {
    By firstName = By.xpath("//input[@aria-label='First Name']");
    By lastName = By.xpath("//input[@aria-label='Last Name']");
    By email = By.xpath("//input[@type='email']");
    By areaOfProfession = By.xpath("//label[text()='Area of Profession']/following-sibling::select");
    By areaOfProfessionOption = By.xpath("//label[text()='Area of Profession']/following-sibling::select/option[text()='Education']");
    By featureContent = By.xpath("//input[@value='Featured Content & Articles']");
    By announcements = By.xpath("//input[@value='Announcements & News Updates']");
    By careerOpportunities = By.xpath("//input[@value='Career Opportunities']");
    By submitButton = By.xpath("//input[@value='Subscribe']");
    WebDriver driver;

    public Subscribe() {
        driver = DriverManager.get();
    }

    public void fillOutForm() {
        driver.findElement(firstName).sendKeys("Stasya");
        driver.findElement(lastName).sendKeys("Test");
        driver.findElement(email).sendKeys("stasya345@yopmail.com");
        driver.findElement(areaOfProfession).click();
        driver.findElement(areaOfProfessionOption).click();
        driver.findElement(featureContent).click();
        driver.findElement(announcements).click();
        driver.findElement(careerOpportunities).click();
        driver.findElement(submitButton).click();
    }
}
