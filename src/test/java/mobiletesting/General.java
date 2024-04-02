package mobiletesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
//import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class General {
 	
	private static final PerformsTouchActions driver = null;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	
	DesiredCapabilities dc = new DesiredCapabilities();
	dc.setCapability(AndroidMobileCapabilityType.VERSION, "13");
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
	dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 6a");
//	dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.solodroid.solomerce");
//	dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,".activities.ActivitySplash");
	dc.setCapability("unlockType", "pin");
	dc.setCapability("unlockKey", "1986");
	dc.setCapability("browserName", "chrome");
	//dc.setCapability(MobileCapabilityType.NO_RESET, true);
	 
	
	URL url = new URL("http://127.0.0.1:4723/wd/hub");
	
	
	AndroidDriver<MobileElement>driver = new AndroidDriver<MobileElement>(url,dc);
	
	
	System.out.println("App launched");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	driver.get("");
	
//	driver.findElement(By.xpath("(//*[@resource-id='com.solodroid.solomerce:id/icon'])[2]")).click();
//	System.out.println("Element clicked");
//	if(driver.getOrientation().equals(ScreenOrientation.LANDSCAPE))
//	driver.rotate(ScreenOrientation.PORTRAIT);
//	
//	if(driver.isDeviceLocked()) {
//		driver.unlockDevice();
//		Thread.sleep(5000);
//		driver.lockDevice();
//		
//	}
	
	Thread.sleep(5000);
//	driver.runAppInBackground(Duration.ofSeconds(10));
	
	
	
	//swipe/scroll
	Dimension size=driver.findElement(By.id("")).getSize();
	int x=size.getWidth()/2;
	int y=size.getHeight()/2;
//	
//	
	WaitOptions wo =new WaitOptions();
	wo.withDuration(Duration.ofSeconds(1));
	
	//to swipe or scroll
	for(int i=0;i<=3;i++) {
	@Deprecated 
//		TouchAction action = new TouchAction(driver);
//		action.press(PointOption.point(520, 1970)).waitAction().moveTo(PointOption.point(520,305)).release().perform();
	
	
	
	TouchAction finger1 = new TouchAction(driver);
	//finger1.press(PointOption.point(520, 1970)).waitAction().moveTo(PointOption.point(520,305)).release().perform();
	//drag and drop
	finger1.press(PointOption.point(530,532)).waitAction(wo).moveTo(PointOption.point(34,45)).release();
	
	TouchAction finger2 = new TouchAction(driver);
	finger2.press(PointOption.point(520, 2053))
	.waitAction(wo).moveTo(PointOption.point(520,305)).release();
	
	MultiTouchAction mta = new MultiTouchAction(driver);
	mta.add(finger1).add(finger2).perform();
	
	
	//(//*[@resource-id='com.solodroid.solomerce:id/product_name'])[1]
	//*[@text='Samsung Galaxy S10 - Black']
	
	MobileElement firstTile=driver.findElementByXPath("//*[@text='Samsung Galaxy S10 - Black']");
	
	String actualText =firstTile.getText();
	firstTile.click();
	Thread.sleep(2000);
	driver.findElementById("com.solodroid.solomerce:id/btn_add_cart").click();
	Thread.sleep(2000);
	driver.findElementById("com.solodroid.solomerce:id/userInputDialog").sendKeys("1");
	Thread.sleep(2000);
	//driver.findElementById("android:id/button1").click();
	//Thread.sleep(2000);
	driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"android:id/button1\")").click();
	driver.findElement(By.xpath("//android.widget.Textview[@content-desc='My Cart'][2]")).click();
	Thread.sleep(2000);
	String expectedText=driver.findElementByXPath("//*[@Text='Samsung Galaxy $10 - Black']").getText();
	Assert.assertEquals(actualText, expectedText);
//	MobileElement secondTile= driver.findElementById("com.solodroid.solomerce:id/product_name");
//	String expected = secondTile.getText();
//	Assert.assertEquals(actualText, expected);

	driver.findElementByAndroidUIAutomator("new UiSelector().resourceID(\"android:id/button1\")").click();
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UISelector().resourceID(\"scrollable:container\"))"
			+".scrollIntoView(new UiSelector().textContains(\"Animal Jumpsuit\"))").click();
//	//Scrolling
//	new UiScrollable(new UISelector().resourceID(\"scrollable:container\")).scrollIntoView(new UiSelector().resourceID(\"element\")).click();
//	
	
	
}
	}
}