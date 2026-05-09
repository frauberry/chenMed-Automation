package ui;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import website.core.driver.DriverManager;

public abstract class BaseUiTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser, @Optional("false") boolean headless) {
        DriverManager.start(browser, headless);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.stop();
    }
}
