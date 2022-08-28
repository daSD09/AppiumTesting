package com.appium;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AmazonAutomation {

	public static void main(String[] args) {

		try {
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("adbExecTimeout", 90000);
			desiredCapabilities.setCapability("appWaitDuration", 50000);
			desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
			desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
			desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "MyDevice");
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			AndroidDriver driver = new AndroidDriver(url, desiredCapabilities);
			Duration timeout = null;
			WebDriverWait wait = new WebDriverWait(driver, timeout.ofSeconds(120));
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@content-desc = 'Amazon Shopping']")).click();
			System.out.println("User entered into amazon app.");
			Thread.sleep(5000);

			driver.findElement(By.id("com.amazon.mShop.android.shopping:id/chrome_action_bar_search_disabled")).click();
			System.out.println("User clicked the search button.");
			Thread.sleep(3000);

			driver.findElement(By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text"))
					.sendKeys("Mobile Phone");
			System.out.println("User entered 'mobile phones' in search box.");
			Thread.sleep(3000);

			driver.findElement(By.id("com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text")).click();

			System.out.println("User selected 'mobile phones' from dropdown.");
			Thread.sleep(7000);

			driver.findElement(By.xpath("//*[@text = 'Filters']")).click();
			System.out.println("User clicked on filters.");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text = 'Close']")));
			// Thread.sleep(7000);

			// @SuppressWarnings("deprecation")
			WebElement os = driver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().description(\"Cell Phone Operating System\").instance(0))"));
			// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text =
			// 'Close']")));
			System.out.println("The iOS element is present in the location : " + os.getLocation());
			Thread.sleep(10000);

			driver.findElement(By.xpath("//*[@text = 'iOS']")).click();
			System.out.println("User selected 'iOS' from the filter.");
			Thread.sleep(3000);

			driver.findElement(By.xpath("//*[@text = 'Close']")).click();
			System.out.println("User closed the filter window.");
			Thread.sleep(3000);

			WebElement webElement = (WebElement) driver.findElement(By.xpath(
					"//*[@text='Simple Mobile Apple iPhone SE 5G (3rd Generation), 64GB, Black - Prepaid Smartphone, (SMAPISE3G64BKP5)']"));

			String type = webElement.getText();
			Thread.sleep(3000);

			driver.findElement(By.xpath(
					"//*[@text = 'Simple Mobile Apple iPhone SE 5G (3rd Generation), 64GB, Black - Prepaid Smartphone, (SMAPISE3G64BKP5)']"))
					.click();

			System.out.println("User clicked the relevant mobile phone.");
			Thread.sleep(3000);
			System.out.println("YOUR RESULT: ");
			System.out.println("\n");
			System.out.println("Iphone Model: " + type);

			if (driver.findElement(By.xpath("//*[@text='Enhance your purchase']")).isDisplayed()) // scroll till price
			{
				WebElement trade = driver.findElement(By.xpath("//*[@text='Trade In']"));// tradein
				if (trade.isDisplayed()) {
					WebElement scrollRate = driver.findElement(MobileBy.AndroidUIAutomator(
							"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Price:\"))"));
					WebElement cost = driver.findElement(By.xpath("//*[@text='$379.99']"));
					String price = cost.getText();
					Thread.sleep(3000);
					System.out.println("iPhone price:  " + price);
					System.out.println(" the iphone model name and its price is printed");
				}

				else {
					WebElement cost = driver.findElement(By.xpath("//*[@text='$379.99']"));
					String price = cost.getText();
					Thread.sleep(3000);
					System.out.println("iPhone price:  " + price);
					System.out.println("the iphone model name and its price is printed");
				}
			} else {
				System.out.println("iPhone currently unavailable!");
				WebElement scrollRate = driver.findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Currently unavailable.\"))"));
				Thread.sleep(3000);
				System.out.println(scrollRate.getText());
				System.out.println("Testing done");
			}
			driver.quit();
		} catch (Exception e) {
			System.out.println("Exception Found!!!! " + e);
		}

	}

}
