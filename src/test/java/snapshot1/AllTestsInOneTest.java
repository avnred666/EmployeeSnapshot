package snapshot1;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by anambood on 10/23/2016.
 */
public class AllTestsInOneTest {
    private static WebDriver driver;

    @Rule
    public ScreenShotRule screenshotRule = new ScreenShotRule (driver);

    @BeforeClass
    public static void setUp () throws Exception {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }


    @Test
    public void verifySnapshotHome(){
        Login login = new Login(driver);
        SnapshotEmployeeSelect snap = login.logApp();
        snap.selectSnapshotTile();
        VerifyEmployee verify = snap.selectEmployeeForHeaderTest();
        verify.verifyHeaderBanner();
    }

    @Test
    public void verifyTabPresence(){
        Login login = new Login(driver);
        SnapshotEmployeeSelect snap = login.logApp();
        snap.selectSnapshotTile();
        VerifyTabPresence tab = snap.selectEmployeeForTabTest();
        tab.doesTabsExist();
    }

    @Test
    public void verifyJobDetails(){
        Login login = new Login(driver);
        SnapshotEmployeeSelect snap = login.logApp();
        snap.selectSnapshotTile();
        VerifyJobDetailsTile jobDetails = snap.selectEmployeeForJobDetails();
        jobDetails.jobDetailsTile();
        jobDetails.jobDetailsModal();
    }
}
