package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class RegistrationPage {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;

    public RegistrationPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    // Locators using hints
    private By nameField = By.xpath("//android.widget.EditText[@hint='Name']");
    private By emailField = By.xpath("//android.widget.EditText[@hint='Email']");
    private By phoneField = By.xpath("//android.widget.EditText[@hint='Phone Number']");
    private By passwordField = By.xpath("//android.widget.EditText[@hint='Password']");
    private By confirmPasswordField = By.xpath("//android.widget.EditText[@hint='Confirm Password']");
    private By addressField = By.xpath("//android.widget.EditText[@hint='Address']");
    private By registerButton = By.xpath("//android.widget.Button[@content-desc='Register']");

    // Utility method
    private void typeIntoField(By locator, String logLabel, String value) {
        try {
            MobileElement field = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            field.click();
            Thread.sleep(500);
            System.out.println(logLabel + " " + value);
            field.sendKeys(value);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Actions
    public void enterName(String name) {
        typeIntoField(nameField, "📝 Name:", name);
    }

    public void enterEmail(String email) {
        typeIntoField(emailField, "📧 Email:", email);
    }

    public void enterPhone(String phone) {
        typeIntoField(phoneField, "📱 Phone:", phone);
    }

    public void enterPassword(String password) {
        typeIntoField(passwordField, "🔐 Password:", password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        typeIntoField(confirmPasswordField, "🔒 Confirm Password:", confirmPassword);
    }

    public void enterAddress(String address) {
        typeIntoField(addressField, "🏠 Address:", address);
    }

    public void clickRegister() {
        try {
            System.out.println("✅ Clicking on Register button");
            wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getNameValidationMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//android.widget.EditText[@hint='Name']/following-sibling::android.widget.TextView")
        )).getText();
    }

    public String getEmailValidationMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//android.widget.EditText[@hint='Email']/following-sibling::android.widget.TextView")
        )).getText();
    }

    public String getPhoneValidationMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//android.widget.EditText[@hint='Phone Number']/following-sibling::android.widget.TextView")
        )).getText();
    }

    public String getPasswordValidationMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//android.widget.EditText[@hint='Password']/following-sibling::android.widget.TextView")
        )).getText();
    }

    public String getConfirmPasswordValidationMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//android.widget.EditText[@hint='Confirm Password']/following-sibling::android.widget.TextView")
        )).getText();
    }

    public String getAddressValidationMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//android.widget.EditText[@hint='Address']/following-sibling::android.widget.TextView")
        )).getText();
    }
    
    public void fillForm(String name, String email, String phone, String password, String confirmPassword, String address) {
        System.out.println("🚀 Starting registration form filling...");
        enterName(name);
        enterEmail(email);
        enterPhone(phone);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        enterAddress(address);


    }}

    

