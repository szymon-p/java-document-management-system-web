package researchResults;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageFactory.Documents;

//Klasa wykorzystywana do zbierania wyników 
//ilości wyfiltrowanych rekordów dla konkretnych algorytmów
//dla filtrowania po jednym konkretnym znaku literowym (a, e, r, s, v, x).
public class ResultsDocumentsOneSpecificLetter {

	// Zmienna przechowująca adres strony badań do wykorzystania przez Selenium WebDriver.
	String baseUrl = "localhost:8080/documents";
	
	// Lokalizacja sterownika Selenium dla przeglądarki Chrome.
	String driverPath = "./chromedriver.exe";
	
	// Inicjalizacja Selenium WebDrivera.
	WebDriver driver;
	
	// Utworzenie obiektu klasy Documents z package pageFactory,
	// co zapewnia dostęp do metod reprezentujących działania na elementach strony.
	// Z metodych tych układane są konkretne scenariusze do realizacji przez Selenium.
	Documents oneChar;
	
	// Metoda zawiera kod, który jest wykonywany przed rozpoczęciem wykonywania scenariuszy z adnotacją @Test.
	@BeforeTest
	public void launchBrowser() {
		
		// Podanie ścieżki dla ChromeDrivera.
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		oneChar = new Documents(driver);
		
		// Przejście na podstronę do badań wydajności algorytmów.
		driver.get(baseUrl);
		
		// Maksymalizacja okna przeglądarki.
		driver.manage().window().maximize();
	}
	
	// Podczas przeprowadzania badania był uruchamiany tylko jeden test jednocześnie,
	// tzn. że pozostałe testy miały ustawiony status enabled = false.
	// Każdy test wykonywany jest tysiąc razy - invocationCount = 1000.
	// Do każdego testu litera wprowadzana była ręcznie.
	// Zapis danych do pliku nie był konieczny, ponieważ badana była konkretna litera,
	// a pomiędzy testami przełączano się manualnie.

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu KMP,
	// dla konkretnego pojedynczego znaku literowego.
	@Test(invocationCount = 1000, enabled = true)
	public void testOneSpecificLetterAlgKMP() throws IOException, InterruptedException {
		
		// Wprowadzenie konkretnego znaku literowego do inputa filtrowania danych.
		oneChar.setStringAlgKMP("a");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu KR,
	// dla konkretnego pojedynczego znaku literowego.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneSpecificLetterAlgKR() throws IOException, InterruptedException {
		
		// Wprowadzenie konkretnego znaku literowego do inputa filtrowania danych.
		oneChar.setStringAlgKR("a");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu BM,
	// dla konkretnego pojedynczego znaku literowego.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneSpecificLetterAlgBM() throws IOException, InterruptedException {
		
		// Wprowadzenie konkretnego znaku literowego do inputa filtrowania danych.
		oneChar.setStringAlgBM("a");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu binarnego,
	// dla konkretnego pojedynczego znaku literowego.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneSpecificLetterAlgBIN() throws IOException, InterruptedException {
		
		// Wprowadzenie konkretnego znaku literowego do inputa filtrowania danych.
		oneChar.setStringAlgBIN("a");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu liniowego,
	// dla konkretnego pojedynczego znaku literowego.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneSpecificLetterAlgLIN() throws IOException, InterruptedException {
		
		// Wprowadzenie konkretnego znaku literowego do inputa filtrowania danych.
		oneChar.setStringAlgLIN("a");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}
}