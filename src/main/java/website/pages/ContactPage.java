package website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import website.core.driver.DriverManager;

public class ContactPage {
    By firstName = By.xpath("//input[@aria-label='First Name']");
    By lastName = By.xpath("//input[@aria-label='Last Name']");
    By phone = By.xpath("//input[@type='tel']");
    By email = By.xpath("//input[@type='email']");
    By city = By.xpath("//input[@aria-label='City']");
    By state = By.xpath("//select[@aria-label='State']");
    By stateOption = By.xpath("//select[@aria-label='State']/option[text()='Florida']");
    By moreInformation = By.xpath("//option[contains(text(),'Business')]/parent::select");
    By informationOption = By.xpath("//option[contains(text(),'HR')]/parent::select");
    By message = By.xpath("//label[text()='Message']/parent::div/textarea");
    By contactUsButton = By.xpath("//input[@type='submit']");
    By inlineErrorMessage = By.xpath("//div[contains(text(),'Please fill')]");
    WebDriver driver;

    public ContactPage() {
        driver = DriverManager.get();
    }
    public void fillOutForm() {
        driver.findElement(firstName).sendKeys("Luka");
        driver.findElement(lastName).sendKeys("Test");
        driver.findElement(phone).sendKeys("(786)567-7867");
        driver.findElement(email).sendKeys("luka@test.com");
        driver.findElement(city).sendKeys("Dania");
        driver.findElement(state).click();
        driver.findElement(stateOption).click();
        driver.findElement(moreInformation).click();
        driver.findElement(informationOption).click();
        driver.findElement(message).sendKeys("Test");
        submitForm();
    }
    public void submitForm() {
        driver.findElement(contactUsButton).click();
    }
    public boolean isInlineErrorMessageDisplayed() {
        return driver.findElement(inlineErrorMessage).isDisplayed();
    }
}
