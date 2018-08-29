package testes.login.suites;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testes.login.core.DriverFactory;
import testes.login.tests.TesteCamposEmBranco;
import testes.login.tests.TesteCaracteresInvalidos;
import testes.login.tests.TesteEstouroCampoSenha;
import testes.login.tests.TesteLoginBemSucedido;
import testes.login.tests.TesteMatriculaESenhaInvalidos;
import testes.login.tests.TesteMatriculaIncorreta;
import testes.login.tests.TesteMatriculaInexistente;
import testes.login.tests.TesteSenhaIncorreta;



@RunWith(Suite.class)
@SuiteClasses({
	TesteCamposEmBranco.class,
	TesteCaracteresInvalidos.class,
	TesteEstouroCampoSenha.class,
	TesteMatriculaESenhaInvalidos.class,
	TesteMatriculaIncorreta.class,
	TesteMatriculaInexistente.class,
	TesteSenhaIncorreta.class,
	TesteLoginBemSucedido.class		
})

public class SuiteLogin {
	
	@AfterClass
	public static void finaliza(){
		DriverFactory.getDriver().quit();
		DriverFactory.KillDriver();
	}
}
