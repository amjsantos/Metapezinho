package br.ce.antonio.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class InstalarAPK {

	@Test
	public void deveInstalarAPK() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
//		desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
//		desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:/Users/ajesussa/eclipse-workspace/TesteAppium/src/main/resources/CTAppium-1-1.apk");
			
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	
		driver.quit();
	}
}
