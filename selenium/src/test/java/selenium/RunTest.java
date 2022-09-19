package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.stream.ImageInputStream;

public class RunTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.get("https://demo.guru99.com/v4");
        Thread.sleep(2);
        driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr439533");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("sypevyd");
        Thread.sleep(2);
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        Thread.sleep(2);


    }



}
