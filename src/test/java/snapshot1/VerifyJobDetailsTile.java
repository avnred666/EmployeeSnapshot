package snapshot1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by anambood on 10/22/2016.
 */


public class VerifyJobDetailsTile {
    private WebDriver driver;

    public VerifyJobDetailsTile (WebDriver driver)
    {
        this.driver = driver;
    }

    public void jobDetailsTile ()
    {
        String expectedTileLabel = "Job Details";
        String actualTileLabel = driver.findElement(By.id("PTNUI_LAND_REC_GROUPLET_LBL$0")).getText();
        assertEquals(expectedTileLabel,actualTileLabel);

       /* String expectedYearsOfService = "30.2";
        String actualYearsOfservice = driver.findElement(By.id("PTGP_APP_WRK_PTGP_TILE_KPI_1")).getText();
        assertEquals(expectedYearsOfService,actualYearsOfservice);

        String expectedYearsInCurrentJob = "8.0";
        String actualYearsInCurrentJob = driver.findElement(By.id("PTGP_APP_WRK_PTGP_TILE_KPI_2")).getText();
        assertEquals(expectedYearsInCurrentJob,actualYearsInCurrentJob);*/

    }

    public void jobDetailsModal ()
    {
        driver.findElement(By.id("PTNUI_LAND_REC_GROUPLET_LBL$0")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.switchTo().frame("ptModFrame_0");
        String expectedPositionTitle = "Senior Accounting Manager";
        String actualPositionTitle = driver.findElement(By.id("POSITION_VIEW_DESCR")).getText();
        assertEquals(expectedPositionTitle,actualPositionTitle);

    }
}
