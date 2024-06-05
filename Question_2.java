package task_21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Question_2 {

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
        driver.get("https://the-internet.herokuapp.com/windows");
    }


    @Test
    //Function to verify the Windows
    public void verifyWindows() {

        //Clicking on "Click Here" Button
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        //Getting All the Windows From the Browser and Storing in Set<>
        Set<String> ids = driver.getWindowHandles();

        //Converting the Set<> into List to Use GetIndex Method
        List<String> idl = new ArrayList<>(ids);

        //Switching to Second Window of the Browser
        driver.switchTo().window(idl.get(1));

        //Getting and Storing the Text From the Current Window
        String text1 = driver.findElement(By.tagName("h3")).getText();

        //Verifying the Text Whether its Matching with Expected Value or Not
        Assert.assertEquals(text1, "New Window");

        //Closing the Current Window
        driver.close();

        //Switching to First Window of the Browser
        driver.switchTo().window(idl.get(0));

        //Getting and Storing the Text From the Current Window
        String text2 = driver.findElement(By.tagName("h3")).getText();

        //Verifying the Text Whether its Matching with Expected Value or Not
        Assert.assertEquals(text2, "Opening a new window");
    }

    @AfterTest
    //Function to Close the Chrome Browser
    public void closeBrowser(){

        //Closing the All Windows And Also Instance of the Chrome Browser
        driver.quit();
    }
}
