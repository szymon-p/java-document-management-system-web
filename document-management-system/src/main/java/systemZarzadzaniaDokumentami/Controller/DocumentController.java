package systemZarzadzaniaDokumentami.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import systemZarzadzaniaDokumentami.Model.Document;
import systemZarzadzaniaDokumentami.Service.DocumentService;

// Adnotacja służy do zdefiniowania klasy obsługi żądań, używana jako składnik wzorca MVC
@Controller
public class DocumentController {

	// Wstrzyknięcie obiektów warstwy usług w celu późniejszego zapisu danych do bazy.
	@Autowired
	DocumentService documentService;

	// Obsługa żądania GET - w tym przypadku oznacza przejście na podstronę
	// documents po wpisaniu adresu http://localhost:8080/
	@RequestMapping("")
	public String index() {
		return "redirect:/documents";
	}

	// Obsługa żądania GET przejścia na podstronę "Dokumenty" z panelu menu,
	// umieszczonego po prawej stronie w aplikacji.
	@RequestMapping(value = "/documents", method = RequestMethod.GET)
	public String showAlldocumets(Model model) {
		
		// Utworzenie listy obiektów klasy Documents.
		// Lista budowana jest poprzez pobranie obiektów z repozytorium, poprzez użycie
		// warstwy pośredniej - usług (metoda getDocuments).
		List<Document> documents = documentService.getDocuments();
		
		// W tym miejscu następuje przekazanie listy do Modelu, w celu póiejszego użycia
		// w Widoku poprzez Thymeleafa. Użyto klucza "documents".
		model.addAttribute("documents", documents);
		
		// Przekazanie klucza i listy do Widoku.
		return "documents";
	}
}