import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.security.Key;
import java.time.Duration;
import java.util.Random;

public class InternalFunctionsLogic {
    WebDriver driver;
    WebDriverWait wait;
    SoftAssert softassertion = new SoftAssert();


    public InternalFunctionsLogic(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ safe here

    }

    public void initialize(WebDriver driver){
        PageFactory.initElements(driver, this);
    }



    public WebElement waitDriver(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void clearFields(WebElement elem1, WebElement elem2){
        elem1.sendKeys(Keys.CONTROL + "a");
        elem1.sendKeys(Keys.BACK_SPACE);
        elem2.sendKeys(Keys.CONTROL + "a");
        elem2.sendKeys(Keys.BACK_SPACE);
    }
    public void clearsingleField(WebElement elem1){
        elem1.sendKeys(Keys.CONTROL + "a");
        elem1.sendKeys(Keys.BACK_SPACE);

    }
    @FindBy(name = "email")
    WebElement email;
    @FindBy(name = "phoneNumber")
    WebElement contactNo;
    @FindBy(name = "username")
    WebElement userName;
    @FindBy(name = "firstName")
    WebElement firstName;
    @FindBy(name = "lastName")
    WebElement lastName;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(name = "confirmpassword")
    WebElement confirmPassword;
    @FindBy(xpath = "/html/body/div[1]/div/form/button")
    WebElement submitButton;

    public void validationFields() throws InterruptedException {
        //SIGNUP TEXT
        driver.findElement(By.xpath("/html/body/div[1]/div/form/button")).click();
        softassertion.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div/form/p")).getText(), "Sign Up");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\":Rkil5uutdfb:-helper-text\"]")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\":Rkml5uutdfb:-helper-text\"]")).getText(), "Phone number is required");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\":Rkql5uutdfb:-helper-text\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\":Racul5uutdfb:-helper-text\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\":Rl2l5uutdfb:-helper-text\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\":Rl6l5uutdfb:-helper-text\"]\n")).isDisplayed());
        Thread.sleep(2000);
    }

    public void invalidEmail(String em) throws InterruptedException {
        System.out.print("Sending the Invalid Email Address...");
        email.sendKeys(em);
        softassertion.assertTrue(driver.findElement(By.xpath("//*[@id=\":Rkil5uutdfb:-helper-text\"]")).isDisplayed());
        Thread.sleep(2000);
        email.sendKeys(Keys.CONTROL + "a");
        email.sendKeys(Keys.BACK_SPACE);
    }
    public void validEmail(String em) throws InterruptedException {
        System.out.print("\nSending the Valid Email Address...");
        email.sendKeys(em);
        Thread.sleep(2000);
    }

    public void invalidContactnum(String phone) throws InterruptedException {
        System.out.print("\nSending the Invalid Contact Number...");
        contactNo.sendKeys(String.valueOf(phone));
        softassertion.assertTrue(driver.findElement(By.xpath("//*[@id=\":Rkml5uutdfb:-helper-text\"]")).isDisplayed());
        Thread.sleep(2000);
        clearsingleField(contactNo);

    }
    public void validContactnum(String phone){
        System.out.print("\nSending the Valid Contact Number...");
        contactNo.sendKeys(String.valueOf(phone));

    }
    public void userName(){
        //USER NAME lOGIC
        System.out.print("\nSending the User Name...");
        String characters = "abcdefghgijklmnopqrstuvwxyz";
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for(int i = 0;i<6;i++){
            stringBuilder.append(characters.charAt(random.nextInt(characters.length())));
        }
        userName.sendKeys(stringBuilder.toString());
        firstName.sendKeys(stringBuilder.toString());
        lastName.sendKeys(stringBuilder.toString());
    }

    public void smallpasswordCreation() throws InterruptedException {
        System.out.print("\nSign Up Password Validations...");
        System.out.print("\nSending the Small Password and Confirm Password...");
        String createPassword = "Aqary";
        password.sendKeys(createPassword);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\":Rl2l5uutdfb:-helper-text\"]")).getText(), "Password must be at least 8 characters long");
        confirmPassword.sendKeys(createPassword);
        Thread.sleep(2000);
        clearFields(password,confirmPassword);

    }
    public void weakpasswordCreation() throws InterruptedException {
        System.out.print("\nSending the Weak Password and Confirm Password...");
        String createPassword = "AqaryInt12";
        password.sendKeys(createPassword);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\":Rl2l5uutdfb:-helper-text\"]")).isDisplayed());
        confirmPassword.sendKeys(createPassword);
        Thread.sleep(2000);
        clearFields(password,confirmPassword);
    }
    public void passwordMismatch() throws InterruptedException {
        System.out.print("\nSending the Mismatched Password and Confirm Password...");
        String createPassword = "Aqary@88";
        password.sendKeys(createPassword);
        confirmPassword.sendKeys("Aqary88");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\":Rl6l5uutdfb:-helper-text\"]")).isDisplayed());
        Thread.sleep(2000);
        clearFields(password,confirmPassword);

    }
    public void correctPassword() throws InterruptedException {
        System.out.print("\nSending the Correct Password and Confirm Password...");
        String createPassword = "Aqary@88";
        password.sendKeys(createPassword);
        confirmPassword.sendKeys(createPassword);
        Thread.sleep(2000);

    }

    @FindBy(xpath = "/html/body/div[1]/div/form/div/div[2]/div[2]/div[1]/input")
    WebElement firstDigit;
    @FindBy(xpath = "/html/body/div[1]/div/form/div/div[2]/div[2]/div[2]/input")
    WebElement secondDigit;
    @FindBy(xpath = "/html/body/div[1]/div/form/div/div[2]/div[2]/div[3]/input")
    WebElement thirdDigit;
    @FindBy(xpath = "/html/body/div[1]/div/form/div/div[2]/div[2]/div[4]/input")
    WebElement fourthDigit;
    @FindBy(xpath = "/html/body/div[1]/div/form/div/div[2]/div[2]/div[5]/input")
    WebElement fifthDigit;
    @FindBy(xpath = "/html/body/div[1]/div/form/div/div[2]/div[2]/div[6]/input")
    WebElement sixthDigit;

    @FindBy(xpath = "/html/body/div[1]/div/form/div/div[2]/div[3]/button")
    WebElement resend1;
    @FindBy(xpath = "/html/body/div[1]/div/form/div/div[2]/div[2]/button")
    WebElement resend2;
    @FindBy(xpath = "/html/body/div[1]/div/form/button[2]")
    WebElement submit;


    public void IncorrectOTP() throws InterruptedException {
        Thread.sleep(2000);
        firstDigit.sendKeys("1");
        secondDigit.sendKeys("1");
        thirdDigit.sendKeys("1");
        fourthDigit.sendKeys("1");
        fifthDigit.sendKeys("1");
        sixthDigit.sendKeys("1");
        submit.click();
        //Alert pop up
        //Assert.assertTrue(driver.findElement(By.xpath("/div/div")).isDisplayed());
}
    public void ResendOTP() throws InterruptedException {
        Assert.assertEquals(resend1.getText(), "Resend");
        Thread.sleep(70000);
        System.out.println("\nBefore clicking Resend...");
        resend2.click();
        System.out.println("Resend Clicked!");
        Thread.sleep(35000);
        submit.click();

    }

    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement pass;

    @FindBy(xpath = "/html/body/div[1]/div/form/button")
    WebElement button;

    public void invalidloginUser(String user, String password) throws InterruptedException {
        System.out.println("\nLogin Page Invoked!");
        System.out.println("\nInvalid Login Page Condition Invoked!");

        username.sendKeys(user);
        softassertion.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div/form/div[1]/div/p")).isDisplayed());
        pass.sendKeys(password);
        softassertion.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div/form/div[2]/div/p")).isDisplayed());
        Thread.sleep(2000);
        clearFields(username,pass);
        Thread.sleep(2000);
    }
    //Incorrect Credentials
    public void incorrectloginUser(String user, String password) throws InterruptedException {
        System.out.println("Sending the Incorrect Login User Credentials...");
        username.sendKeys(user);
        pass.sendKeys(password);
        button.submit();
        Thread.sleep(2000);
        clearFields(username,pass);
        }


    public void validloginUser(String user, String password) throws InterruptedException {
        System.out.println("Valid Login Page Invoked!");
        username.sendKeys(user);
        pass.sendKeys(password);
        Thread.sleep(2000);
        button.click();
        System.out.print("\nLogged in the System !");
    }

    @FindBy(linkText = "Forgot Password?")
    WebElement forgotpass;

    @FindBy(xpath = "/html/body/div[1]/div/form/div[2]/div/input")
    WebElement emailForgot;

    @FindBy(xpath = "/html/body/div[1]/div/form/button[2]")
    WebElement submitButt;

    @FindBy(xpath = "/html/body/div[1]/div/form/div/div[2]/div[1]/div/input")
    WebElement newPassword;

    @FindBy(xpath = "/html/body/div[1]/div/form/div/div[2]/div[2]/div/input")
    WebElement reenterPassword;


    public void forgotPass() throws InterruptedException {
        System.out.println("\nForgot Password Page Invoked!");
        driver.get("http://192.168.1.193:3001/en/login");
        forgotpass.click();
        Thread.sleep(2000);
        String invalidEmail = "umarhassan88+test5@gmail.com";
        String validEmail = "umarhassanzia88+test5@gmail.com";
        emailForgot.sendKeys(invalidEmail);
        submitButt.click();
        Thread.sleep(2000);

        emailForgot.sendKeys(Keys.CONTROL + "a");
        emailForgot.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(2000);

        emailForgot.sendKeys(validEmail);
        submitButt.click();

        System.out.println("Redirected to the OTP Page... ");
        Thread.sleep(25000);
        submit.click();
        System.out.println("Reset Password Page...");
        String weakPassword1 = "aqary";
        String weakPassword2 = "aqary888";
        String weakPassword3 = "Aqary888";
        String strongPassword = "Aqary@88";

        Thread.sleep(2000);
        System.out.println("Sending the Password below 8 characters...");
        newPassword.sendKeys(weakPassword1);
        reenterPassword.sendKeys(weakPassword1);
        submit.click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div/form/div/div[2]/div[1]/p")).isDisplayed());
        Thread.sleep(1500);
        clearFields(newPassword,reenterPassword);

        System.out.println("Sending the Password without Uppercase characters...");
        Thread.sleep(2000);
        newPassword.sendKeys(weakPassword2);
        reenterPassword.sendKeys(weakPassword2);
        submit.click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div/form/div/div[2]/div[1]/p")).isDisplayed());
        Thread.sleep(1500);
        clearFields(newPassword,reenterPassword);

        System.out.println("Sending the Password without Special characters...");
        Thread.sleep(2000);
        newPassword.sendKeys(weakPassword3);
        reenterPassword.sendKeys(weakPassword3);
        submit.click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div/form/div/div[2]/div[1]/p")).isDisplayed());
        Thread.sleep(1500);
        clearFields(newPassword,reenterPassword);

        Thread.sleep(1000);
        newPassword.sendKeys(strongPassword);
        Thread.sleep(2000);
        System.out.println("Checking the Password Mismatch Condition...");
        reenterPassword.sendKeys(weakPassword1);
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div/form/div/div[2]/div[2]/p")).isDisplayed());
        Thread.sleep(1500);
        clearFields(newPassword,reenterPassword);

        Thread.sleep(1500);
        System.out.println("True Condition...");
        newPassword.sendKeys(strongPassword);
        reenterPassword.sendKeys(strongPassword);
        submit.click();

        Thread.sleep(2000);
        System.out.print("\n\nRedirected to Login Page Successfully!");
        validloginUser(validEmail,strongPassword);

    }
    @FindBy(xpath = "//*[@id=\"heroSearch\"]/div/div/div[1]/div/div/button")
    WebElement section;

    @FindBy(xpath = "//*[@id=\"heroSearch\"]/div/div/div[2]/div/div/button")
    WebElement category;

    @FindBy(xpath = "/html/body/main/div[1]/div[2]/div[2]/div/div/div[3]/div/div/div/div/input")
    WebElement location;

    @FindBy(xpath = "//*[@id=\"heroSearch\"]/div/div/div[4]/div/div/button")
    WebElement propType;

    @FindBy(xpath = "//*[@id=\"heroSearch\"]/div/div/div[5]/button")
    WebElement arrowSearch;

    public void landingpageSearch(){
        System.out.print("\nLanding Page 2 Invoked!");
        driver.findElement(By.xpath("//*[@id=\"driver-popover-content\"]/button")).click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,200)");

        //Assertion for the Landing Page
        Assert.assertEquals(waitDriver(By.xpath("/html/body/main/div[3]/div[1]/div[1]")).getText(), "Sections");
        section.click();
        waitDriver(By.xpath("//*[@id=\"simple-popper\"]/div[3]/div/div/div[1]")).click();
        category.click();
        waitDriver(By.xpath("//*[@id=\"simple-popper\"]/div[3]/div/div/div[1]")).click();
        location.click();
        location.sendKeys("Abu Dhabi");
        propType.click();
        waitDriver(By.xpath("//*[@id=\"simple-popper\"]/div[3]/div/div[2]/p[3]")).click();
        waitDriver(By.xpath("//*[@id=\"simple-popper\"]/div[3]/div/div[3]/button[2]")).click();
        arrowSearch.click();

    }
        @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/div[1]/div/p[1]")
        WebElement footerAssert;

        @FindBy(linkText = "Contact Us")
        WebElement contact;

        @FindBy(xpath = "/html/body/div[4]/div[2]/div[1]/form/div[1]/div/div/input")
        WebElement fullName;

        @FindBy(xpath = "/html/body/div[4]/div[2]/div[1]/form/div[2]/div/div/input")
        WebElement contactEmail;

        @FindBy(xpath = "/html/body/div[4]/div[2]/div[1]/form/div[3]/div/div/div/input")
        WebElement phoneContact;

        @FindBy(xpath = "/html/body/div[4]/div[2]/div[1]/form/div[4]/div/div/textarea[1]")
        WebElement message;

        @FindBy(xpath = "/html/body/div[4]/div[2]/div[1]/form/div[5]/div[1]/label[1]/span[1]/input")
        WebElement phoneCheckbox;

        @FindBy(xpath = "/html/body/div[4]/div[2]/div[1]/form/div[5]/div[2]/label/span/input")
        WebElement privacyPolicy;

        @FindBy(xpath = "/html/body/div[4]/div[2]/div[1]/form/div[6]/button")
        WebElement submitContact;

        public void contact() throws InterruptedException {
            driver.findElement(By.xpath("//*[@id=\"driver-popover-content\"]/button")).click();
            Thread.sleep(2000);
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            Thread.sleep(2000);
            //Assertion for Footer
            Assert.assertTrue(footerAssert.isDisplayed());
            contact.click();

            //Switching between the tabs
            for(int z = 1;z<5;z++) {
                String xpath = "//*[@id=\"contact\"]/div[1]/div/div/div/div/button[" + z + "]";
                waitDriver(By.xpath(xpath)).click();
                Thread.sleep(1500);
            }
        }

        public void contactFieldsValidation() throws InterruptedException {
            //Filling the Contact Form Fields
            System.out.println("Validating the Contact Fields ...");

            Thread.sleep(1500);
            //Scrolling Down to Make "Submit" Visible
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0,300)");
            Thread.sleep(1500);
            submitContact.click();
            fullName.sendKeys("Umar");
            contactEmail.sendKeys("yes");
            phoneContact.sendKeys("5088786511");
            clearsingleField(message);
            message.sendKeys("To Contact");
            phoneCheckbox.click();
            System.out.println("Phone clicked!");
            privacyPolicy.click();
            System.out.println("Privacy policy clicked!");

            submitContact.click();
            System.out.println("Submit button clicked!");

        }

            public void contactSubmit() throws InterruptedException {
            for(int i=0;i<3;i++){
                System.out.println("Correct Submit of Contact and Contacting with the same user at " +i + " time");

                Thread.sleep(1500);
                clearFields(fullName,contactEmail);
                clearFields(phoneContact,message);

                submitContact.click();
                fullName.sendKeys("Umar");
                contactEmail.sendKeys("umarhassanzia88+test19@gmail.com");
                phoneContact.sendKeys("508878651");
                clearsingleField(message);
                message.sendKeys("To Contact");
                phoneCheckbox.click();
                privacyPolicy.click();
                submitContact.click();
                //Pause before filling the same fields again for contact
                Thread.sleep(2000);
            }}




}
