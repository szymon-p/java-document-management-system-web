package systemZarzadzaniaDokumentami.Model;

import java.text.ParseException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//Oznaczenie danej klasy jako encji - odwzorowanie na tabelę. - Pola obiektu będą mapowane na pola tabeli w bazie danych.
@Entity

//Mapuje klasę do tabeli w bazie danych.
@Table(name = "statusDocument")
public class StatusDocument {

	// Definiuje klucz główny tabeli.
	@Id
	// Oznacza, że wartości klucza głównego są generowane automatycznie.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Mapuje kolumnę na pole klasy. Nie pozwala na przyjmowanie przez pole wartości null.
	@Column(nullable = false)
	private Integer idStatusDocument;
	
	// Mapuje kolumnę na pole klasy. Nie pozwala na przyjmowanie przez pole wartości null.
	// Maksymalna długość tesktu w kolumnie wynosi sto znaków.
	@Column(nullable = false, length = 100)
	private String status;

	// Dodanie konstruktora bezparametrowego.
	public StatusDocument() {
	}

	// Dodanie konstruktora z parametrami. - Pomaga w tworzeniu obiektów.
	// Wykorzystywany np. w klasie Sample w celu wypełnienia bazy danymi.
	public StatusDocument(@NotNull String status) throws ParseException {
		this.status = status;
	}

	// Poniżej znajdują się Gettery oraz Settery pól obiektów.
	// Wykorzystywane do pobierania oraz zapisywania danych z lub do obiektów.
	
	public Integer getIdStatusDocument() {
		return idStatusDocument;
	}

	public void setIdStatusDocument(Integer idStatusDocument) {
		this.idStatusDocument = idStatusDocument;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}