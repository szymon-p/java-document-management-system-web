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

//Klasa wykorzystywana do zbierania wyników 
//ilości wyfiltrowanych rekordów dla konkretnych algorytmów
//dla filtrowania po jednym losowym znaku konkretnego typu.
public class ResultsDocumentsOneRandomSpecificChar {

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
	File result = new File("./resultOneRandomSpecificChar.txt");

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
	// dla losowego pojedynczego znaku diakrytycznego.
	@Test(invocationCount = 1000, enabled = true)
	public void testOneRandomDiacriticalCharAlgKMP() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku diakrytycznego do inputa filtrowania danych.
		oneChar.setOneRandomDiacriticalCharAlgKMP();
		
		// Zapis wyniku do pliku tekstowego
		// (ilość znalezionych rekordów, wprowadzany znak oraz nazwa badanego algorytmu).
		saveToFile(oneChar.getValueAlgKMP(), "algKMP");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu KMP,
	// dla losowego pojedynczego znaku literowego.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneRandomLiteralCharAlgKMP() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku literowego do inputa filtrowania danych.
		oneChar.setOneRandomLiteralCharAlgKMP();
		
		// Zapis wyniku do pliku tekstowego
		// (ilość znalezionych rekordów, wprowadzany znak oraz nazwa badanego algorytmu).
		saveToFile(oneChar.getValueAlgKMP(), "algKMP");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu KMP,
	// dla losowego pojedynczego znaku numerycznego.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneRandomNumericalCharAlgKMP() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku numerycznego do inputa filtrowania danych.
		oneChar.setOneRandomNumericalCharAlgKMP();
		
		// Zapis wyniku do pliku tekstowego
		// (ilość znalezionych rekordów, wprowadzany znak oraz nazwa badanego algorytmu).
		saveToFile(oneChar.getValueAlgKMP(), "algKMP");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu KMP,
	// dla losowego pojedynczego znaku specjalnego.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneRandomSpecialCharAlgKMP() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku specjalnego do inputa filtrowania danych.
		oneChar.setOneRandomSpecialCharAlgKMP();
		
		// Zapis wyniku do pliku tekstowego
		// (ilość znalezionych rekordów, wprowadzany znak oraz nazwa badanego algorytmu).
		saveToFile(oneChar.getValueAlgKMP(), "algKMP");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu KR,
	// dla losowego pojedynczego znaku diakrytycznego.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneRandomDiacriticalCharAlgKR() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku diakrytycznego do inputa filtrowania danych.
		oneChar.setOneRandomDiacriticalCharAlgKR();
		
		// Zapis wyniku do pliku tekstowego
		// (ilość znalezionych rekordów, wprowadzany znak oraz nazwa badanego algorytmu).
		saveToFile(oneChar.getValueAlgKR(), "algKR");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu KR,
	// dla losowego pojedynczego znaku literowego.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneRandomLiteralCharAlgKR() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku literowego do inputa filtrowania danych.
		oneChar.setOneRandomLiteralCharAlgKR();
		
		// Zapis wyniku do pliku tekstowego
		// (ilość znalezionych rekordów, wprowadzany znak oraz nazwa badanego algorytmu).
		saveToFile(oneChar.getValueAlgKR(), "algKR");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu KR,
	// dla losowego pojedynczego znaku numerycznego.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneRandomNumericalCharAlgKR() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku numerycznego do inputa filtrowania danych.
		oneChar.setOneRandomNumericalCharAlgKR();
		
		// Zapis wyniku do pliku tekstowego
		// (ilość znalezionych rekordów, wprowadzany znak oraz nazwa badanego algorytmu).
		saveToFile(oneChar.getValueAlgKR(), "algKR");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu KR,
	// dla losowego pojedynczego znaku specjalnego.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneRandomSpecialCharAlgKR() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku specjalnego do inputa filtrowania danych.
		oneChar.setOneRandomSpecialCharAlgKR();
		
		// Zapis wyniku do pliku tekstowego
		// (ilość znalezionych rekordów, wprowadzany znak oraz nazwa badanego algorytmu).
		saveToFile(oneChar.getValueAlgKR(), "algKR");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu BM,
	// dla losowego pojedynczego znaku diakrytycznego.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneRandomDiacriticalCharAlgBM() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku diakrytycznego do inputa filtrowania danych.
		oneChar.setOneRandomDiacriticalCharAlgBM();
		
		// Zapis wyniku do pliku tekstowego
		// (ilość znalezionych rekordów, wprowadzany znak oraz nazwa badanego algorytmu).
		saveToFile(oneChar.getValueAlgBM(), "algBM");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu BM,
	// dla losowego pojedynczego znaku literowego.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneRandomLiteralCharAlgBM() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku literowego do inputa filtrowania danych.
		oneChar.setOneRandomLiteralCharAlgBM();
		
		// Zapis wyniku do pliku tekstowego
		// (ilość znalezionych rekordów, wprowadzany znak oraz nazwa badanego algorytmu).
		saveToFile(oneChar.getValueAlgBM(), "algBM");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu BM,
	// dla losowego pojedynczego znaku numerycznego.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneRandomNumericalCharAlgBM() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku numerycznego do inputa filtrowania danych.
		oneChar.setOneRandomNumericalCharAlgBM();
		
		// Zapis wyniku do pliku tekstowego
		// (ilość znalezionych rekordów, wprowadzany znak oraz nazwa badanego algorytmu).
		saveToFile(oneChar.getValueAlgBM(), "algBM");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu BM,
	// dla losowego pojedynczego znaku specjalnego.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneRandomSpecialCharAlgBM() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku specjalnego do inputa filtrowania danych.
		oneChar.setOneRandomSpecialCharAlgBM();
		
		// Zapis wyniku do pliku tekstowego
		// (ilość znalezionych rekordów, wprowadzany znak oraz nazwa badanego algorytmu).
		saveToFile(oneChar.getValueAlgBM(), "algBM");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu binarnego,
	// dla losowego pojedynczego znaku diakrytycznego.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneRandomDiacriticalCharAlgBIN() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku diakrytycznego do inputa filtrowania danych.
		oneChar.setOneRandomDiacriticalCharAlgBIN();
		
		// Zapis wyniku do pliku tekstowego
		// (ilość znalezionych rekordów, wprowadzany znak oraz nazwa badanego algorytmu).
		saveToFile(oneChar.getValueAlgBIN(), "algBIN");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu binarnego,
	// dla losowego pojedynczego znaku literowego.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneRandomLiteralCharAlgBIN() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku literowego do inputa filtrowania danych.
		oneChar.setOneRandomLiteralCharAlgBIN();
		
		// Zapis wyniku do pliku tekstowego
		// (ilość znalezionych rekordów, wprowadzany znak oraz nazwa badanego algorytmu).
		saveToFile(oneChar.getValueAlgBIN(), "algBIN");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu binarnego,
	// dla losowego pojedynczego znaku numerycznego.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneRandomNumericalCharAlgBIN() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku numerycznego do inputa filtrowania danych.
		oneChar.setOneRandomNumericalCharAlgBIN();
		
		// Zapis wyniku do pliku tekstowego
		// (ilość znalezionych rekordów, wprowadzany znak oraz nazwa badanego algorytmu).
		saveToFile(oneChar.getValueAlgBIN(), "algBIN");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu binarnego,
	// dla losowego pojedynczego znaku specjalnego.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneRandomSpecialCharAlgBIN() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku specjalnego do inputa filtrowania danych.
		oneChar.setOneRandomSpecialCharAlgBIN();
		
		// Zapis wyniku do pliku tekstowego
		// (ilość znalezionych rekordów, wprowadzany znak oraz nazwa badanego algorytmu).
		saveToFile(oneChar.getValueAlgBIN(), "algBIN");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu liniowego,
	// dla losowego pojedynczego znaku diakrytycznego.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneRandomDiacriticalCharAlgLIN() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku diakrytycznego do inputa filtrowania danych.
		oneChar.setOneRandomDiacriticalCharAlgLIN();
		
		// Zapis wyniku do pliku tekstowego
		// (ilość znalezionych rekordów, wprowadzany znak oraz nazwa badanego algorytmu).
		saveToFile(oneChar.getValueAlgLIN(), "algLIN");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu liniowego,
	// dla losowego pojedynczego znaku literowego.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneRandomLiteralCharAlgLIN() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku literowego do inputa filtrowania danych.
		oneChar.setOneRandomLiteralCharAlgLIN();
		
		// Zapis wyniku do pliku tekstowego
		// (ilość znalezionych rekordów, wprowadzany znak oraz nazwa badanego algorytmu).
		saveToFile(oneChar.getValueAlgLIN(), "algLIN");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu liniowego,
	// dla losowego pojedynczego znaku numerycznego.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneRandomNumericalCharAlgLIN() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku numerycznego do inputa filtrowania danych.
		oneChar.setOneRandomNumericalCharAlgLIN();
		
		// Zapis wyniku do pliku tekstowego
		// (ilość znalezionych rekordów, wprowadzany znak oraz nazwa badanego algorytmu).
		saveToFile(oneChar.getValueAlgLIN(), "algLIN");
		
		// Wyczyszczenie inputa filtrowania danych przed kolejną iteracją.
		oneChar.clearInputAlg();
	}

	// Test zbiera wyniki ilości wyfiltrowanych rekordów dla algorytmu liniowego,
	// dla losowego pojedynczego znaku specjalnego.
	@Test(invocationCount = 1000, enabled = false)
	public void testOneRandomSpecialCharAlgLIN() throws IOException, InterruptedException {
		
		// Wprowadzenie losowego znaku specjalnego do inputa filtrowania danych.
		oneChar.setOneRandomSpecialCharAlgLIN();
		
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