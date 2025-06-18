import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class TestScriptsExecution {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    FunctionsImplementation instance = new FunctionsImplementation(driver);

    public void navigateHome(){
        driver.get("https://investment.aqaryservices.com/en");

    }
    @Test
    public void signupInvoke() throws InterruptedException {
        driver.get("https://investment.aqaryservices.com/en/sign-up");
        instance.initialize(driver);
        instance.validationFields();
        instance.signUp();
        instance.otpSend();
        Thread.sleep(2000);
        instance.login();
        instance.passwordRecovery();

    }
@Test
    public void landingpageSearchfeature() throws InterruptedException {

        navigateHome();
        instance.initialize(driver);
        instance.landingPageSearch();
    }
@Test
    public void contactUs() throws InterruptedException {
        navigateHome();
        instance.initialize(driver);
        instance.contactUs();

    }
    @Test
    public void SaveListing() throws InterruptedException {
        navigateHome();
        instance.initialize(driver);
        instance.saveListing();
        instance.verifysavedListing();
        instance.unsaveListing();
    }

    @Test
    public void aboutUs() throws InterruptedException {
        navigateHome();
        instance.initialize(driver);
        instance.about();

    }
}
