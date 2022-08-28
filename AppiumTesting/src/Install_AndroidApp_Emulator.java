import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
//to install app in emulator and simulator.
public class Install_AndroidApp_Emulator 
{

    public static void main(String[] args) throws MalformedURLException 
    {
        // TODO Auto-generated method stub
        try 
        {            
            DesiredCapabilities dc= new DesiredCapabilities();
            dc.setCapability("uiautomator2ServerInstallTimeout" , 90000);
            dc.setCapability("appWaitforLaunch" , "false");
            dc.setCapability("adbExecTimeout" , 90000);
            dc.setCapability("appWaitDuration" , 50000);
            dc.setCapability("androidInstallTimeout" , 90000);
            dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
            dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
            dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
            dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");
            dc.setCapability(MobileCapabilityType.APP,"C:\\Users\\SHRADAS\\Documents\\capg study\\HSBC\\com.amazon.mShop.android.shopping_v24.12.6.100-1241228610_Android-8.0.apk");
            URL url = new URL("http://127.0.0.1:4723/wd/hub"); //localhost //127.0.0.1:4723
            AndroidDriver driver = new AndroidDriver(url, dc);
            System.out.println("Application successfully installed");
            driver.quit();
        }

        catch(Exception e)
        {
            System.out.println("Exception Found!!!! "+e);
        }

    }

}