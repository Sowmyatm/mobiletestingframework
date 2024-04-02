package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSBy;

public class LoginPage {
	
	public LoginPage(AppiumDriver<MobileElement> driver) {
		
		PageFactory.initElements(driver, LoginPage.class);
	}
	
//@iOSBy(id="")//for ios

@AndroidFindBy(id="")
	public MobileElement username;

}