package snapshot1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by anambood on 10/21/2016.
 */
public class SnapshotEmployeeSelect {
    private WebDriver driver;

    public SnapshotEmployeeSelect (WebDriver driver)
    {
            this.driver = driver;
    }

    public void selectSnapshotTile ()
    {
            driver.findElement(By.cssSelector("[id^=PS_EE_SNAPSHOT]")).click();
            String title = driver.getTitle();
            if (!title.equals("Person Selector"))
            {
                throw new WrongPageException("Incorrect page for Snapshot Employee Select");
            }

    }
    public VerifyEmployee selectEmployeeForHeaderTest ()
    {
            driver.findElement(By.linkText("Rosanna Channing")).click();
            WebDriverWait wait = new WebDriverWait(driver,100);
            wait.until(ExpectedConditions.titleIs("Employee Snapshot"));
            return new VerifyEmployee(driver);
    }

    public VerifyTabPresence selectEmployeeForTabTest ()
    {
        driver.findElement(By.linkText("Rosanna Channing")).click();
        WebDriverWait wait = new WebDriverWait(driver,100);
        wait.until(ExpectedConditions.titleIs("Employee Snapshot"));
        return new VerifyTabPresence(driver);
    }

    public VerifyJobDetailsTile selectEmployeeForJobDetails ()
    {
        driver.findElement(By.linkText("Rosanna Channing")).click();
        WebDriverWait wait = new WebDriverWait(driver,100);
        wait.until(ExpectedConditions.titleIs("Employee Snapshot"));
        return new VerifyJobDetailsTile(driver);
    }
}
