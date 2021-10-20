package helpfulClasses;

import java.util.Random;

// Klasa posiadająca metody do generowania losowych znaków wybranego typu.
public class RandomChar {
	
	// Metoda generuje ilość znaków numerycznych podanych w argumencie metody.
	public String getNumericalChar(int length) {
		
		// Dodanie do tablicy znaków, znaków numerycznych, które pełnią bazę do losowania.
		char[] chars = "0123456789".toCharArray();
		
		// Obiekt klasy StringBuilder posłuży do łączenia wylosowanych cyfr.
		StringBuilder stringBuilder = new StringBuilder();
		
		// Obiekt klasy Random posłuży do losowania kolejnych cyfr.
		Random random = new Random();
		
		// Pętla wykonująca się do momentu, aż ilość cyfr podana w argumencie metody zostanie wylosowana
		// oraz dodana do StringBuildera.
		for (int i = 0; i < length; i++) {
			char randomChar = chars[random.nextInt(chars.length)];
			stringBuilder.append(randomChar);
		}
		
		// Zamiana przechowywanych w StringBuilderze cyfr na jednolity ciąg znaków.
		String randomString = stringBuilder.toString();
		
		// Zwrócenie ciągu cyfr.
		return randomString;
	}

	// Metoda generuje ilość znaków literowych podanych w argumencie metody.
	public String getLiteralChar(int length) {
		
		// Dodanie do tablicy znaków, znaków literowych, które pełnią bazę do losowania.
		char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		
		// Obiekt klasy StringBuilder posłuży do łączenia wylosowanych liter.
		StringBuilder stringBuilder = new StringBuilder();
		
		// Obiekt klasy Random posłuży do losowania kolejnych liter.
		Random random = new Random();
		
		// Pętla wykonująca się do momentu, aż ilość liter podana w argumencie metody zostanie wylosowana
		// oraz dodana do StringBuildera.
		for (int i = 0; i < length; i++) {
			char randomChar = chars[random.nextInt(chars.length)];
			stringBuilder.append(randomChar);
		}
		
		// Zamiana przechowywanych w StringBuilderze liter na jednolity ciąg znaków.
		String randomString = stringBuilder.toString();
		
		// Zwrócenie ciągu liter.
		return randomString;
	}

	// Metoda generuje ilość znaków diakrytycznych podanych w argumencie metody.
	public String getDiacriticalChar(int length) {
		
		// Dodanie do tablicy znaków, znaków diakrytycznych, które pełnią bazę do losowania.
		char[] chars = "ĘÓĄŚŁŻŃźŹęóąśłżń".toCharArray();
		
		// Obiekt klasy StringBuilder posłuży do łączenia wylosowanych znaków diakrytycznych.
		StringBuilder stringBuilder = new StringBuilder();
		
		// Obiekt klasy Random posłuży do losowania kolejnych znaków diakrytycznych.
		Random random = new Random();
		
		// Pętla wykonująca się do momentu, aż ilość znaków diakrytycznych podana w argumencie metody zostanie wylosowana
		// oraz dodana do StringBuildera.
		for (int i = 0; i < length; i++) {
			char randomChar = chars[random.nextInt(chars.length)];
			stringBuilder.append(randomChar);
		}
		
		// Zamiana przechowywanych w StringBuilderze znaków diakrytycznych na jednolity ciąg znaków.
		String randomString = stringBuilder.toString();
		
		// Zwrócenie ciągu znaków diakrytycznych.
		return randomString;
	}

	// Metoda generuje ilość znaków specjalnych podanych w argumencie metody.
	public String getSpecialChar(int length) {
		
		// Dodanie do tablicy znaków, znaków specjalnych, które pełnią bazę do losowania.
		char[] chars = "`!@#$%^&*()_+-= {}[]|:<>?;',./'".toCharArray();
		
		// Obiekt klasy StringBuilder posłuży do łączenia wylosowanych znaków specjalnych.
		StringBuilder stringBuilder = new StringBuilder();
		
		// Obiekt klasy Random posłuży do losowania kolejnych znaków specjalnych.
		Random random = new Random();
		
		// Pętla wykonująca się do momentu, aż ilość znaków specjalnych podana w argumencie metody zostanie wylosowana
		// oraz dodana do StringBuildera.
		for (int i = 0; i < length; i++) {
			char randomChar = chars[random.nextInt(chars.length)];
			stringBuilder.append(randomChar);
		}
		
		// Zamiana przechowywanych w StringBuilderze znaków specjalnych na jednolity ciąg znaków.
		String randomString = stringBuilder.toString();
		
		// Zwrócenie ciągu znaków specjalnych.
		return randomString;
	}
}