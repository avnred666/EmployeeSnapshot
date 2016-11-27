package snapshot1;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by anambood on 10/23/2016.
 */
public class AllTestsInOneTest_IE {
    private static WebDriver driver;

    @Rule
    public ScreenShotRule screenshotRule = new ScreenShotRule (driver);

    @BeforeClass
    public static void setUp () throws Exception {
        System.setProperty("webdriver.ie.driver","src/test/resources/drivers/IEDriverServer.exe");

        /*DesiredCapabilities caps = DesiredCapabilities.internetExplorer();

        caps.setCapability(
                InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                true);*/

        // Launch Internet Explorer
        driver = new InternetExplorerDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
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
