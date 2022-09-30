package despegar.avance.PO;



import java.util.List;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
	
	@FindBy(xpath = "//*[@id=\"lgpd-banner\"]/div/a[2]/em") 
	WebElement aceptarCookies;

	@FindBy(xpath = "/html/body/nav/div[4]/div[1]/i") 
	WebElement cerrarFace;

	@FindBy (xpath= "//*[text()='Alojamientos']")
	WebElement Alojamientos;
	
	@FindBy
	(css= "input[placeholder='Ingresá una ciudad, alojamiento o punto de interés']")
	WebElement ventanaAlojamientos;
	
	@FindBy(css ="*[class='ac-wrapper -desktop -show sbox-ab-ls']")
	WebElement openMenu;
	
	@FindBy	(css= ("input[placeholder='Entrada']"))
	WebElement fechaSelector; 
	
	
	@FindBy(css="div[class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']")
	WebElement ingresarFecha;
	
	@FindBy(css="div[class='sbox5-floating-tooltip sbox5-floating-tooltip-opened'] a[class='calendar-arrow-right']")
	WebElement click;
	
	@FindBy(xpath="(//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid-datenumber-number'])[3]")
	WebElement fechaIda;
	
	@FindBy(xpath="(//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid-datenumber-number'])[21]")
	WebElement fechaVuelta;
		
	@FindBy(xpath = "//div[@class='sbox5-3-second-input-wrapper']")
	WebElement cantidadAdultos;

	@FindBy(css = "#component-modals > div.sbox5-floating-tooltip.sbox5-floating-tooltip-opened > div > div > div.stepper__room > div.stepper__distribution_container > div:nth-child(1) > div.stepper__room__row__stepper__contaer > div > button.steppers-icon-right.stepper__icon")
	WebElement agregarAdultos;

	@FindBy(xpath = "//*[@id='component-modals']/div[5]/div/div/div[1]/div[2]/div[2]/div[2]/div/button[2]")
	WebElement agregarNino;

	@FindBy(xpath = "//select[@class='select']")
	WebElement edadMenor;

	@FindBy(xpath = "(//a[@class='sbox5-3-btn -md -primary'])[2]")
	WebElement enter;

	@FindBy(xpath = "//button[@class='sbox5-box-button-ovr sbox5-3-btn sbox5-button -secondary -icon -lg']")
	WebElement buscar;
	
	@FindBy(css="ul.header-list-products>li>a")List<WebElement>lista;

	public WebDriver driver;
	public WebDriverWait wait;


	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait =  new WebDriverWait(driver,20);
	}
		
		//cierra cartel emergente
		public void cerrarFace()
		{

		this.wait.until(ExpectedConditions.visibilityOf(cerrarFace));
		 cerrarFace.click(); 
		}
		//cierra cookies
		public void aceptarCookies()
		{

		this.wait.until(ExpectedConditions.visibilityOf(aceptarCookies));
		 aceptarCookies.click(); 
		 }
		//hace click sobre alojamientos
		public void irAlojamientos() {
			this.Alojamientos.click();
			
		}
		
		public void elegirDestino() {
			this.wait.until(ExpectedConditions.visibilityOf(ventanaAlojamientos));
			this.ventanaAlojamientos.click();
		}
         //ingresa el destino y le da enter
		public void ingresarDestino(String desText) throws InterruptedException{
			ventanaAlojamientos.click();
			Thread.sleep(4000);
			this.ventanaAlojamientos.sendKeys(desText);
			this.wait.until(ExpectedConditions.visibilityOf(openMenu));
			this.ventanaAlojamientos.sendKeys(Keys.ENTER);
	}
	
		//seleccion de las fechas
		public void ingresarFechas() {
			wait.until(ExpectedConditions.elementToBeClickable(fechaSelector));
			this.fechaSelector.click();
			wait.until(ExpectedConditions.visibilityOf(ingresarFecha));
			wait.until(ExpectedConditions.visibilityOf(click));
			wait.until(ExpectedConditions.elementToBeClickable(click));
			this.click.click();
			wait.until(ExpectedConditions.visibilityOf(fechaIda));
			wait.until(ExpectedConditions.elementToBeClickable(fechaIda));
			this.fechaIda.click();
			wait.until(ExpectedConditions.visibilityOf(fechaVuelta));
			wait.until(ExpectedConditions.elementToBeClickable(fechaVuelta));
			this.fechaVuelta.click();
		}
		//ingreso cant de personas
		public void cantidadPersonas(String text) {
			cantidadAdultos.click();
			wait.until(ExpectedConditions.visibilityOf(agregarAdultos));
			agregarAdultos.click();
			agregarNino.click();
			this.wait.until(ExpectedConditions.visibilityOf(edadMenor));
			this.edadMenor.click();
			this.edadMenor.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			
		}
		//retornar la siguiente pagina
				public ResultsPage buscar() {
					wait.until(ExpectedConditions.elementToBeClickable(edadMenor));
					this.buscar.click();
					return new ResultsPage(this.driver);
					}
        }





