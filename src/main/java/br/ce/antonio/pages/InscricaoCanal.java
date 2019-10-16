package br.ce.antonio.pages;

import org.junit.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class InscricaoCanal {
	
	@Test
	public void inscricaoCanal(AndroidDriver<MobileElement> driver) {
		//Inscrição no canal
		MobileElement nomeInscricao = driver.findElement(MobileBy.id("com.google.android.youtube:id/subscribe_button"));
		nomeInscricao.click();
	}

}
