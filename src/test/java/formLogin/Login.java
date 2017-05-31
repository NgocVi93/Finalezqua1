package formLogin;

import static org.testng.Assert.assertEquals;

import com.sun.jna.platform.win32.OaIdl;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
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
   /** @Test(priority = 1) // priority để ưu tiên case nào chạy trước
    // case này mình test trường không nhập uSername & password
    public void SignInWithAccountNull() {
        System.out.println(driver.currentActivity());

        // Lấy Activity của màn hình hiện tại
     //   String currentScreen = driver.currentActivity();


        //  driver.findElementById("vn.com.misa.sothuchi:id/btnIntroLogin").click();

        //  String screenSignIn = driver.currentActivity();

        // So sánh để kiểm tra có chuyển màn hình hay không
        //    assertNotEquals(currentScreen, screenSignIn);

        // Nhập user name
        driver.findElementById("ezqua.dfm.com.prototype:id/txtUsername").sendKeys("");

        // Nhập mật khẩu
        driver.findElementById("ezqua.dfm.com.prototype:id/txtPassword").sendKeys("");

        // Nhấn nút sign in
        driver.findElementById("ezqua.dfm.com.prototype:id/btnLogin").click();
        //String screenSignIn = driver.currentActivity();
        // assertNotEquals(currentScreen, screenSignIn);
        //  WebDriverWait wait = new WebDriverWait(driver, 30);

        System.out.print("Pass test case 1");

    }
    @Test(priority =2)
    public void SignUP() throws InterruptedException {
//ten dang nhap: ezqua.dfm.com.prototype:id/edtUsername
        // mk:ezqua.dfm.com.prototype:id/edtPassword
        //nhap lai mk: ezqua.dfm.com.prototype:id/edtRePassword
        //email: ezqua.dfm.com.prototype:id/edtEmail
        // button đăng kí: ezqua.dfm.com.prototype:id/btnReg

        System.out.println(driver.currentActivity());
        String currentScreen = driver.currentActivity();


        //chuyen qua man hinh Reg
        driver.findElementById("ezqua.dfm.com.prototype:id/tvRegister").click();
        // fill đay đu các textbox

        driver.findElementById("ezqua.dfm.com.prototype:id/edtUsername").sendKeys("v");
        driver.findElementById("ezqua.dfm.com.prototype:id/edtPassword").sendKeys("");
        driver.findElementById("ezqua.dfm.com.prototype:id/edtRePassword").sendKeys("");
        driver.findElementById("ezqua.dfm.com.prototype:id/edtEmail").sendKeys("");

        // So sanh 2 màn h
        //Click button dang kyinh & so sanh 2 man hinh
        try {
            driver.findElementById("ezqua.dfm.com.prototype:id/btnReg").click();
            System.out.print("ok passed SignUP");


        } catch (Exception a) {
            System.out.print("error case 3. Chưa chuyển màn hình được.");

        }
        ;
    }*/
        @Test(priority = 3)
    //  case này mình test trường hợp đăng nhập với account đúng
    public void SignInWithcorrectAccount() throws InterruptedException {
        String currentScreen = driver.currentActivity();


        // Nhập user name
        driver.findElementById("ezqua.dfm.com.prototype:id/txtUsername").clear();
        driver.findElementById("ezqua.dfm.com.prototype:id/txtUsername").sendKeys("v");

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
//hthrh
    @Test(priority=4)
    public void TestScreens() throws InterruptedException {
        try {
        String currentScreen = driver.currentActivity();
        driver.findElementById("ezqua.dfm.com.prototype:id/edtNewFeedAdd").click();
        driver.findElementById("ezqua.dfm.com.prototype:id/edtNewFeedAdd").sendKeys("Auto fill from intelli");

        driver.findElementById("ezqua.dfm.com.prototype:id/btnAddNewFeed").click();


        driver.findElementById("ezqua.dfm.com.prototype:id/btnDrawer").click();
        driver.findElementById("ezqua.dfm.com.prototype:id/main_btnInven").click();


       // String TraoDoi = driver.currentActivity();

  //  assertNotEquals(currentScreen, TraoDoi);
            System.out.print("Passed Test Case 4. Các mand hình");
}
        catch (Exception a  )
        {
            System.out.print("Failed");
        }
    }




    @AfterTest
    public void afterTest() {
        // thoát sau khi chạy hết test case
       // driver.quit();
    }
}


