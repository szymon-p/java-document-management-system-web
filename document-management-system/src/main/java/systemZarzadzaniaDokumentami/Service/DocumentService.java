package systemZarzadzaniaDokumentami.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import systemZarzadzaniaDokumentami.Model.Document;
import systemZarzadzaniaDokumentami.Repository.DocumentRepository;

// Adnotacja służy do oznaczacznia klas pełniących warstwę usług.
@Service
public class DocumentService {

	// Wstrzyknięcie obiektu Repository poprzez @Autowired w celu późniejszego zapisu danych do bazy.
	// Klasa DocumentService jest warstwą usług - pośrednikiem pomiędzy repozytorium a kontrolerem.
	@Autowired
	DocumentRepository documentRepository;

	public List<Document> getDocuments() {
		
		// Utworzenie listy obiektów klasy Documents.
		// Lista budowana jest poprzez bezpośrednie pobranie obiektów z repozytorium.
		List<Document> documents = documentRepository.findAll();
		
		// Następuje zwrócenie listy pobranych obiektów klasy Document.
		return documents;
	};
}