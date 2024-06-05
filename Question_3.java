package task_21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class Question_3 {

    //Declaring Driver Variable as Global to Access Throughout the Class
    WebDriver driver;

    @BeforeTest
    //Function to Start the Chrome Browser
    public void launchChrome(){

        //Creating an Instance for ChromeDriver
        driver = new ChromeDriver();

        //Declaring Implicit wait(10 seconds)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Maximizing the Window
        driver.manage().window().maximize();

        //Navigating to the Given URL
        driver.get("http://the-internet.herokuapp.com/nested_frames");
    }


    @Test
    //Function to SwitchFrames in Nested Frames
    public void switchFrames(){

        //Locating the Top Frame in the Window
        WebElement we1 = driver.findElement(By.xpath("//frame[@name='frame-top']"));

        //Switching to the Top Frame
        driver.switchTo().frame(we1);

        //Getting the No of Frames Present in the Top Frame in List<>
        List<WebElement> wel = driver.findElements(By.tagName("frame"));

        //Verifying the No of Frames Whether its Matches with Expected Value or Not
        Assert.assertEquals(wel.size(), 3);

        //Switching to the Left Frame
        driver.switchTo().frame(0);

        //Getting the Text From the Frame
        String text = driver.findElement(By.tagName("body")).getText();

        //Verifying the Text Whether its Matches with Expected Value or Not
        Assert.assertEquals(text, "LEFT");

        //Again Switching to the Top Frame
        driver.switchTo().parentFrame();

        //Switching to the Middle Frame
        driver.switchTo().frame(1);

        //Getting the Text From the Frame
        String text1 = driver.findElement(By.tagName("body")).getText();

        //Verifying the Text Whether its Matches with Expected Value or Not
        Assert.assertEquals(text1, "MIDDLE");

        //Again Switching to the Top Frame
        driver.switchTo().parentFrame();

        //Switching to the Right Frame
        driver.switchTo().frame(2);

        //Getting the Text From the Frame
        String text2 = driver.findElement(By.tagName("body")).getText();

        //Verifying the Text Whether its Matches with Expected Value or Not
        Assert.assertEquals(text2, "RIGHT");

        //Again Switching to the Top Frame
        driver.switchTo().parentFrame();

        //Again Switching to the Parent Frame
        driver.switchTo().parentFrame();

        //Locating the Bottom Frame in the Window
        WebElement we2 = driver.findElement(By.xpath("//frame[@name='frame-bottom']"));

        //Switching to the Bottom Frame
        driver.switchTo().frame(we2);

        //Getting the Text From the Frame
        String text3 = driver.findElement(By.tagName("body")).getText();

        //Verifying the Text Whether its Matches with Expected Value or Not
        Assert.assertEquals(text3, "BOTTOM");

        //Again Switching to the Top Frame
        driver.switchTo().parentFrame();

        //Again Switching to the Parent Frame
        driver.switchTo().parentFrame();

        //Hereafter That the Window Doesnt Have Any Title Itself so We Cant Verify the Title of the Page
        Assert.assertEquals(driver.getTitle(), "");
    }

    @AfterTest
    //Function to Close the Chrome Browser
    public void closeBrowser(){

        //Closing the All Windows And Also Instance of the Chrome Browser
        driver.quit();
    }
}
