package vela;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;


public class CreateLead {

    @Test
    void test1(){

        // Step 0) Setup the chromedriver using webdrivermanager software
        WebDriverManager.chromedriver().setup();

        System.setProperty("webdriver.chrome.driver", "C:/Macys/Framework/SDT/SDT/shared/resources/src/main/resources/framework/selenium_drivers/chromedriver_122.exe");

        // Step 1) Launch the chrome browser (Class Name -> ChromeDriver)
        ChromeDriver driver = new ChromeDriver();

        // Step 2) Load the URL (http://leaftaps.com/opentaps/control/main) -> get
        driver.get("http://leaftaps.com/opentaps");

        // Step 3) Maximize the chrome browser
        driver.manage().window().maximize();

        // Step 4) Find the username and type the value (DemoSalesManager)
        driver.findElement(By.id("username")).sendKeys("DemoSalesManager");

        // Step 5) Find the password and type the value (crmsfa)
        driver.findElement(By.id("password")).sendKeys("crmsfa");

        // Step 6) Find the login button and click
        driver.findElement(By.className("decorativeSubmit")).click();

        // Step 7) Verify the title
        String title = driver.getTitle();
        System.out.println(title);

        driver.findElement(By.linkText("CRM/SFA")).click();

//        driver.findElement(By.linkText("Logout")).click();


        driver.findElement(By.linkText("CRM/SFA")).click();
    }

}
