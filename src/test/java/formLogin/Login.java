package formLogin;

import static com.thoughtworks.selenium.SeleneseTestCase.seleniumEquals;
import static org.testng.Assert.assertEquals;

import com.sun.jna.platform.win32.OaIdl;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.management.monitor.Monitor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import static com.thoughtworks.selenium.SeleneseTestCase.assertNotEquals;

/**
 * Created by sysadmin on 5/29/17.
 */
public class Login {
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

   /*   @Test(priority = 2)
      // case này mình test trường không nhập uSername & password
      public void SignInWithAccountNull() {
      System.out.println(driver.currentActivity());

      // Lấy Activity của màn hình hiện tại
        String currentScreen = driver.currentActivity();



    String screenSignIn = driver.currentActivity();

     //So sánh để kiểm tra có chuyển màn hình hay không
      //  assertNotEquals(currentScreen, screenSignIn);

     //Nhập user name
     driver.findElementById("ezqua.dfm.com.prototype:id/txtUsername").sendKeys("");

     // Nhập mật khẩu
      driver.findElementById("ezqua.dfm.com.prototype:id/txtPassword").sendKeys("");

      // Nhấn nút sign in
      driver.findElementById("ezqua.dfm.com.prototype:id/btnLogin").click();
      //String screenSignIn = driver.currentActivity();
      // assertNotEquals(currentScreen, screenSignIn);
       WebDriverWait wait = new WebDriverWait(driver, 10);

      System.out.print("Pass test case 1");

      }
      @Test(priority =1)
      public void SignUP() throws InterruptedException {

      System.out.println(driver.currentActivity());
      String currentScreen = driver.currentActivity();


          try {
      driver.findElementById("ezqua.dfm.com.prototype:id/tvRegister").click();
      // fill đay đu các textbox

      driver.findElementById("ezqua.dfm.com.prototype:id/edtUsername").sendKeys("abcd");
      driver.findElementById("ezqua.dfm.com.prototype:id/edtPassword").sendKeys("");
      driver.findElementById("ezqua.dfm.com.prototype:id/edtRePassword").sendKeys("");
      driver.findElementById("ezqua.dfm.com.prototype:id/edtEmail").sendKeys("");


      driver.findElementById("ezqua.dfm.com.prototype:id/btnReg").click();
      System.out.print("ok passed SignUP");


      } catch (Exception a) {
      System.out.print("error case 3. Chưa chuyển màn hình được.");

      }

      }

    @Test(priority = 3)
    //  case này mình test trường hợp đăng nhập với account đúng
    public void SignInWithcorrectAccount() throws InterruptedException {
        String currentScreen = driver.currentActivity();


        // Nhập user name
        driver.findElementById("ezqua.dfm.com.prototype:id/txtUsername").clear();
        driver.findElementById("ezqua.dfm.com.prototype:id/txtUsername").sendKeys("aaaa");

        // Nhập mật khẩu
        driver.findElementById("ezqua.dfm.com.prototype:id/txtPassword").clear();
        driver.findElementById("ezqua.dfm.com.prototype:id/txtPassword").sendKeys("");

        // Nhấn nút sign in
        driver.findElementById("ezqua.dfm.com.prototype:id/btnLogin").click();
        String screenSignIn = driver.currentActivity();
        assertNotEquals(currentScreen, screenSignIn);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("ezqua.dfm.com.prototype:id/btnDrawer")));
        System.out.print("Pass test case 3. Nhập sai account SignIn \n");
        //   FileOutputStream out = new FileOutputStream(new File("abc.xls"));

    }

    @Test(priority = 4)
    public void TestScreens() throws InterruptedException {
        try {
            String currentScreen = driver.currentActivity();
            driver.findElementById("ezqua.dfm.com.prototype:id/edtNewFeedAdd").click();
            driver.findElementById("ezqua.dfm.com.prototype:id/edtNewFeedAdd").sendKeys("Auto fill from intelli");

            driver.findElementById("ezqua.dfm.com.prototype:id/btnAddNewFeed").click();


            driver.findElementById("ezqua.dfm.com.prototype:id/btnDrawer").click();
            driver.findElementById("ezqua.dfm.com.prototype:id/main_btnInven").click();
            driver. navigate().refresh();


            // String TraoDoi = driver.currentActivity();

            //  assertNotEquals(currentScreen, TraoDoi);
            System.out.print("Passed Test Case 4. Các mand hình");
        } catch (Exception a) {
            System.out.print("Failed");
        }
    }

*/
    @Test(priority =5)
    public void TestABC() throws InterruptedException  {
        String currentScreen = driver.currentActivity();

        String screenSignIn = driver.currentActivity();


        //Nhập user name
        driver.findElementById("ezqua.dfm.com.prototype:id/txtUsername").sendKeys("vipham");

        // Nhập mật khẩu
        driver.findElementById("ezqua.dfm.com.prototype:id/txtPassword").sendKeys("");

        // Nhấn nút sign in
        driver.findElementById("ezqua.dfm.com.prototype:id/btnLogin").click();

        System.out.print("Passed Login");

        driver.findElementById("ezqua.dfm.com.prototype:id/btnDrawer").click();

        driver.findElementById("ezqua.dfm.com.prototype:id/main_btnPersonal").click();

        driver.findElementById("ezqua.dfm.com.prototype:id/tvStatus").click();
        driver.findElementById("ezqua.dfm.com.prototype:id/edtChat").sendKeys("abc");

        driver.findElementById("ezqua.dfm.com.prototype:id/btnSend").click();

        WebDriverWait wait = new WebDriverWait(driver, 10);


       // driver. navigate().refresh();

        String message = driver.findElementById("ezqua.dfm.com.prototype:id/txtChatMess").getText();



        assertEquals(message, "abc", "passed");


//10

    }

    @AfterTest
    public void afterTest() {
        // thoát sau khi chạy hết test case
        driver.quit();

    }
}