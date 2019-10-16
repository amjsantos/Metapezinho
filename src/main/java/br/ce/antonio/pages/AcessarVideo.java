package br.ce.antonio.pages;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AcessarVideo {
	
	@Test
	public void acessarVideo(AndroidDriver<MobileElement> driver) {	
	
	MobileElement nomeCanalHome = driver.findElement(MobileBy.id("com.google.android.youtube:id/channel_avatar"));
	nomeCanalHome.click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	MobileElement nomeTrajetoria = driver.findElement(MobileBy.id("com.google.android.youtube:id/thumbnail"));
	nomeTrajetoria.click();
	}
   
}
	
	
