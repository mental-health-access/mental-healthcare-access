import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;


    public class selTest{

        public static void main(String[] args) {

// Instantiate a SafariDriver class.
            WebDriver driver = new SafariDriver();
// Launch Website
            driver.navigate().to("http://localhost:8080/");

// Click on the email and password box and send values
            driver.findElement(By.id("email")).sendKeys("abraham@mail.com");
            driver.findElement(By.id("password")).sendKeys("12345678");

// Click on the login button
            driver.findElement(By.tagName("button")).click();

// Close the Browser
            //driver.close();
        }
    }
