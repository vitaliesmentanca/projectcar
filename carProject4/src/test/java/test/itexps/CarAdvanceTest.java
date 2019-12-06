/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.itexps;

import com.itexp.AdvanceSearch;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author vital
 */
public class CarAdvanceTest {
    
    private static WebDriver driver;
    private String baseUrl;

    public CarAdvanceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void executePageSearch() throws Exception {
        AdvanceSearch page = PageFactory.initElements(driver, AdvanceSearch.class);
        page.searchApplic("500 miles of","Alfa Romeo", "Stelvio","$2,000","$90,000");
    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {

        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
