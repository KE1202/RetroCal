package retorocal;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	public static AndroidDriver<AndroidElement> create(String deviceName, String AutoName, String UiAutomatorName,
			boolean isRealDevice, boolean isApk, String apkName) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);

		if (!isRealDevice || isApk) {
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		}
		if (isApk) {
			File f = new File("src");
			File fs = new File(f, "RetroCal.apk");
			//File fs = new File (f, "GoodweatherApp.apk");
			capabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		} else {
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		}

		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		return driver;

	}
	
	public void doSomething() {
		
	}

}
