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
         driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);

    }



    @Test(priority =1)
    public void testCheckMessage() throws InterruptedException {
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





        driver.findElementById("ezqua.dfm.com.prototype:id/tvStatus").click();
        driver.findElementById("ezqua.dfm.com.prototype:id/edtChat").sendKeys("drfe");

        driver.findElementById("ezqua.dfm.com.prototype:id/btnSend").click();



        //   driver. navigate().back();

        List<MobileElement> listMessage = driver.findElementsById("ezqua.dfm.com.prototype:id/txtChatMess");


        for (int i = 0; i < listMessage.size(); i++) {
            String s=listMessage.get(i).getText();
            assertEquals(s, "drfe", "Passed");
            i++;

        }




    }
 /*   @Test(priority =2)
    public void addFriends() throws InterruptedException {
        String currentScreen = driver.currentActivity();

        driver.navigate().back();
        driver.findElementById("ezqua.dfm.com.prototype:id/btnDrawer").click();

        driver.findElementById("ezqua.dfm.com.prototype:id/main_btnPersonal").click();
        driver.findElementByClassName("android.widget.ImageButton").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("0987476321");
        driver.findElementByClassName("android.widget.Button").click();



    }
    */



    @AfterTest
    public void afterTest()
    {

        driver.quit();

    }
}
