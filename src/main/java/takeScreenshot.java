import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.*;

/**
 * Created by Pawl on 1/29/2017.
 */
public class takeScreenshot{
    public static void takeScreenShoot(WebDriver w, String path){

        TakesScreenshot shot = ((TakesScreenshot)w);
        File file = shot.getScreenshotAs(OutputType.FILE);
        File destination = new File(path);
        try {
            FileUtils.copyFile(file, destination);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
