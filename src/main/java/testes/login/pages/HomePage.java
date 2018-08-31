package testes.login.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testes.login.core.BasePage;
import testes.login.core.DriverFactory;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public String encontrarMatricula(){
		return obterTexto("matriculaUsuario");
	}
	
	public HomePage esperarCampoID(String campo){
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(campo)));
		return this;
	}	

}
