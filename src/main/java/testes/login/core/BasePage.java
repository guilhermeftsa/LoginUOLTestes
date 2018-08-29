package testes.login.core;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class BasePage {
	
	protected static WebDriver driver;
	
	public BasePage(WebDriver driver){
		this.driver = driver;
	}
	
	public void escrever(By by, String texto){
		DriverFactory.getDriver().findElement(by).clear();
		DriverFactory.getDriver().findElement(by).sendKeys(texto);		
	}

	public void escrever(String id_campo, String texto){
		escrever(By.id(id_campo), texto);
	}
	
	public String obterValorCampo(String id_campo) {
		return DriverFactory.getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}
		
	public void clicarRadio(By by) {
		DriverFactory.getDriver().findElement(by).click();
	}
	
	public void clicarRadio(String id) {
		clicarRadio(By.id(id));
	}
	
	public boolean isRadioMarcado(String id){
		return DriverFactory.getDriver().findElement(By.id(id)).isSelected();
	}
	
	public void clicarCheck(String id) {
		DriverFactory.getDriver().findElement(By.id(id)).click();
	}
	
	public boolean isCheckMarcado(String id){
		return DriverFactory.getDriver().findElement(By.id(id)).isSelected();
	}
		
	public void selecionarCombo(String id, String valor) {
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public void deselecionarCombo(String id, String valor) {
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}

	public String obterValorCombo(String id) {
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	public List<String> obterValoresCombo(String id) {
		WebElement element = DriverFactory.getDriver().findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for(WebElement opcao: allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;
	}
	
	public int obterQuantidadeOpcoesCombo(String id){
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}
	
	public boolean verificarOpcaoCombo(String id, String opcao){
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for(WebElement option: options) {
			if(option.getText().equals(opcao)){
				return true;
			}
		}
		return false;
	}
	
	public void clicarBotao(By by) {
		DriverFactory.getDriver().findElement(by).click();
	}
	
	public void clicarBotaoPorTexto(String texto){
		clicarBotao(By.xpath("//button[.='"+texto+"']"));
	}
	
	public void clicarBotao(String id) {
		clicarBotao(By.id(id));
	}
	
	public String obterValueElemento(String id) {
		return DriverFactory.getDriver().findElement(By.id(id)).getAttribute("value");
	}	
	
	public void clicarLink(String link) {
		DriverFactory.getDriver().findElement(By.linkText(link)).click();
	}	
	
	public String obterTexto(By by) {
		return DriverFactory.getDriver().findElement(by).getText();
	}
	
	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}	
	
	public String alertaObterTexto(){
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		return alert.getText();
	}
	
	public String alertaObterTextoEAceita(){
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;		
	}
	
	public String alertaObterTextoENega(){
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;		
	}
	
	public void alertaEscrever(String valor) {
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		alert.sendKeys(valor);
		alert.accept();
	}	
	
	public void entrarFrame(String id) {
		DriverFactory.getDriver().switchTo().frame(id);
	}
	
	public void sairFrame(){
		DriverFactory.getDriver().switchTo().defaultContent();
	}
	
	public void trocarJanela(String id) {
		DriverFactory.getDriver().switchTo().window(id);
	}
	
	public Object executarJS(String cmd, Object...param){
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();		
		return js.executeScript(cmd, param);
	}
	
	public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela ){
		WebElement tabela = DriverFactory.getDriver().findElement(By.xpath("//table[@id='"+idTabela+"']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);		
		
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);	
		
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
		return celula;
	}

	
	public void ClicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela ){
			
		WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTabela);
		celula.findElement(By.xpath(".//input")).click();
	}

	private int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List <WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;		
		for (int i = 0; i < linhas.size(); i++){
			if(linhas.get(i).getText().equals(valor)){
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}

	private int obterIndiceColuna(String coluna, WebElement tabela) {
		List <WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;		
		for (int i = 0; i < colunas.size(); i++){
			if(colunas.get(i).getText().equals(coluna)){
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}
}
