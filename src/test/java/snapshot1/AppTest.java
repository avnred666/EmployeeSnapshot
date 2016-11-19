package snapshot1;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by anambood on 10/17/2016.
 */
public class AppTest {
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
}
