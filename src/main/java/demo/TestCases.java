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

    public void testCase01() {
        // Navigate to google.com https://www.google.com/
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        boolean isDisplayed = false;
        // locate the search box Using Locator "Tag Name" "q"
        driver.findElement(By.name("q")).click();

        // seach amazon in the text area Using Locator "Tag Name" "q"
        driver.findElement(By.name("q")).sendKeys("amazon");
        // click on google search Using Locator "XPath" ""(//input[@name='btnK'])[1]""
        driver.findElement(By.xpath("(//input[@name='btnK'])[1]")).click();

        // check if amazon.in text is returned Using Locator "XPath"
        // //h3[text()="Amazon.in]"]
        driver.findElement(By.xpath("//h3[text()='Amazon.in']")).isDisplayed();
        System.out.println(driver.findElement(By.xpath("//h3[text()='Amazon.in']")).isDisplayed());
        // System.out.println(isDisplayed);

        System.out.println("end Test case: testCase02");
    }

    public void testCase02() {
        System.out.println("testcase02");
        System.out.println("bookmyshow");
        // navigate to book my show
        driver.get("https://in.bookmyshow.com/");
        // find the number of links
        driver.findElements(By.tagName("a"));
        // return the total number of links
        int count = driver.findElements(By.tagName("a")).size();
        System.out.println(count);

    }

    public void testCase03() {
        System.out.println("testcase03");
        System.out.println("number of links");
        // navigate to google.com
        driver.get("https://www.google.com");
        // find search box using locator by name "a" and click on it
        driver.findElement(By.name("q")).click();
        // type your name
        driver.findElement(By.name("q")).sendKeys("Gayathri");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        // click on google search
        // find the number of links with your name
        int count = driver.findElements(By.partialLinkText("Gayathri")).size();
        int count1 = driver.findElements(By.partialLinkText("gayathri")).size();

        System.out.println(count1 + count);

        // System.out.println(count);
        // System.out.println(count1);
    }

    public void testCase04() throws InterruptedException {
        System.out.println("book my show activity-5");
        // navigate to book my show url https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // find the image urls of the "Recommended movies" Using Locator "XPath"
        // "//div[@class='sc-133848s-2 sc-1t5vwh0-0 fhNBrq']/div/img"

        // driver.findElements(By.xpath("//div[@class='sc-133848s-2 sc-1t5vwh0-0
        // fhNBrq']/div/img")).size();

        List<WebElement> ele = driver.findElements(By.xpath(
                "/html/body/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/div/a/div/div/div/img"));

        System.out.print(ele.size());
        for (WebElement i : ele) {
            String url = i.getAttribute("src");
            System.out.println(url);
        }

        // c-1t5vwh0-0 fhNBrq']/div/img
        // print the name and language of
        // WebElement parent = driver.findElement(
        // By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/div[1]/div[5]/div/div/div/div[2]/div/div/div[2]"));
        Thread.sleep(3000);
        WebElement name = driver.findElement(By.xpath(
                "/html/body/div[1]/div[1]/div[2]/div[3]/div[1]/div[5]/div/div/div/div[2]/div/div/div[2]/a/div/div[3]/div[2]/div"));
        System.out.println(name.getText());
        WebElement lang = driver.findElement(By.xpath(
                "/html/body/div[1]/div[1]/div[2]/div[3]/div[1]/div[5]/div/div/div/div[2]/div/div/div[2]/a/div/div[3]/h3"));
        System.out.println(lang.getText());
    }

    public void TestCases05() throws InterruptedException {
        // navigate to linkedin

        // Navigate to linkedin home page https://www.linkedin.com/home

        driver.get("https://www.linkedin.com/home");
        // click on sign in button Using Locator "CSS Selector"
        // ".nav__button-secondary.btn-md.btn-secondary-emphasis"
        WebElement signin = driver.findElement(By.cssSelector(".nav__button-secondary.btn-md.btn-secondary-emphasis"));
        signin.click();
        // enter username Using Locator "ID" username
        WebElement username = driver.findElement(By.id("username"));
        username.click();

        username.sendKeys("sandhyabalachander32@gmail.com");
        // enter password Using Locator "ID" username
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Sandhya0307");
        // click on signin button Using Locator "XPath"
        // "//button[@data-litms-control-urn='login-submit']"
        WebElement signin1 = driver.findElement(By.xpath("//button[@data-litms-control-urn='login-submit']"));
        signin1.click();
        // Write a post Using Locator "XPath" //span[text()='Start a post']
        WebElement post = driver.findElement(By.xpath("//span[text()='Start a post']"));
        post.click();
        WebElement content = driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']"));
        content.sendKeys("Dummyhhhhhhhh comment");
        WebElement postbutton = driver.findElement(By.xpath("//div[@class='share-box_actions']/button"));
        Thread.sleep(3000);
        postbutton.click();
        // check if successfully posted
        // Check if the post is successfully posted Using Locator "Class" Name
        // "artdeco-toast-item__message"
        WebElement check = driver.findElement(By.className("artdeco-toast-item__message"));
        if (check.isDisplayed()) {
            System.out.println("post is successfully posted");
        }
        // print the number of people viewed your profile Using Locator "XPath"
        // By.xpath("(//span[@class='mr1 hoverable-link-text t-bold']/span)[1]")
        // print the number of impressions Using Locator "XPath" By.xpath(

        WebElement profile2 = driver.findElement(By.xpath("//div[@class='t-16 t-black t-bold']"));
        Thread.sleep(4000);
        profile2.click();
        WebElement views = driver
                .findElement(By.xpath("(//span[@class='mr1 hoverable-link-text t-bold']/span)[1]"));
        System.out.println(views.getText());
        WebElement impressions = driver.findElement(By.xpath(
                "(//span[@class='mr1 hoverable-link-text t-bold'])[2]"));
        System.out.println(impressions.getText());

    }

    public void TestCases06() throws InterruptedException {
        driver.get("https://www.linkedin.com/home");
        // click on sign in button Using Locator "CSS Selector"
        // ".nav__button-secondary.btn-md.btn-secondary-emphasis"
        WebElement signin = driver.findElement(By.cssSelector(".nav__button-secondary.btn-md.btn-secondary-emphasis"));
        signin.click();
        // enter username Using Locator "ID" username
        WebElement username = driver.findElement(By.id("username"));
        username.click();

        username.sendKeys("sandhyabalachander32@gmail.com");
        // enter password Using Locator "ID" username
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Sandhya0307");
        // click on signin button Using Locator "XPath"
        // "//button[@data-litms-control-urn='login-submit']"
        WebElement signin1 = driver.findElement(By.xpath("//button[@data-litms-control-urn='login-submit']"));
        signin1.click();
        // Write a post Using Locator "XPath" //span[text()='Start a post']
        WebElement post = driver.findElement(By.xpath("//span[text()='Start a post']"));
        post.click();
        driver.findElement(
                By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/span[1]/div[1]/button"))
                .click();
        // .sendKeys("C:\\Users\\hp\\OneDrive\\Pictures\\1565627484196.jpg");
        driver.findElement(
                By.xpath(
                        "//input['image-sharing-detour-container__file-input' and @type='file']"))
                .sendKeys("C:\\Users\\hp\\OneDrive\\Pictures\\1565627484196.jpg");

        // Runtime.getRuntime().exec("");
        WebElement done = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div[2]/div/button[2]"));
        Thread.sleep(3000);
        done.click();
        WebElement postbutton = driver.findElement(
                By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div[2]/div[2]/div[3]/div[2]/button"));
        Thread.sleep(3000);
        postbutton.click();

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

    public void TestCases08() {
        System.out.println("Alerts");
        // Navigate to the url
        // https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
        // switch to the frame
        driver.switchTo().frame("iframeResult");
        // Click on Try it button Using Locator "XPath"
        // "//button[@onclick='myFunction()']"
        driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
        // Add your name "//button[@onclick='myFunction()']"
        driver.switchTo().alert().sendKeys("Gayathri");
        // Accept the alert driver.switchtTo().alert().accept()
        driver.switchTo().alert().accept();
        // display the message
        System.out.println(driver.findElement(By.xpath("//p[@id='demo']")).getText());
    }

    public void TestCases09() {
        System.out.println("IMDB");
        // Visit the site: https://www.imdb.com/chart/top
        driver.get("https://www.imdb.com/chart/top");
        // Retrieve the highest rated movie Using Locator "XPath" "//table[@class='chart
        // full-width']/tbody/tr/td[2]/a
        WebElement highestrated = driver.findElement(By.xpath("//table[@class='chart full-width']/tbody/tr/td[2]/a"));
        System.out.println(highestrated.getText());
        // Find the total number of movies listed in the table Using Locator "XPath"
        // "//table[@class='chart full-width']/tbody/tr
        List<WebElement> numberofmovies = driver.findElements(By.xpath("//table[@class='chart full-width']/tbody/tr"));
        System.out.println(numberofmovies.size());
        // Change the dropdown option to release date "//table[@class='chart
        // full-width']/tbody/tr
        Select select = new Select(driver.findElement(By.xpath("//select[@id='lister-sort-by-options']")));
        select.selectByVisibleText("Release Date");
        // Retrieve the recent movie Using Locator "XPath" (//table[@class='chart
        // full-width']/tbody/tr/td[2]/a)[1]
        WebElement newmovie = driver
                .findElement(By.xpath("(//table[@class='chart full-width']/tbody/tr/td[2]/a)[1]"));
        System.out.println(newmovie.getText());
        // Sort the movies in ascending order Using Locator "XPath"
        // "//*[@id='main']/div/span/div/div/div[3]/div/div/div[1]/span"
        WebElement s1 = driver.findElement(By.xpath("//*[@id='main']/div/span/div/div/div[3]/div/div/div[1]/span"));
        s1.click();
        // Retrieve the old movie Using Locator "XPath"
        // "//*[@id='main']/div/span/div/div/div[3]/div/div/div[1]/span"

        WebElement oldmovie = driver
                .findElement(By.xpath("(//table[@class='chart full-width']/tbody/tr/td[2]/a)[1]"));
        System.out.println(oldmovie.getText());
        Select select1 = new Select(driver.findElement(By.xpath("//select[@id='lister-sort-by-options']")));
        select1.selectByVisibleText("Number of Ratings");
        // Retrive the movie which has the highest user rating Using Locator "XPath"
        // (//table[@class='chart full-width']/tbody/tr/td[2]/a)[1]
        WebElement userrating = driver
                .findElement(By.xpath("(//table[@class='chart full-width']/tbody/tr/td[2]/a)[1]"));
        System.out.println(userrating.getText());

    }

    public void TestCases10() throws IOException {
        // navigate to url
        // Navigate to the url
        // https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        // switch to the frame using frame name "iframeResult"
        driver.switchTo().frame("iframeResult");
        // Click on the try it button Using Locator "XPath"
        // "//button[@onclick='myFunction()']"
        driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
        // Retrieve the mainwindow/parent window using getWindowHandle
        // driver.getWindowHandle()
        String mainWindowHandle = driver.getWindowHandle();
        // Create a set which stores all the windows driver.getWindowHandles()
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                // if main window is not equal to cuurent window
                // Get the URL, Title, and take the screenshot of the current window
                // driver.getCurrentUrl(), driver.getTitle()
                String currenturl = driver.getCurrentUrl();
                String title = driver.getTitle();
                System.out.println("URL of child window is " + currenturl);
                System.out.println("URL of child window is " + title);

                // Use TakesScreenshot method to capture screenshot
                TakesScreenshot screenshot = (TakesScreenshot) driver;

                File source = screenshot.getScreenshotAs(OutputType.FILE);
                // Take the screenshot of the child window File source =
                // screenshot.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(source, new File("./Screenshots/Screen.png"));
                System.out.println("screenshot captured");

            }

        }
        // Switch back to main window driver.switchTo().window(mainWindowHandle);
        driver.switchTo().window(mainWindowHandle);

    }

}
