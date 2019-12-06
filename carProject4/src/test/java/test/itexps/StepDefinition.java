/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.itexps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author vital
 */
public class StepDefinition {
    private static WebDriver driver;
    private String baseUrl="https://www.cars.com";
    @Given("^user is on HomePage$")
public void user_is_on_HomePage() throws Throwable {
    System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
         driver = new ChromeDriver();
         driver.get(baseUrl);
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
}

@When("^title is Cars$")
public void title_is_Cars() throws Throwable {
     driver.manage().window().maximize();
    Assert.assertEquals("New Cars, Used Cars, Car Dealers, Prices & Reviews | Cars.com", driver.getTitle());

    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
}

@When("^user enter data Makes and Models$")
public void user_enter_data_Makes_and_Models() throws Throwable {
   driver.findElement(By.name("makeId")).click();
    new Select(driver.findElement(By.name("makeId"))).selectByVisibleText("Ferrari");
    driver.findElement(By.name("makeId")).click();
    driver.findElement(By.name("modelId")).click();
    new Select(driver.findElement(By.name("modelId"))).selectByVisibleText("LaFerrari");
    driver.findElement(By.name("modelId")).click();
    new Select(driver.findElement(By.name("radius"))).selectByVisibleText("All Miles from");
    driver.findElement(By.name("radius")).click(); 
    // Write code here that turns the phrase above into concrete actions
   ///throw new PendingException();
}

@When("^user click on Search button$")
public void user_click_on_Search_button() throws Throwable {
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search by'])[2]/following::input[2]")).click();
   
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
}

@When("^user is on Search Result Page$")
public void user_is_on_Search_Result_Page() throws Throwable {
    assertEquals("Cars for Sale", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sign Out'])[1]/following::a[1]")).getText());

     Thread.sleep(5000);
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
}

@Then("^user close the browserr chrome$")
public void user_close_the_browserr_chrome() throws Throwable {
    driver.close();
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
}

}
