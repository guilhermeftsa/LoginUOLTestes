package testes.login.tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import testes.login.core.BaseTest;
import testes.login.core.DriverFactory;
import testes.login.pages.HomePage;
import testes.login.pages.LoginPage;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "MassaDadosLogin.csv" }, writeData = false, loaderType = LoaderType.CSV)
public class TesteLoginBemSucedido extends BaseTest {
	HomePage hPage = new HomePage(DriverFactory.getDriver());
	LoginPage page = new LoginPage();
	@Test
	public void testeRealizarLogin(@Param (name = "matricula") String matricula, @Param(name = "senha")String senha,
								   @Param(name = "matriculaExibida") String matriculaExibida){
	
		Assert.assertEquals(matriculaExibida, new LoginPage(DriverFactory.getDriver()).login(matricula, senha).encontrarMatricula());
	}
}
