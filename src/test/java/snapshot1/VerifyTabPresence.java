package snapshot1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by anambood on 10/22/2016.
 */
public class VerifyTabPresence {
    private WebDriver driver;

    public VerifyTabPresence (WebDriver driver)
    {
        this.driver = driver;
    }

    public void doesTabsExist ()
    {
        int SCROLL = 2;
        String [] expectedTabNames = {"Summary","Promotion Readiness"};
        String [] actualTabNames = new String[2];
        for (int I= 0;I < SCROLL; ++I)
        {
            actualTabNames[I]= driver.findElement(By.id("PTGP_STEP_DVW_PTGP_STEP_LABEL$"+I)).getText();
            System.out.println(actualTabNames[I]);

        }
        assertArrayEquals(expectedTabNames,actualTabNames);
    }
}
