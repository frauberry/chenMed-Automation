package ui.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.BaseUiTest;
import website.core.driver.DriverManager;
import website.pages.*;
import website.utils.Log;

public class SmokeTest extends BaseUiTest {

    @Test
    public void subscribeTest() {
        WebDriver driver = DriverManager.get();
        driver.get("https://www.chenmed.com/subscribe");
        Subscribe subscribe = new Subscribe();
        subscribe.fillOutForm();

        ThankYouPage thankYouPage = new ThankYouPage();
        thankYouPage.isThankYouPageDisplayed();
    }
    @Test
    public void findLocationTest() {
        WebDriver driver = DriverManager.get();
        driver.get("https://www.chenmed.com");
        HomePage homePage = new HomePage();
        homePage.findCenter();

        FindLocation findLocation = new FindLocation();
        findLocation.fillOutZipcode();
        Assert.assertTrue(findLocation.isZipcodeDisplayed());
    }
    @Test
    public void fillOutContactFormTest() {
        WebDriver driver = DriverManager.get();
        driver.get("https://www.chenmed.com/about-us/contact");
        ContactPage contactPage = new ContactPage();
        contactPage.fillOutForm();

        ThankYouPage thankYouPage = new ThankYouPage();
        Assert.assertTrue(thankYouPage.isThankYouContactFormDisplayed());
    }
    @Test
    public void emptyFormSubmissionTest() {
        WebDriver driver = DriverManager.get();
        driver.get("https://www.chenmed.com/about-us/contact");
        ContactPage contactPage = new ContactPage();
        contactPage.submitForm();

        Assert.assertTrue(contactPage.isInlineErrorMessageDisplayed());
    }
    @Test
    public void patientStoriesCarouselTest() {
        WebDriver driver = DriverManager.get();
        driver.get("https://www.chenmed.com/");
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.areAllSegmentsDisplayed());
        Log.info("Patient Stories Carousel Test Passed");
    }
}
