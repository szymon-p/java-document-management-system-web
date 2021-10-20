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
@Table(name = "typeDocument")
public class TypeDocument {

	// Definiuje klucz główny tabeli.
	@Id
	// Oznacza, że wartości klucza głównego są generowane automatycznie.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Mapuje kolumnę na pole klasy. Nie pozwala na przyjmowanie przez pole wartości null.
	@Column(nullable = false)
	private Integer idTypeDocument;
	
	// Mapuje kolumny na pola klasy. Nie pozwala na przyjmowanie przez pola wartości null.
	// Maksymalna długość tesktu w kolumnie wynosi sto znaków.
	@Column(nullable = false, length = 100)
	private String type;

	// Dodanie konstruktora bezparametrowego.
	public TypeDocument() {
	}

	// Dodanie konstruktora z parametrami. - Pomaga w tworzeniu obiektów.
	// Wykorzystywany np. w klasie Sample w celu wypełnienia bazy danymi.
	public TypeDocument(@NotNull String type) throws ParseException {
		this.type = type;
	}

	// Poniżej znajdują się Gettery oraz Settery pól obiektów.
	// Wykorzystywane do pobierania oraz zapisywania danych z lub do obiektów.
	
	public Integer getIdTypeDocument() {
		return idTypeDocument;
	}

	public void setIdTypeDocument(Integer idTypeDocument) {
		this.idTypeDocument = idTypeDocument;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}