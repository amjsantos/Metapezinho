package br.ce.antonio.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.ce.antonio.pages.AcessarVideo;
import br.ce.antonio.pages.CurtirVideo;
import br.ce.antonio.pages.InscricaoCanal;
import br.ce.antonio.pages.PageHome;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class FormularioTeste {

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:/Users/ajesussa/eclipse-workspace/TesteAppium/src/main/resources/CTAppium-1-1.apk");
			
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Selecionar formulario
		java.util.List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
		for(MobileElement elemento: elementosEncontrados) {
			System.out.print(elemento.getText());
		}
		//elementosEncontrados.get(1).click();
		
		//escrever nome
		//MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
		//campoNome.sendKeys("Antonio");
		
		//Checar nome escrito
		//String text = campoNome.getText();
		//Assert.assertEquals("Antonio", text);
				
		//driver.quit();

	}
	
	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:/Users/ajesussa/eclipse-workspace/TesteAppium/src/main/resources/CTAppium-1-1.apk");
			
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Selecionar formulario
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		
		//clicar no combo
		driver.findElement(MobileBy.AccessibilityId("console")).click();
		
		//selecionar opcao desejada
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
		
		//verificar a opcao selecionada
		String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
		Assert.assertEquals("Nintendo Switch", text);
		
		driver.quit();
	}

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:/Users/ajesussa/eclipse-workspace/TesteAppium/src/main/resources/CTAppium-1-1.apk");
			
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Selecionar formulario
		driver.findElement(By.xpath("//*[@text='Formulário']")).click();
		
		//<Verificar status dos elementos
		MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
		MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
		Assert.assertTrue(check.getAttribute("checked").equals("false"));
		Assert.assertTrue(switc.getAttribute("checked").equals("true"));
		
		
		//Clicar nos elementos
		check.click();
		switc.click();
		
		//Verificar estados alterados
		Assert.assertFalse(check.getAttribute("checked").equals("false"));
		Assert.assertFalse(switc.getAttribute("checked").equals("true"));
		
		driver.quit();
	}

	@Test
	public void deveAbrirYoutube() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.google.android.youtube");
		desiredCapabilities.setCapability("appActivity", "com.google.android.youtube.HomeActivity");
			
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		
		//Realiza a pesquisa na home
		PageHome pesquisa = new PageHome();
        pesquisa.pageHome(driver);
		
		//Realiza acesso ao video		
		AcessarVideo acessarVideo = new AcessarVideo();
		acessarVideo.acessarVideo(driver);
		
		//Realiza click no botão Curtir
		CurtirVideo curtirVideo = new CurtirVideo();
		curtirVideo.curtirVideo(driver);
		
		//Realiza a inscrição no canal
		InscricaoCanal inscricaoCanal = new InscricaoCanal();
		inscricaoCanal.inscricaoCanal(driver);
	}
	
}
