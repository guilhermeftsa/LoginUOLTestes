package testes.login.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import testes.login.core.DriverFactory;

public class Screenshot {
	public static void tirarScreenshot(TestName teste, boolean sucesso) throws IOException{
			TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
			File arquivo = ss.getScreenshotAs(OutputType.FILE);
			
			if(sucesso){
				FileUtils.copyFile(arquivo, new File("target"+ File.separator +"screenshot"
						+ File.separator + teste.getMethodName()+ ".jpg"));
			}else{
				FileUtils.copyFile(arquivo, new File("target"+ File.separator +"screenshotErros"
						+ File.separator + teste.getMethodName()+ ".jpg"));
			}
	}
}



