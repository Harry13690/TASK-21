package task_21;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Question_1 {

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
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    @Test
    //Function to Insert the Text
    public void insertText(){

        //Clicking on X Button to Remove the Pop-up Message
        driver.findElement(By.xpath("//div[@class='tox-icon']")).click();

        //Switching to Respective Frame
        driver.switchTo().frame(0);

        //Locating the Web Element Using P Tagname
        WebElement we = driver.findElement(By.tagName("p"));

        //Creating an Instance for JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Clearing the Text in the Textbox Field
        js.executeScript("arguments[0].innerHTML = '';",we);

        //Insert the Data in the Textbox Field
        js.executeScript("arguments[0].innerHTML = arguments[1];",we,"Hello People");
    }

    @AfterTest
    //Function to Close the Chrome Browser
    public void closeBrowser(){

        //Closing the All Windows And Also Instance of the Chrome Browser
        driver.quit();
    }
}
