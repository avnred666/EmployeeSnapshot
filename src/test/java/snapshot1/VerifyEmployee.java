package snapshot1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by anambood on 10/22/2016.
 */

public class VerifyEmployee {
    private WebDriver driver;

    public VerifyEmployee(WebDriver driver)
    {
        this.driver = driver;
    }

    public void verifyHeaderBanner()
    {
        String expectedEmpName = "Rosanna Channing";
        String actualEmpName = driver.findElement(By.id("DERIVED_HR_EPH_NAME_DISPLAY1")).getText();
        assertEquals(expectedEmpName,actualEmpName);

        String expectJobTitle = "Senior Accounting Manager";
        String actualJobTitle = driver.findElement(By.id("DERIVED_HR_EPH_TITLE_DESCR1")).getText();
        assertEquals(expectJobTitle,actualJobTitle);

        boolean imageExists = driver.findElement(By.id("DERIVED_HRCD_PR_EMPLOYEE_PHOTO")).isDisplayed();
        assertTrue(imageExists);

    }
}
