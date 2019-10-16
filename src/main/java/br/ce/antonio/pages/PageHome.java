package br.ce.antonio.pages;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class PageHome {
	@Test
	public void pageHome(AndroidDriver<MobileElement> driver) {
		//Selecionar campo pesquisa
		java.util.List<MobileElement> elementosEncontradoss = driver.findElements(By.className("android.widget.TextView"));

		elementosEncontradoss.get(0).click();
		
		// Digitar a pesquisa desejada
		MobileElement campoNome = driver.findElement(MobileBy.className("android.widget.EditText"));
		campoNome.sendKeys("Julio de Lima");
		System.out.print(campoNome.getText());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Clicar no nome da pesquisa
		MobileElement nomeCanal = driver.findElement(MobileBy.className("android.widget.TextView"));
		nomeCanal.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Verificar status 
		Assert.assertEquals("Julio de Lima", "Julio de Lima");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

}
