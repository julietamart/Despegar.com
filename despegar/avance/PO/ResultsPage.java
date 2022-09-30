package despegar.avance.PO;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {
	WebDriver driver;
	WebDriverWait wait;

	
	@FindBy (css = "*[class='cluster-description cluster-description-top']")
	WebElement primerAlojamiento;
	
	
	
	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		this.wait =  new WebDriverWait(driver,10);
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
		
	
	public String returnResult()
	{
		wait.until(ExpectedConditions.visibilityOf(primerAlojamiento));
		return primerAlojamiento.getText();
}
	

}
