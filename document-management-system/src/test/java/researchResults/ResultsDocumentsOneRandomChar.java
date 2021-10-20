package researchResults;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.Documents;

// Klasa wykorzystywana do zbierania wyników 
// ilości wyfiltrowanych rekordów dla konkretnych algorytmów
// dla filtrowania po jednym losowym znaku dowolnego typu.
public class ResultsDocumentsOneRandomChar {

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
	
	// Lokalizacja zapisu wyników testów w formie pliku tekstowego.
	File result = new File("./resultOneRandomChar.txt");

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

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu KMP,
	// dla losowego pojedynczego znaku dowolnego typu.
	@Test(invocationCount = 1000, enabled = true)
	public void testOneRandomCharAlgKMP() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku do inputa filtrowania danych.
		oneChar.setOneRandomCharAlgKMP();
		
		// Zapis wyniku do pliku tekstowego
		// (ilość znalezionych rekordów, wprowadzany znak oraz nazwa badanego algorytmu).
		saveToFile(oneChar.getValueAlgKMP(), "algKMP");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu KR,
	// dla losowego pojedynczego znaku dowolnego typu.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneRandomCharAlgKR() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku do inputa filtrowania danych.
		oneChar.setOneRandomCharAlgKR();
		
		// Zapis wyniku do pliku tekstowego
		// (ilość znalezionych rekordów, wprowadzany znak oraz nazwa badanego algorytmu).
		saveToFile(oneChar.getValueAlgKR(), "algKR");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu BM,
	// dla losowego pojedynczego znaku dowolnego typu.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneRandomCharAlgBM() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku do inputa filtrowania danych.
		oneChar.setOneRandomCharAlgBM();
		
		// Zapis wyniku do pliku tekstowego
		// (ilość znalezionych rekordów, wprowadzany znak oraz nazwa badanego algorytmu).
		saveToFile(oneChar.getValueAlgBM(), "algBM");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu binarnego,
	// dla losowego pojedynczego znaku dowolnego typu.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneRandomCharAlgBIN() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku do inputa filtrowania danych.
		oneChar.setOneRandomCharAlgBIN();
		
		// Zapis wyniku do pliku tekstowego
		// (ilość znalezionych rekordów, wprowadzany znak oraz nazwa badanego algorytmu).
		saveToFile(oneChar.getValueAlgBIN(), "algBIN");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu liniowego,
	// dla losowego pojedynczego znaku dowolnego typu.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneRandomCharAlgLIN() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku do inputa filtrowania danych.
		oneChar.setOneRandomCharAlgLIN();
		
		// Zapis wyniku do pliku tekstowego
		// (ilość znalezionych rekordów, wprowadzany znak oraz nazwa badanego algorytmu).
		saveToFile(oneChar.getValueAlgLIN(), "algLIN");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Metoda uruchamiana w każdym przebiegu pętli w celu zapisania wyników badania.
	// W argumencie przyjmuje wprowadzaną do inputa wartość oraz nazwę badanego algorytmu.
	public void saveToFile(String inputValue, String algName) throws IOException {
		
		// Utworzenie obiektu klasy Writer, która pozwala zapisywać dane do pliku.
		Writer output;
		
		// Wskazanie lokalizacji pliku, do którego następuje zapis danych.
		output = new BufferedWriter(new FileWriter(result, true));
		
		// Pobranie zawartości tekstowej z podsumowania strony.
		String amountOfRows = oneChar.getAmountOfRows().trim();
		
		// Przygotowanie danych, które zostaną zapisane w pliku
		// (nazwa badanego algorytmu, wprowadzany znak oraz ilość znalezionych rekordów).
		// Separator jest konieczny, ponieważ w przeciwnym przypadku nastąpiłoby nadpisanie danych w pliku.
		output.append(algName + ";" + inputValue + ";"
				+ amountOfRows.substring(amountOfRows.indexOf("(") + 1, amountOfRows.indexOf("rekord"))
				+ System.lineSeparator());
		
		// Zamknięcie sesji zapisu danych do pliku.
		output.close();
	}
}