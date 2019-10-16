package br.ce.antonio.pages;

import org.junit.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CurtirVideo {
	
	@Test
	public void curtirVideo(AndroidDriver<MobileElement> driver) {	
	//Curtir o video
	MobileElement nomeCurtir = driver.findElement(MobileBy.id("com.google.android.youtube:id/button_icon"));
	nomeCurtir.click();	
	}

}
	
