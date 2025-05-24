import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class TestScriptsExecution {
    WebDriver driver = new ChromeDriver();

    @Test
    public void signupInvoke() throws InterruptedException {
        driver.get("http://192.168.1.193:3001/en/sign-up");
        FunctionsImplementation instance = new FunctionsImplementation(driver);
        instance.initialize(driver);
        instance.validationFields();
        instance.signUp();
        instance.otpSend();
        Thread.sleep(2000);
        instance.login();
        instance.passwordRecovery();

    }

}
