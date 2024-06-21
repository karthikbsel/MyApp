package session10;
//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumAutomation {

    //type main -Ctrl+space
    public static void main(String[] args) throws InterruptedException {

//disable the notification from browser
        ChromeOptions opt=new ChromeOptions();
        opt.addArguments("--disable-notifications");

//launch the chromebrowser
        ChromeDriver driver=new ChromeDriver(opt);

//load the url
        driver.get("https://login.salesforce.com/?locale=in");

//window maximize
        driver.manage().window().maximize();

//apply wait
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//enter the username
        driver.findElement(By.id("username")).sendKeys("radhakrishnan@testleaf.com");

//enter the password
        driver.findElement(By.id("password")).sendKeys("Sparrow@123");

//click on login
        driver.findElement(By.id("Login")).click();

        Thread.sleep(3000);


//click on appLauncher

        driver.findElement(By.className("slds-icon-waffle")).click();

        Thread.sleep(3000);

//click on viewAll
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        Thread.sleep(3000);
//click marketing crm link
        driver.findElement(By.xpath("//p[text()='Marketing CRM Classic']")).click();

//click leads
//normal click is not working this thorwing javascript
//create webElement
//ctrl+2-> L
        WebElement jsClick = driver.findElement(By.xpath("//span[text()='Leads']"));
        driver.executeScript("arguments[0].click();", jsClick);


        driver.findElement(By.xpath("//div[text()='New']")).click();

        driver.findElement(By.xpath("//label[text()='Salutation']/following::button")).click();
        driver.findElement(By.xpath("//span[text()='Mr.']")).click();

//First name
        driver.findElement(By.xpath("//label[text()='First Name']/following::input")).sendKeys("Dilip");

//last name
        driver.findElement(By.xpath("//label[text()='Last Name']/following::input")).sendKeys("Kumar");

//companyname
        driver.findElement(By.xpath("//label[text()='Company']/following::input")).sendKeys("TestLeaf");

//click on save
        driver.findElement(By.xpath("//button[text()='Save']")).click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String toastMessage = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
//        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")), toastMessage));
        System.out.println(toastMessage);
        if (toastMessage.contains("Dilip")) {
            System.out.println("Toast message is successfully verified");
        }
        else {
            System.out.println("Toast message is not verified");
        }

    }

}