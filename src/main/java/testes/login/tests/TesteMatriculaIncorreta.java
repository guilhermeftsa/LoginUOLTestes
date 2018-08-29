package testes.login.tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import testes.login.core.BaseTest;
import testes.login.pages.LoginPage;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "MassaDadosLogin.csv" }, writeData = false, loaderType = LoaderType.CSV)
public class TesteMatriculaIncorreta extends BaseTest {
	
	LoginPage page = new LoginPage();
		
	@Test
	public void TesteMatriculasIncorreta(@Param (name = "matricula")String matricula,
										 @Param (name = "senha") String senha){
		page.setMatricula(matricula);
		page.setSenha(senha);
		page.entrar();
		Assert.assertEquals("×\nMatrícula incorreta!", page.obterMensagemErro());
	}
	
}
