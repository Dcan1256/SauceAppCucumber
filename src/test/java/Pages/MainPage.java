package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage{
    public MainPage(WebDriver driver) {
        super(driver);
    }

    //Elements


    @FindAll(@FindBy(xpath = "//button[@class and text()='Add to cart']"))
    public List<WebElement> superAddToCart;

    @FindAll(@FindBy(xpath = "//button[@class and text()='Remove']"))
    public List<WebElement> superRemove;


    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    public WebElement mainPageTitle;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select")
    public WebElement sortingDropDown;

    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    public WebElement menu;

    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    public WebElement logoutBtn;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    public WebElement backpackBtnAddBtn;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")
    public WebElement bikeLightAddBtn;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")
    public WebElement blackShirtAddBtn;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")
    public WebElement jacketAddBtn;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-onesie\"]")
    public WebElement onesieAddBtn;

    @FindBy(xpath = "//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")
    public WebElement orangeShirtAddBtn;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
    public WebElement numOfAllItems;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    public WebElement cartBtn;

    //Action Methods
    public String getMainPageTitle(){
        return mainPageTitle.getText();
    }

    /**
     * This method will click the Add to Cart button of all items we currently
     * have on the web page
     */

    public void clickAll(){
        for(WebElement element: superAddToCart){
            element.click();
        }
    }

    public void clickAllRemove(){
        for (WebElement element: superRemove){
            element.click();
        }
    }


    public void expLogOut(){ // Express log out from TC_003_Logout
        MainPage mp=new MainPage(driver);
        mp.menu.click();
        mp.logoutBtn.click();
    }
}
