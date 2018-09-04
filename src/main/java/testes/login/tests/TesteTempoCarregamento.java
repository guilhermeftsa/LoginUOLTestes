package testes.login.tests;

import java.io.IOException;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import testes.login.core.BaseTest;
import testes.login.pages.LoginPage;
import testes.login.util.Screenshot;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "MassaDadosLogin.csv" }, writeData = false, loaderType = LoaderType.CSV)
public class TesteTempoCarregamento extends BaseTest {
	LoginPage page = new LoginPage();
	long tempocarregamento;
	boolean sucesso = true;

	@Test
	public void testeTempoCarregamentoPagina(@Param (name = "matricula") String matricula, 
			   								 @Param (name = "senha")String senha) throws IOException{
		page.login(matricula, senha);
		tempocarregamento = System.currentTimeMillis();
		
		try {
			Assert.assertTrue(page.esperarCampoID("matriculaUsuario").testeCarregamentoPagina(tempocarregamento));
			System.out.println(page.obterTexto("matriculaUsuario"));	
		} catch (AssertionError e) {
			System.out.println(page.obterTexto("matriculaUsuario"));
			sucesso = false;
			Assert.fail();
		}finally{
			Screenshot.tirarScreenshot(testname, sucesso);
		}		
	}
}

//Assert.assertTrue(page.esperarCampoID("matriculaUsuario").testeCarregamentoPagina(tempocarregamento));

