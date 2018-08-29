package testes.login.pages;

import org.openqa.selenium.WebDriver;

import testes.login.core.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public String encontrarMatricula(){
		return obterTexto("matriculaUsuario");
	}
	
	

}
