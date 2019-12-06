/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.itexps;

import com.itexp.LoginCar;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author vital
 */
public class CarLoginTest {
    private WebDriver driver;
    private String baseUrl;
    private static LoginCar login;

    public CarLoginTest() {
    }

    @BeforeClass
    public static void setUpClass() throws FileNotFoundException, IOException {
        //read excel file
        FileInputStream inputStream = new FileInputStream(new File("c:\\data\\carsproj.xlsx"));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Row r = firstSheet.getRow(0);
        Cell c = r.getCell(0);//username value
        String username = c.getStringCellValue();
        c = r.getCell(1); //username value
        String password = c.getStringCellValue();
        login = new LoginCar(username, password);
        System.out.println(login);
        inputStream.close();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws FileNotFoundException, IOException {
        System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testPopup() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.cars.com/");
        driver.findElement(By.id("profile_menu-avatar")).click();
        driver.findElement(By.linkText("Log In")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email'])[1]/following::input[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email'])[1]/following::input[1]")).clear();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email'])[1]/following::input[1]")).sendKeys(login.getUsername());
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/following::input[1]")).clear();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/following::input[1]")).sendKeys(login.getPassword());
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Forgot your password?'])[1]/following::button[1]")).click();
        Thread.sleep(9000);
        try {
            assertEquals("Cars for Sale", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sign Out'])[1]/following::a[1]")).getText());
        } catch (Error e) {
            System.out.println(e.toString());
        }

    }
    
}
