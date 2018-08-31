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
	
	public LoginPage testarCampos(String matricula, String senha){
		setMatricula(matricula);
		setSenha(senha);
		entrar();		
		return  this;
	}
	
	public LoginPage testarCaracteresInvalidosMatricula(String matricula){
		setMatricula(matricula);
		return this;
	}
	
	public LoginPage testarCaracteresInvalidosSenha(String senha){
		setSenha(senha);
		return this;
	}
	
	public int obterTamanhoCampo(String campo){
		return obterValorCampo(campo).length();
	}
	
	public LoginPage testarEstouroCampoSenha(String senha){
		setSenha(senha);
		return this;
	}
	
	public String obterMensagemErro(){
		return obterTexto(By.xpath("//div[@id='alert-login']"));
	}
	
	public LoginPage esperarCampo(String campo){
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(campo)));
		return this;
	}		
	
	public String obterMatriculaTratada(String matricula){
		 if(matricula.length()>7){
		        String p1 = matricula.substring(0, 3);
		        String p2 = matricula.substring(3, matricula.length());
		        return p1+"-"+p2;
		 }
		 return matricula;
	}
	
	public boolean testeCarregamentoPagina(long tempoini){
		long tempofim = System.currentTimeMillis();
		long tempototal = (tempofim - tempoini);
		
		System.out.printf("Carregou em %d milissegundos\n",tempototal);
		
		boolean passou = false;
		
		if(tempototal < 50) {
			passou = true;
		}
		return passou;
	}
}
