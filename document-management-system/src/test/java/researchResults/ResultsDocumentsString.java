package researchResults;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageFactory.Documents;

//Klasa wykorzystywana do zbierania wyników 
//ilości wyfiltrowanych rekordów dla konkretnych algorytmów
//dla filtrowania po ciągach znaków.
public class ResultsDocumentsString {

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
	// Każdy test wykonywany jest trzysta razy - invocationCount = 300.
	// Do każdego testu ciąg znaków wprowadzany był ręcznie.
	// Zapis danych do pliku nie był konieczny, ponieważ badany był konkretny ciąg znaków,
	// a pomiędzy testami przełączano się manualnie.

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu KMP,
	// dla konkretnego ciągu znaków.
	@Test(invocationCount = 300, enabled = true)
	public void testStringAlgKMP() throws IOException, InterruptedException {
		
		// Wprowadzenie konkretnego ciągu znaków do inputa filtrowania danych.
		oneChar.setStringAlgKMP("test");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu KR,
	// dla konkretnego ciągu znaków.
	@Test(invocationCount = 300, enabled = false)
	public void testStringAlgKR() throws IOException, InterruptedException {
		
		// Wprowadzenie konkretnego ciągu znaków do inputa filtrowania danych.
		oneChar.setStringAlgKR("");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu BM,
	// dla konkretnego ciągu znaków.
	@Test(invocationCount = 300, enabled = false)
	public void testStringAlgBM() throws IOException, InterruptedException {
		
		// Wprowadzenie konkretnego ciągu znaków do inputa filtrowania danych.
		oneChar.setStringAlgBM("");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu binarnego,
	// dla konkretnego ciągu znaków.
	@Test(invocationCount = 300, enabled = false)
	public void testStringAlgBIN() throws IOException, InterruptedException {
		
		// Wprowadzenie konkretnego ciągu znaków do inputa filtrowania danych.
		oneChar.setStringAlgBIN("");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu liniowego,
	// dla konkretnego ciągu znaków.
	@Test(invocationCount = 300, enabled = false)
	public void testStringAlgLIN() throws IOException, InterruptedException {
		
		// Wprowadzenie konkretnego ciągu znaków do inputa filtrowania danych.
		oneChar.setStringAlgLIN("");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}
}