package helpfulClasses;

import java.util.ArrayList;
import java.util.List;

// Klasa odpowiedzialna za budowanie spersonalizowanego zestawu znaków do badań.
public class RandomInputValue {
	
	// Inicjalizacja obiektu klasy RandomChar w celu dostępu do generowania losowych znaków/ciągów znaków.
	RandomChar randomChars = new RandomChar();
	
	// Inicjalizacja listy w celu przechowywania wygenerowanych losowych znaków.
	List<String> elements = new ArrayList<String>();
	
	// Inicjalizacja obiektu klasy RandomItem w celu dostępu do metody losowania elementu z listy elements.
	RandomItem randomItem = new RandomItem();

	// Metoda tworzy listę, z której będzie losowana ilość elementów podana w argumencie metody.
	// Metoda pozwala na losowanie spośród różnych typów znaków. - Pozwala na personalizację zestawu znaków.
	public String input(int length) {
		
		// Dodawanie do listy znaków literowych. Ilość podana zostanie w argumencie.
		elements.add(randomChars.getLiteralChar(length));
		
		// Dodawanie do listy znaków numerycznych. Ilość podana zostanie w argumencie.
		elements.add(randomChars.getNumericalChar(length));
		
		// Dodawanie do listy znaków specjalnych. Ilość podana zostanie w argumencie.
		elements.add(randomChars.getSpecialChar(length));
		
		// Dodawanie do listy znaków diakrytycznych. Ilość podana zostanie w argumencie.
		elements.add(randomChars.getDiacriticalChar(length));
		
		// Losowanie jednego elementu z listy oraz zwrócenie go.
		return elements.get(randomItem.randomString(elements));
	}
}