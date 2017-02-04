
/**
 * Created by Pawl on 1/8/2017.
 */

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;

public class test1 {

    private WebDriver driver;
      private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(test1.class);


    @BeforeTest
    @Parameters("browser")
    public void setUp(String browser)throws Exception{
        DOMConfigurator.configure("log4j.xml");
        if(browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Pawl\\Desktop\\geckodriver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Pawl\\Desktop\\geckodriver\\chromedriver.exe");
            driver = new ChromeDriver();
        }

    }

    @Test(priority = 0)
    @Parameters("browser")
    public void ok(String browser) {

        Assert.assertTrue(true);
        driver.get("http://onet.pl");
       log.info("page is displayed "+driver.getTitle());
        takeScreenshot.takeScreenShoot(driver,"C:\\Users\\Pawl\\Desktop\\geckodriver\\screenshots\\"+browser+".jpg");
        log.info("Screenshot taken for "+browser);
      //  log.debug("ll");

    }
    @Test(priority = 1)
    public void nextIssue_toTest( ){
        Assert.assertTrue(false);


    }
    @AfterMethod
    @Parameters("browser")
    public void whenFailTest(ITestResult result, String browser)throws IOException{
        if(result.getStatus()==ITestResult.FAILURE){
            File screenshotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("C:\\Users\\Pawl\\Desktop\\geckodriver\\screenshots\\"+browser+"_failure.jpg"));
        }

    }
    @AfterTest
    public void oks(){

        Assert.assertFalse(false);
        driver.quit();
    }
}
