package website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import website.core.driver.DriverManager;

import static website.utils.DriverUtils.sleep;

public class HomePage {
    By forPatients = By.id("for-patients-tab");
    By findButton = By.xpath("//a[text()=' Find a Senior Center Near You ']");
    WebDriver driver;

    public HomePage() { driver = DriverManager.get(); }

    public void findCenter() {
        driver.findElement(forPatients).click();
        sleep(1);
        driver.findElement(findButton).click();
    }
}
