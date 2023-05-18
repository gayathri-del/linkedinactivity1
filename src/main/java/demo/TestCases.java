package demo;

import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;
import java.util.*;
import java.lang.*;

import java.util.List;
import java.util.Iterator;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void TestCases07() {
        System.out.println("nested frames");
        // Navigate to the url https://the-internet.herokuapp.com/nested_frames
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        // WebElement parent1 =
        // driver.findElement(By.xpath("//frame[@name='frame-top']"));
        // Switch to the parent frame Using Locator "Name"
        // driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-top");
        System.out.println("ur in 1st frame");
        // Switch to the left frame Using Locator "Name"
        // driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        // Read the text of the frame Using Locator "XPath" "/html/body"
        WebElement left = driver.findElement(By.xpath("/html/body"));
        System.out.println(left.getText());
        // Switch back to the default content driver.switchTo().defaultContent()
        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-top");
        // Switch to middle frame "frame-middle"
        driver.switchTo().frame("frame-middle");
        // Read the text of the frame "/html/body"
        WebElement middle = driver.findElement(By.xpath("/html/body"));
        System.out.println(middle.getText());
        // Switch back to the default content
        driver.switchTo().defaultContent();
        // Switch to parent frame
        driver.switchTo().frame("frame-top");
        // Switch to the right frame "frame-right"
        driver.switchTo().frame("frame-right");
        WebElement right = driver.findElement(By.xpath("/html/body"));
        // Read the text of the frame "/html/body"
        System.out.println(right.getText());
        // Switch to the default content
        driver.switchTo().defaultContent();
        // Switch to the bottom content "frame-bottom"
        driver.switchTo().frame("frame-bottom");
        // Read the text of the frame "/html/body"
        WebElement bottom = driver.findElement(By.xpath("/html/body"));
        System.out.println(bottom.getText());

    }

     }

    

    

