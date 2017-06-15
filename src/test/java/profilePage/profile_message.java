package profilePage;
import static com.thoughtworks.selenium.SeleneseTestCase.seleniumEquals;
import static junit.framework.Assert.failNotSame;
import static org.testng.Assert.assertEquals;

import com.sun.jna.platform.win32.OaIdl;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;


import org.openqa.selenium.*;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;
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
import java.util.HashMap;
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
        //Máy ảo
        cap.setCapability("appActivity", "ezqua.dfm.com.prototype.activity.LoginActivity");
        cap.setCapability("appWaitActivity", "ezqua.dfm.com.prototype.activity.LoginActivity', ezqua.dfm.com.prototype.activity.LoginActivity");

        cap.setCapability("app", Ezqua);
        // khai báo platform
        cap.setCapability(CapabilityType.VERSION, "5.0.0");
        // khai báo deviceName
       cap.setCapability("deviceName", "192.168.56.101:5555");


        /*Máy thật dùng
       // cap.setCapability("appActivity", "ezqua.dfm.com.prototype.activity.LoginActivity");
            cap.setCapability("appWaitActivity", "ezqua.dfm.com.prototype.activity.LoginActivity',ezqua.dfm.com.prototype.activity.LoginActivity");
        cap.setCapability(CapabilityType.VERSION, "6.0.1");
        // khai báo deviceName
        cap.setCapability("deviceName", "3300a7537024b357");
        */

         driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);

    }



    @Test(priority =1)
    public void CheckCaseSendText() throws InterruptedException {
        String currentScreen = driver.currentActivity();

        String screenSignIn = driver.currentActivity();


        //Nhập user name
        driver.findElementById("ezqua.dfm.com.prototype:id/txtUsername").sendKeys("vipham");

        // Nhập mật khẩu
        driver.findElementById("ezqua.dfm.com.prototype:id/txtPassword").sendKeys("");

        // Nhấn nút sign in
        driver.findElementById("ezqua.dfm.com.prototype:id/btnLogin").click();




        //Click allow access photo, media and f
 //       driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
        //permission_deny_button
        Thread.sleep(4000);
        //Allow access take pictures
  //          driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();

        driver.findElementById("ezqua.dfm.com.prototype:id/btnDrawer").click();
        driver.findElementById("ezqua.dfm.com.prototype:id/main_btnPersonal").click();


        driver.findElementById("ezqua.dfm.com.prototype:id/tvStatus").click();
        driver.findElementById("ezqua.dfm.com.prototype:id/edtChat").sendKeys("hello");

        driver.findElementById("ezqua.dfm.com.prototype:id/btnSend").click();

        //   driver. navigate().back();

        List<MobileElement> listMessage = driver.findElementsById("ezqua.dfm.com.prototype:id/txtChatMess");


        for (int i = 0; i < listMessage.size(); i++) {
            String s = listMessage.get(i).getText();
            String expected="hihihehe";
            System.out.println(s);

          //  assertEquals(s,"abc");
            if(s.equals(expected))
            {
                System.out.println("Passed "+" tai vi tri "+i+"\n");
            }
            else
                System.out.println("Failed "+" vi tri "+i+"\n");


        }

    }
    @Test(priority =2)
    public void CheckCaseSendEmoji() throws InterruptedException
    {

        driver.findElementById("ezqua.dfm.com.prototype:id/btnEmoji").click();

    int x = driver.findElement(MobileBy.id("ezqua.dfm.com.prototype:id/emojicon_icon")).getLocation().getX();
    int y = driver.findElement(MobileBy.id("ezqua.dfm.com.prototype:id/emojicon_icon")).getLocation().getY();

    MultiTouchAction multiTouch = new MultiTouchAction(driver);
    TouchAction action1 = new TouchAction(driver);
    TouchAction action2 = new TouchAction(driver);
    TouchAction action3 = new TouchAction(driver);
    action1.press(x + 5, y + 5).waitAction(100).release(); //3.5sec for sure, 2 pixels inside el
    action2.press(x + 300, y + 600).waitAction(1000).release(); //3.5sec for sure, 4 pixels inside el

    multiTouch.add(action1).add(action2).perform();
    Thread.sleep(4000);

        driver.findElementById("ezqua.dfm.com.prototype:id/btnSend").click();


    }
    @Test(priority =3)
    public void CheckCaseSendTextAndemoji() throws InterruptedException
    {

        driver.findElementById("ezqua.dfm.com.prototype:id/tvStatus").click();
        driver.findElementById("ezqua.dfm.com.prototype:id/edtChat").sendKeys("Send Text & Emoji");
        driver.findElementById("ezqua.dfm.com.prototype:id/btnSend").click();

        int x = driver.findElement(MobileBy.id("ezqua.dfm.com.prototype:id/emojicon_icon")).getLocation().getX();
        int y = driver.findElement(MobileBy.id("ezqua.dfm.com.prototype:id/emojicon_icon")).getLocation().getY();

        MultiTouchAction multiTouch = new MultiTouchAction(driver);
        TouchAction action1 = new TouchAction(driver);
        TouchAction action2 = new TouchAction(driver);
        TouchAction action3 = new TouchAction(driver);
        action1.press(x + 5, y + 5).waitAction(100).release(); //3.5sec for sure, 2 pixels inside el
        action2.press(x + 300, y + 600).waitAction(1000).release(); //3.5sec for sure, 4 pixels inside el

        multiTouch.add(action1).add(action2).perform();
        Thread.sleep(4000);

        driver.findElementById("ezqua.dfm.com.prototype:id/btnSend").click();


    }
    /*
    @Test(priority =2)
    public void addFriends() throws InterruptedException {
        String currentScreen = driver.currentActivity();

        driver.navigate().back();
        driver.findElementById("ezqua.dfm.com.prototype:id/fabContactPersonAdd").click();
    //    driver.findElementByClassName("android.widget.EditText").sendKeys("0987476321");
      //  driver.findElementByClassName("android.widget.Button").click();
        driver.lockDevice();
        //TouchAction touch=new TouchAction(driver);
       // touch.press(10,20);

    WebElement element;

        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();

        scrollObject.put("direction", "down");
       // scrollObject.put("element", ((RemoteWebElement) element).getId("2558"));
        js.executeScript("mobile: scroll", scrollObject);


    }
    */
    @AfterTest
    public void afterTest()
    {

        driver.quit();

    }
}
