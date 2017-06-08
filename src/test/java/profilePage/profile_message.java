package profilePage;
import static com.thoughtworks.selenium.SeleneseTestCase.seleniumEquals;
import static junit.framework.Assert.failNotSame;
import static org.testng.Assert.assertEquals;

import com.sun.jna.platform.win32.OaIdl;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import javafx.scene.layout.Priority;
import org.openqa.selenium.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.management.monitor.Monitor;
import javax.xml.bind.Element;
import java.io.File;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import static com.thoughtworks.selenium.SeleneseTestCase.assertNotEquals;

/**
 * Created by sysadmin on 6/5/17.
 */
public class profile_message {
    AndroidDriver driver;


    String fileName = "app-debug.apk";
    File Ezqua = new File("src/main/resources/" + fileName);


    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("appActivity", "ezqua.dfm.com.prototype.activity.LoginActivity");
        cap.setCapability("appWaitActivity", "ezqua.dfm.com.prototype.activity.LoginActivity', ezqua.dfm.com.prototype.activity.LoginActivity");

        cap.setCapability("app", Ezqua);
        // khai báo platform
        cap.setCapability(CapabilityType.VERSION, "5.0.0");
        // khai báo deviceName
        cap.setCapability("deviceName", "192.168.56.101:5555");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

    }

    @Test(priority =1)
    public void testGetMessage() throws InterruptedException {
        String currentScreen = driver.currentActivity();

        String screenSignIn = driver.currentActivity();


        //Nhập user name
        driver.findElementById("ezqua.dfm.com.prototype:id/txtUsername").sendKeys("vipham");

        // Nhập mật khẩu
        driver.findElementById("ezqua.dfm.com.prototype:id/txtPassword").sendKeys("");

        // Nhấn nút sign in
        driver.findElementById("ezqua.dfm.com.prototype:id/btnLogin").click();

        driver.findElementById("ezqua.dfm.com.prototype:id/btnDrawer").click();

        driver.findElementById("ezqua.dfm.com.prototype:id/main_btnPersonal").click();


        Thread.sleep(5000);


        driver.findElementById("ezqua.dfm.com.prototype:id/tvStatus").click();
        driver.findElementById("ezqua.dfm.com.prototype:id/edtChat").sendKeys("abdr");

        driver.findElementById("ezqua.dfm.com.prototype:id/btnSend").click();


        //   driver. navigate().back();

        List<MobileElement> eles=driver.findElementsById("ezqua.dfm.com.prototype:id/txtChatMess");


        for (int i = 0; i <eles.size(); i++) {
            String s;


            assertEquals(eles.get(6).getText(), "abdr","Passed");

        }

   /* @Test(priority = 2)
    public void TestScreens() throws InterruptedEixception
    {
        try
        {
            String currentScreen = driver.currentActivity();
            driver.findElementById("ezqua.dfm.com.prototype:id/edtNewFeedAdd").click();
            driver.findElementById("ezqua.dfm.com.prototype:id/edtNewFeedAdd").sendKeys("Auto fill from intellij ");

            driver.findElementById("ezqua.dfm.com.prototype:id/btnAddNewFeed").click();


            driver.findElementById("ezqua.dfm.com.prototype:id/btnDrawer").click();
            driver.findElementById("ezqua.dfm.com.prototype:id/main_btnInven").click();
            driver. navigate().refresh();


            // String TraoDoi = driver.currentActivity();

            //  assertNotEquals(currentScreen, TraoDoi);
            System.out.print("Passed Test Case 4. Các man hình");
        }
            catch (Exception a)
         {
            System.out.print("Failed");

         }*/
    }

    @AfterTest
    public void afterTest()
    {

        driver.quit();

    }
}
