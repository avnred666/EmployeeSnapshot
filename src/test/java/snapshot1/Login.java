package snapshot1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by anambood on 10/17/2016.
 */

public class Login {
    private WebDriver driver;
    private String baseUrl;

    public Login(WebDriver driver)
    {
        this.driver = driver;
        baseUrl="http://slc07ogh.us.oracle.com:8000/h920paxx/signon.html";
        driver.get(baseUrl);
    }

    public SnapshotEmployeeSelect logApp ()
    {
        WebDriverWait wait = new WebDriverWait(driver,100);
        wait.until(ExpectedConditions.titleIs("Oracle PeopleSoft Sign-in"));
        driver.findElement(By.id("userid")).clear();
        driver.findElement(By.id("userid")).sendKeys("PS");
        driver.findElement(By.id("pwd")).clear();
        driver.findElement(By.id("pwd")).sendKeys("PS");
        Select langSelector = new Select(driver.findElement(By.name("ptlangsel")));
        langSelector.selectByValue("ENG");
        driver.findElement(By.name("Submit")).click();

       // WebDriverWait wait = new WebDriverWait(driver,10);
        // wait.until(ExpectedConditions.titleIs("My Homepage"));

        String title = driver.getTitle();
        if (!title.equals("My Homepage")){
            throw new WrongPageException("Incorrect page for Homepage");
        }
        return new SnapshotEmployeeSelect(driver);
    }

}
