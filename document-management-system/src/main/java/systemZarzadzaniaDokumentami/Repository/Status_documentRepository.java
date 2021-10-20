package systemZarzadzaniaDokumentami.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import systemZarzadzaniaDokumentami.Model.StatusDocument;

// Utworzenie repozytorium JPA. Odpowiada za komunikację z jednostką utrwalania danych.
public interface Status_documentRepository extends JpaRepository<StatusDocument, Integer>  {

	// Poniżej przedstawiam niektóre z metod dostępnych w repozytorium JPA:
	// Metoda findAll() służy do pobierania wszystkich rekordów z bazy danych. - Użyta do pobrania wszystkich dokumentów.
	// Metoda getOne() służy do pobierania konkretnego rekordu z bazy danych.
	// Metoda save() służy do zapisywania modyfikacji i dodawania nowego rekordu do bazy danych.
	// Metoda delete() służy do usuwania wybranego rekordu z bazy danych.
	
}