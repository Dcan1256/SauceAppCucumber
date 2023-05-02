package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(xpath = "//*[@id=\"user-name\"]")
    public WebElement usernameBox;

    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"login_credentials\"]/h4")
    public WebElement acceptedUsernamesTxt;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]")
    public WebElement headerTxt;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    public WebElement errorMsg;

    //Action Methods

    /**
     * Express login method for LoginPage referenced by TC_001_Login
     * @throws InterruptedException
     */
    public void loginExp() {
        LoginPage lp=new LoginPage(driver);
        lp.usernameBox.sendKeys("standard_user");
        lp.passwordBox.sendKeys("secret_sauce");
        lp.loginBtn.click();

    }
}
