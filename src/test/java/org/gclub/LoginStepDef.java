package org.gclub;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginStepDef{
        WebDriver driver = null;
        WebDriverWait wait = null;
        String url_gclub_login = "https://gclub-frontend-dev6.devenv.vogfw.xyz/en/login";
        String str_current_user = "";

        public LoginStepDef()
        {
                System.setProperty("webdriver.gecko.driver", "C:\\WebDriver\\bin\\geckodriver.exe");
                 driver = new FirefoxDriver();
                 wait = new WebDriverWait(driver, 15);

               // System.out.println("construct");
        }


        @Given("I am on the login page")
        public void i_am_on_the_login_page() {
                driver.get(url_gclub_login);
               /* new WebDriverWait(driver,30L).until(new ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver d) {
                                return d.getTitle().toLowerCase().startsWith("G-Club");
                        }
                });

                */
        }

        @Given("I input a user name {string} and input a password {string}")
        public void i_input_a_user_name_and_input_a_password(String username, String password) {
                str_current_user = username;
                WebElement element = driver.findElement(By.id("username"));
               element.sendKeys(username);
               driver.findElement(By.id("password")).sendKeys(password);
        }

        @When("I click the login button")
        public void i_click_the_login_button() {
                //加sleep是为了演示自动化效果，正常使用要去掉
                try {
                        Thread.sleep(2000);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
               driver.findElement(By.id("username")).submit();

        }

        @Then("should be told the username or password are incorrect")
        public void should_be_told_the_username_or_password_are_incorrect() {
                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("MuiAlert-message"),"raphQL error:"));
               String errMsg = driver.findElement(By.xpath("//div[@class='MuiAlert-message']")).getAttribute("innerText");
              //  System.out.println(errMsg);
                //GraphQL error: 密码错误
                assertTrue(errMsg.contains("error"));


        }

        @Then("stay on the login page")
        public void stay_on_the_login_page() {

                //可以找到页面右上角的login超链接，作为在登录页的标志
                assertTrue(driver.findElement(By.xpath("//a[@href='/en/login']")) != null);

        }


        @Then("should go to the user‘s home page")
        public void should_go_to_the_user_s_home_page() {

                //右上角的铃铛
               // By by_alert_button =By.xpath("//button[@aria-controls=\"primary-notification-panel\"]");

                //加sleep是为了演示自动化效果，正常使用要去掉
                try {
                        Thread.sleep(2000);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }

                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.titleIs("Account | G-Club"));
                //页面中间出现用户名
               String uName =  driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1']")).getText();
               assertEquals(str_current_user,uName);


        }

        @After()
        public void closeBrowser() {
                //加sleep是为了演示自动化效果，正常使用要去掉
                try {
                        Thread.sleep(3000);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
               driver.quit();
        }

}