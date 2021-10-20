package helpfulClasses;

import java.util.List;
import java.util.Random;

// Klasa odpowiedzialna za losowanie elementu z personalizowanego zestawu znaków.
public class RandomItem {

	// Właściwa metoda wykonująca cel klasy podany w powyższym komentarzu.
	public int randomString(List<String> array) {
		
		// Losowanie elementu z listy.
		int randomString = new Random().nextInt(array.size());
		
		// Zwrócenie wylosowanego elementu.
		return randomString;
	}
}