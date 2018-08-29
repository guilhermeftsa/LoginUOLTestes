package testes.login.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testes.login.core.BasePage;
import testes.login.core.DriverFactory;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public LoginPage(){
		super(driver);
	}

	public void acessarPaginaInicial(){
		DriverFactory.getDriver().get("https://uolhmg.unifor.br/acesso/app/autenticacao");
	}
	
	public LoginPage setMatricula(String matricula){
		escrever("matricula", matricula);
		return this;
	}
	
	public LoginPage setSenha(String senha){
		escrever("senha", senha);
		return this;
	}
	
	public HomePage entrar(){
		clicarBotao(By.xpath("/html//form[@id='form-login']//div[@class='col-sm-12 text-center']/input"));
		return new HomePage(driver);
	}
	
	public HomePage login(String matricula, String senha){
		setMatricula(matricula);
		setSenha(senha);
		entrar();
		return new HomePage(driver);
	}
	
	public LoginPage testarCamposBranco(String matricula, String senha){
		setMatricula(matricula);
		setSenha(senha);
		entrar();
		
		return  this;
	}
	
	public LoginPage testarCaracteresInvalidosMatricula(String matricula){
		setMatricula(matricula);		
		obterValorCampo("matricula").length();
		
		return this;
	}
	
	public LoginPage testarCaracteresInvalidosSenha(String senha){
		setSenha(senha);
		obterValorCampo("senha").length();
		
		return this;
	}
	
	public LoginPage testarEstouroCampoSenha(String senha){
		setSenha(senha);
		obterValorCampo("senha").length();
		
		return this;
	}
	
	public String obterMensagemErro(){
		return obterTexto(By.xpath("//div[@id='alert-login']"));
	}
	
	public void esperarCampoMatricula(){
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("matriculaUsuario")));
	}
		
}
