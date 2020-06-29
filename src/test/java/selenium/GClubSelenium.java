package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class GClubSelenium {

    public static void main(String[] args) {


        System.setProperty("webdriver.gecko.driver", "C:\\WebDriver\\bin\\geckodriver.exe");

       WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 15);


        try {
            driver.get("https://gclub-frontend-dev6.devenv.vogfw.xyz/en/login");
            driver.findElement(By.id("username")).sendKeys("aaa" + Keys.ENTER);
            driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
            WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3>div")));
           // System.out.println(firstResult.getAttribute("textContent"));
        } finally {
          //  driver.quit();
        }


    }
}
