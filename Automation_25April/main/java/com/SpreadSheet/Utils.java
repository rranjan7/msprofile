package com.SpreadSheet;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
/**
 * Class to service functionality related to Driver, web element, wait.
 * 
 * @author aditya.raj
 *
 */
public class Utils {
    private WebDriver driver;
    private String baseUrl;
    private ReporterLog log;
    public Utils() {
        Properties props = this.getProperty("Properties/Driver.properties");
        baseUrl = props.getProperty("url");
        String fireFoxPath=props.getProperty("fireFoxDriverPath");
		String safariPath=props.getProperty("safariDriverPath");
		String chromePath=props.getProperty("chromeDriverPath");
        String browser = System.getProperty("browser");
        try {
            if (browser == null)
                browser = props.getProperty("browser");
            if (browser.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", fireFoxPath);
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", chromePath);
                driver = new ChromeDriver();
            }
        } catch (Exception e) {
        }
    }
    public Utils(WebDriver driver) {
        this.driver = driver;
    }
    public Properties getProperty(String resource) {
        Properties props = null;
            try {
                File file = new File(resource);
                FileInputStream fileInput = new FileInputStream(file);
                props = new Properties();
                props.load(fileInput);
            } catch (Exception e) {
                log.error(resource + "\n" + e.toString());
            }
        return props;
    }
    public WebDriver getDriver() {
        return this.driver;
    }
    public HomePage openUrl(String baseUrl) {
        driver.get("https://marketplace.appdirect.com/home");
        return new HomePage(driver);
    }
    public void waitFor(String locator, int time){
        WebDriverWait wait = new WebDriverWait(driver, time);
        String locate[] = locator.split(";");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locate[0])));
        } catch (Exception e) {
            log.exceptionlog("Element Not Found At: "+locate[0]);
        }
    }
    public WebElement getElement(String locator) {
        String locate[] = locator.split(";");
        WebDriverWait wait = new WebDriverWait(driver, 20);
                switch (locate[1]) {
                case "XPATH":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locate[0])));
                    return driver.findElement(By.xpath(locate[0]));
                case "id":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locate[0])));
                    return driver.findElement(By.id(locate[0]));
                case "CSS":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locate[0])));
                    return driver.findElement(By.cssSelector(locate[0]));
                case "name":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locate[0])));
                    return driver.findElement(By.name(locate[0]));
                case "linktext":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locate[0])));
                    return driver.findElement(By.linkText(locate[0]));
                case "tagname":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locate[0])));
                    return driver.findElement(By.tagName(locate[0]));
                case "class":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locate[0])));
                    return driver.findElement(By.className(locate[0]));
                default:
                    return null;
            }
        }
    public String getUrl() {
        return this.baseUrl;
    }
    
}