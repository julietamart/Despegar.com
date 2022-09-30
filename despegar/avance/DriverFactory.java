package despegar.avance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class DriverFactory {
	private enum browsers{
	      CHROME, EDGE
	 }
	public static WebDriver LevantarBrowser(String browserName, String url) {
		WebDriver driver = null;
		switch(browsers.valueOf(browserName))  {
			case CHROME:{
				System.setProperty("webdriver.chrome.driver","src/primerProyecto/chromedriver.exe"); 						
				driver = new ChromeDriver();
				break;
			}	
					    
			case EDGE:{
				System.setProperty("webdriver.edge.driver", "C:\\Users\\Juli\\Downloads"); 
				System.out.print("Iniciando Edge");
				driver = new EdgeDriver();
				break;
			}	
			default:{
				System.setProperty("webdriver.chrome.driver", "src/primerProyecto/chromedriver.exe");
				driver = new ChromeDriver();
				break;
	
			}
		}
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
}
	
       public static void CerrarBrowser(WebDriver driver) {
    	   driver.quit();
       }
}