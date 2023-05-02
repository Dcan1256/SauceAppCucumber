package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.ResourceBundle;

public class InitializeDriver {
    public static WebDriver driver;
    public static ResourceBundle bundle;

    public static WebDriver getDriver(){

        String browser="firefox";
        if(browser.toLowerCase().equals("chrome")){
            driver=new ChromeDriver();
        }
        else if(browser.toLowerCase().equals("edge")){
            driver=new EdgeDriver();
        }
        else if(browser.toLowerCase().equals("firefox")){
            driver=new FirefoxDriver();
        }
        else{
            // old duck !!!
            driver=new InternetExplorerDriver();
        }
        return driver;
        }

    }
