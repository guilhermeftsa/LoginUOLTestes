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
public class TesteEstouroCampoSenha extends BaseTest {

	LoginPage page = new LoginPage();
		
	@Test
	public void testarEstouroDeCampoSenha(@Param (name = "senha")String senha){				
		Assert.assertEquals(8, page.testarEstouroCampoSenha(senha).obterTamanhoCampo("senha"));
	}
}
