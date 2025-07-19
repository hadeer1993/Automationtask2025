package Tests;

import Pages.RegistrationPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class RegistrationTest {

    private AndroidDriver<MobileElement> driver;
    private RegistrationPage registrationPage;
    private DesiredCapabilities caps;

    @BeforeClass
    public void setupCapabilities() {
        caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("appium:appPackage", "com.example.tester_task");
        caps.setCapability("appium:appActivity", "com.example.tester_task.MainActivity");
        caps.setCapability("automationName", "UiAutomator2");
    }

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        System.out.println("🚀 Starting new test session...");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723"), caps);
        registrationPage = new RegistrationPage(driver);
        try {
            Thread.sleep(3000); // wait for app to fully launch
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            System.out.println("🛑 Closing app after test");
            driver.quit();
        }
    }

    @Test
    public void testValidRegistration() throws InterruptedException {
        System.out.println("🧪 Running testValidRegistration...");

        registrationPage.enterName("Hadeer");
        Thread.sleep(500);

        registrationPage.enterEmail("hadeer@example.com");
        Thread.sleep(500);

        registrationPage.enterPhone("01012345678");
        Thread.sleep(500);

        registrationPage.enterPassword("123456");
        Thread.sleep(500);

        registrationPage.enterConfirmPassword("123456");
        Thread.sleep(500);

        registrationPage.enterAddress("Alexandria, Egypt");
        Thread.sleep(500);

        driver.hideKeyboard();
        Thread.sleep(500);

        registrationPage.clickRegister();
    }

    @Test
    public void testAllValidationMessages() {
        System.out.println("🧪 Running testAllValidationMessages with invalid data...");

        registrationPage.fillForm(
                "a",                    
                "invalidemail",         
                "abc",                  
                "123",                  
                "456",                  
                "1"                     
        );

        Assert.assertEquals(registrationPage.getNameValidationMessage(), "Name must be at least 2 characters");
        Assert.assertEquals(registrationPage.getEmailValidationMessage(), "Enter a valid email");
        Assert.assertEquals(registrationPage.getPhoneValidationMessage(), "Enter a valid phone number");
        Assert.assertEquals(registrationPage.getPasswordValidationMessage(), "Password must be at least 6 characters");
        Assert.assertEquals(registrationPage.getConfirmPasswordValidationMessage(), "Passwords do not match");
        Assert.assertEquals(registrationPage.getAddressValidationMessage(), "Address must be more descriptive");
    }
}
