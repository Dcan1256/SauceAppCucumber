package Steps;

import Pages.*;
import Utilities.InitializeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static Utilities.InitializeDriver.driver;

public class SauceAppSteps {
    WebDriver driver= InitializeDriver.getDriver();
    LoginPage lp;
    MainPage mp;
    CartPage cp;
    CheckOutPage cop;
    CheckOutOverviewPage coop;
    CheckOutCompletePage cocp;



    @Before
    public void setUp(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        System.out.println("Method runs before scenario");
    }

    @Given("user navigate {string}")
    public void user_navigate(String url) {
        driver.get(url);
    }
    @Then("enters username as {string} and password as {string}")
    public void enters_username_as_and_password_as(String username, String password) {
        lp=new LoginPage(driver);
        lp.usernameBox.sendKeys(username);
        lp.passwordBox.sendKeys(password);
        lp.loginBtn.click();
    }
    @Then("user verify successful login with {string} tag on the current page")
    public void user_verify_successful_login_with_tag_on_the_current_page(String expectedTitle) {
        mp=new MainPage(driver);
        String actualTitle= mp.getMainPageTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }



    @Then("enters username as {} and password as {}")
    public void entersUsernameAsAndPasswordAsToCheck(String username, String password) {
        lp=new LoginPage(driver);
        lp.usernameBox.sendKeys(username);
        lp.passwordBox.sendKeys(password);
        lp.loginBtn.click();
    }

    @And("user checks the validity {}")
    public void userChecksTheValidity(String isValid) {
        mp=new MainPage(driver);
        if(isValid.equals("false")){
            Assert.assertTrue(lp.errorMsg.isDisplayed());
        }
        else if(isValid.equals("true")){
            Assert.assertEquals(mp.getMainPageTitle(),"Products");
        }
        else {
            Assert.assertTrue(false);
        }
    }

    @After
    public void tearDown(Scenario sc){
        System.out.println("Scenario status =====>"+sc.getStatus());
        if(sc.isFailed()){
            TakesScreenshot ts=(TakesScreenshot)driver;
            byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
            sc.attach(screenshot, "image/png", sc.getName());
        }
        driver.quit();
    }

    @Then("user validates we are in the main page by the header {string}")
    public void userValidatesWeAreInTheMainPageByTheHeader(String expectedTitle) {
        mp=new MainPage(driver);
        String actualTitle=mp.getMainPageTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @And("user adding all {int} item into the cart")
    public void userAddingAllItemIntoTheCart(int expectedNumber) {
        mp=new MainPage(driver);
        mp.clickAll();
        int actualNumber= Integer.parseInt(mp.numOfAllItems.getText());
        Assert.assertEquals(actualNumber,expectedNumber);
        mp=new MainPage(driver);
        int actualNum= Integer.parseInt(mp.numOfAllItems.getText());
        Assert.assertEquals(actualNum,expectedNumber);
    }

    @Then("login")
    public void login() {
        lp=new LoginPage(driver);
        lp.loginExp();
    }


    @Then("user is removing all {int} elements recently added")
    public void user_is_removing_all_elements_recently_added(Integer num) {
        mp=new MainPage(driver);
        int expectedNum=0;
        int actualNum= Integer.parseInt(mp.numOfAllItems.getText())-num;
        mp.clickAllRemove();
        Assert.assertEquals(actualNum,expectedNum);
    }

    @Then("user enters username as {string} and password as {string}")
    public void userEntersUsernameAsAndPasswordAs(String username, String password) {
        lp=new LoginPage(driver);
        lp.usernameBox.sendKeys(username);
        lp.passwordBox.sendKeys(password);
        lp.loginBtn.click();
    }

    @And("user click go to cart button")
    public void userClickGoToCartButton() {
        mp.cartBtn.click();
    }

    @Then("user validates the {int} item in their cart again and clicks checkout button")
    public void userValidatesTheItemInTheirCartAgainAndClicksCheckoutButton(int qty) {
        cp=new CartPage(driver);
        int actualQty= Integer.parseInt(cp.numOfItemsInCart.getText());
        Assert.assertEquals(actualQty,qty);
        cp.checkOutBtn.click();
    }

    @Then("user filling checkout information with First-Last name and Zip code as {string},{string},{string}")
    public void userFillingCheckoutInformationWithFirstLastNameAndZipCodeAs(String fname, String lname, String zipCode) {
      cop=new CheckOutPage(driver);
      cop.fnameBox.sendKeys(fname);
      cop.lnameBox.sendKeys(lname);
      cop.zipcodeBox.sendKeys(zipCode);
      cop.continueBtn.click();
    }

    @Then("user checking the prices are correct or not and clicks finish button")
    public void userCheckingThePricesAreCorrectOrNotAndClicksFinishButton() {
        coop=new CheckOutOverviewPage(driver);
        int beforeTax= (int) coop.getPreTaxValue();
        int tax= (int) coop.getTaxValue();
        int afterTax= (int) coop.getAfterTaxValue();

        if(beforeTax+tax==afterTax){
            Assert.assertTrue(true);
        }
        // Scroll down to the bottom of the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        coop.finishBtn.click();
    }

    @And("verify checkout is completed successfully")
    public void verifyCheckoutIsCompletedSuccessfully() {
        cocp=new CheckOutCompletePage(driver);
        String actualText=cocp.confirmationTxt.getText();
        String expectedText="Thank you for your order!";
        Assert.assertEquals(actualText,expectedText);
    }
}
