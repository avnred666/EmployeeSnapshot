package snapshot1;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.util.UUID;

/**
 * Created by anambood on 10/23/2016.
 */
public class ScreenShotRule implements MethodRule {
    private WebDriver driver;

    public ScreenShotRule (WebDriver driver)
    {
        this.driver = driver;
    }

    public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, final Object o)
    {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    statement.evaluate();
                }
                catch (Throwable throwable){
                    captureScreenshot (frameworkMethod.getName());
                    throw throwable;
                }
            }
            public void captureScreenshot(String fileName){
                try {
                    new File("D:/Test/").mkdirs();
                    fileName += UUID.randomUUID().toString();
                    FileOutputStream out = new FileOutputStream("D:/Test/"+fileName+".png");
                    out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
                    out.close();

                    /*File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    //fileName += UUID.randomUUID().toString();
                    File targetFile = new File("D:/Test/"+fileName+".png");
                    FileUtils.copyFile(scrFile, targetFile);
                    System.out.println("fileName = [" + fileName + "]"); */
                }
                catch (Exception E){
                    //do nothing
                }
            }
        };
    }
}
