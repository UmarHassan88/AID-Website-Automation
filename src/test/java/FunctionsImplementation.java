import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Random;
import java.util.UUID;

public class FunctionsImplementation extends InternalFunctionsLogic{

    public FunctionsImplementation(WebDriver driver) {
        super(driver);
    }
    Random rand = new Random();
    int randomNum = rand.nextInt(200) + 10;
    int randomphone = rand.nextInt(89) + 10;
    String email = "umarhassanzia88+test5@gmail.com";
    String phoneNum = "5065676" + randomphone;

    public void signUp() throws InterruptedException {
        //Assertions for Validation Texts of all the Mandatory Fields
        invalidEmail("Umar");
        Thread.sleep(2000);
        validEmail(email);
        invalidContactnum("732783");
        Thread.sleep(2000);
        validContactnum(phoneNum);
        userName();
        smallpasswordCreation();
        weakpasswordCreation();
        passwordMismatch();
        correctPassword();
        softassertion.assertAll();
        //Submit
        submitButton.click();
    }

    public void otpSend() throws InterruptedException {
    IncorrectOTP();
    ResendOTP();

    }

    public void login() throws InterruptedException {
        System.out.println("Login Page Invoked!");
        invalidloginUser("abc", "123");
        incorrectloginUser(email,"Aqary");
        incorrectloginUser("abc@gmail.com", "Aqary@88");
        validloginUser(email, "Aqary@88");

    }
}
