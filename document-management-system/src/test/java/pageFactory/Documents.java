package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import helpfulClasses.RandomChar;
import helpfulClasses.RandomInputValue;

// Klasa zawierająca elementy strony oraz aktywności, które można wykonać na tych elementach.
// Klasa oparta jest o wzorzec projektowy Page Object Model oraz wspomagana jest koncepcją Page Factory.
public class Documents {

	// Inicjalizacja obiektu Selenium WebDrivera.
	WebDriver driver;

	// Poniżej znajdują się elementy strony identyfikowane po id (lokalizacja), którym nadano aliasy.
	// WebElementy podane w ten sposób, są identyfikowane dzięki adnotacji @FindBy.
	
	@FindBy(id = "inputAlgKMP")
	WebElement algKMP;

	@FindBy(id = "inputAlgKR")
	WebElement algKR;

	@FindBy(id = "inputAlgBM")
	WebElement algBM;

	@FindBy(id = "inputAlgBIN")
	WebElement algBIN;

	@FindBy(id = "inputAlgLIN")
	WebElement algLIN;

	@FindBy(id = "amountOfRows")
	WebElement amountOfRows;

	// Wywołanie obiektów klas pomocniczych (package helpfulClasses).
	// Obiekty zostaną użyte w aktywnościach związanych z konkretnymi elementami.
	// Opis klas znajduje się w konkretnych klasach (package helpfulClasses).
	RandomInputValue randomInputValue = new RandomInputValue();
	RandomChar randomChar = new RandomChar();

	// Konstruktor klasy. 
	// Zastosowanie klasy AjaxElementLocatorFactory oraz metody initElements pozwala na uproszczenie
	// powyższego zapisu elementów strony za pomocą adnotacji @FindBy.
	public Documents(WebDriver driver) {
		this.driver = driver;
		
		// Wygenerowanie fabryki wszystkich WebElementów.
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
		PageFactory.initElements(factory, this);
	}

	// Poniżej znajdują się aktywności związane z konkretnymi WebElementami.
	// Aktywności reprezentowane są poprzez metody.
	
	// Wprowadzenie do inputa filtrowania danych algorytmu KMP, tekstu który został podany w argumencie metody.
	public void setStringAlgKMP(String inputedString) {
		algKMP.sendKeys(inputedString);
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu KR, tekstu który został podany w argumencie metody.
	public void setStringAlgKR(String inputedString) {
		algKR.sendKeys(inputedString);
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu BM, tekstu który został podany w argumencie metody.
	public void setStringAlgBM(String inputedString) {
		algBM.sendKeys(inputedString);
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu binarnego, tekstu który został podany w argumencie metody.
	public void setStringAlgBIN(String inputedString) {
		algBIN.sendKeys(inputedString);
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu liniowego, tekstu który został podany w argumencie metody.
	public void setStringAlgLIN(String inputedString) {
		algLIN.sendKeys(inputedString);
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu KMP, wylosowanego pojedynczego znaku numerycznego.
	public void setOneRandomNumericalCharAlgKMP() {
		algKMP.sendKeys(randomChar.getNumericalChar(1));
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu KMP, wylosowanego pojedynczego znaku literowego.
	public void setOneRandomLiteralCharAlgKMP() {
		algKMP.sendKeys(randomChar.getLiteralChar(1));
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu KMP, wylosowanego pojedynczego znaku diakrytycznego.
	public void setOneRandomDiacriticalCharAlgKMP() {
		algKMP.sendKeys(randomChar.getDiacriticalChar(1));
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu KMP, wylosowanego pojedynczego znaku specjalnego.
	public void setOneRandomSpecialCharAlgKMP() {
		algKMP.sendKeys(randomChar.getSpecialChar(1));
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu KR, wylosowanego pojedynczego znaku numerycznego.
	public void setOneRandomNumericalCharAlgKR() {
		algKR.sendKeys(randomChar.getNumericalChar(1));
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu KR, wylosowanego pojedynczego znaku literowego.
	public void setOneRandomLiteralCharAlgKR() {
		algKR.sendKeys(randomChar.getLiteralChar(1));
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu KR, wylosowanego pojedynczego znaku diakrytycznego.
	public void setOneRandomDiacriticalCharAlgKR() {
		algKR.sendKeys(randomChar.getDiacriticalChar(1));
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu KR, wylosowanego pojedynczego znaku specjalnego.
	public void setOneRandomSpecialCharAlgKR() {
		algKR.sendKeys(randomChar.getSpecialChar(1));
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu BM, wylosowanego pojedynczego znaku numerycznego.
	public void setOneRandomNumericalCharAlgBM() {
		algBM.sendKeys(randomChar.getNumericalChar(1));
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu BM, wylosowanego pojedynczego znaku literowego.
	public void setOneRandomLiteralCharAlgBM() {
		algBM.sendKeys(randomChar.getLiteralChar(1));
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu BM, wylosowanego pojedynczego znaku diakrytycznego.
	public void setOneRandomDiacriticalCharAlgBM() {
		algBM.sendKeys(randomChar.getDiacriticalChar(1));
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu BM, wylosowanego pojedynczego znaku specjalnego.
	public void setOneRandomSpecialCharAlgBM() {
		algBM.sendKeys(randomChar.getSpecialChar(1));
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu binarnego, wylosowanego pojedynczego znaku numerycznego.
	public void setOneRandomNumericalCharAlgBIN() {
		algBIN.sendKeys(randomChar.getNumericalChar(1));
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu binarnego, wylosowanego pojedynczego znaku literowego.
	public void setOneRandomLiteralCharAlgBIN() {
		algBIN.sendKeys(randomChar.getLiteralChar(1));
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu binarnego, wylosowanego pojedynczego znaku diakrytycznego.
	public void setOneRandomDiacriticalCharAlgBIN() {
		algBIN.sendKeys(randomChar.getDiacriticalChar(1));
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu binarnego, wylosowanego pojedynczego znaku specjalnego.
	public void setOneRandomSpecialCharAlgBIN() {
		algBIN.sendKeys(randomChar.getSpecialChar(1));
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu liniowego, wylosowanego pojedynczego znaku numerycznego.
	public void setOneRandomNumericalCharAlgLIN() {
		algLIN.sendKeys(randomChar.getNumericalChar(1));
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu liniowego, wylosowanego pojedynczego znaku literowego.
	public void setOneRandomLiteralCharAlgLIN() {
		algLIN.sendKeys(randomChar.getLiteralChar(1));
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu liniowego, wylosowanego pojedynczego znaku diakrytycznego.
	public void setOneRandomDiacriticalCharAlgLIN() {
		algLIN.sendKeys(randomChar.getDiacriticalChar(1));
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu liniowego, wylosowanego pojedynczego znaku specjalnego.
	public void setOneRandomSpecialCharAlgLIN() {
		algLIN.sendKeys(randomChar.getSpecialChar(1));
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu KMP, wylosowanego pojedynczego znaku dowolnego typu.
	public void setOneRandomCharAlgKMP() {
		algKMP.sendKeys(randomInputValue.input(1));
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu KR, wylosowanego pojedynczego znaku dowolnego typu.
	public void setOneRandomCharAlgKR() {
		algKR.sendKeys(randomInputValue.input(1));
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu BM, wylosowanego pojedynczego znaku dowolnego typu.
	public void setOneRandomCharAlgBM() {
		algBM.sendKeys(randomInputValue.input(1));
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu binarnego, wylosowanego pojedynczego znaku dowolnego typu.
	public void setOneRandomCharAlgBIN() {
		algBIN.sendKeys(randomInputValue.input(1));
	}

	// Wprowadzenie do inputa filtrowania danych algorytmu liniowego, wylosowanego pojedynczego znaku dowolnego typu.
	public void setOneRandomCharAlgLIN() {
		algLIN.sendKeys(randomInputValue.input(1));
	}

	// Wyczyszczenie zawartości wszystkich inputów do filtrowania danych.
	public void clearInputAlg() {
		algKMP.clear();
		algKR.clear();
		algBM.clear();
		algBIN.clear();
		algLIN.clear();
	}

	// Pobranie zawartości (tekstu) inputa filtrowania danych algorytmu KMP.
	public String getValueAlgKMP() {
		return algKMP.getAttribute("value");
	}

	// Pobranie zawartości (tekstu) inputa filtrowania danych algorytmu KR.
	public String getValueAlgKR() {
		return algKR.getAttribute("value");
	}

	// Pobranie zawartości (tekstu) inputa filtrowania danych algorytmu BM.
	public String getValueAlgBM() {
		return algBM.getAttribute("value");
	}

	// Pobranie zawartości (tekstu) inputa filtrowania danych algorytmu binarnego.
	public String getValueAlgBIN() {
		return algBIN.getAttribute("value");
	}

	// Pobranie zawartości (tekstu) inputa filtrowania danych algorytmu liniowego.
	public String getValueAlgLIN() {
		return algLIN.getAttribute("value");
	}

	// Zwrócenie ilości wierszy będących rezultatem filtrowania danych z wykorzystaniem konkretnego algorytmu.
	public String getAmountOfRows() {
		return amountOfRows.getText();
	}
}