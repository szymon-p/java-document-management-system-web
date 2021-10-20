package systemZarzadzaniaDokumentami.Model;

import java.text.ParseException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

// Oznaczenie danej klasy jako encji - odwzorowanie na tabelę. - Pola obiektu będą mapowane na pola tabeli w bazie danych.
@Entity

// Mapuje klasę do tabeli w bazie danych.
@Table(name = "client")
public class Client {

	// Definiuje klucz główny tabeli.
	@Id
	// Oznacza, że wartości klucza głównego są generowane automatycznie.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Mapuje kolumnę na pole klasy. Nie pozwala na przyjmowanie przez pole wartości null.
	@Column(nullable = false)
	private Integer idClient;

	// Mapuje kolumnę na pole klasy (klucz obcy). Nie pozwala na przyjmowanie przez pole wartości null.
	@Column(nullable = false)
	private Integer companyClientIdCompany;
	
	// Mapuje kolumny na pola klasy. Nie pozwala na przyjmowanie przez pola wartości null.
	// Maksymalna długość tesktu w kolumnie wynosi sto znaków.
	@Column(nullable = false, length = 100)
	private String nameClient;
	private String lastNameClient;
	
	// Mapuje kolejne kolumny w tabeli w bazie danych, z poniższych pól klasy.
	// Maksymalna długość tesktu w kolumnie wynosi sto znaków.
	@Column(length = 100)
	private String mailClient;

	// Dodanie konstruktora bezparametrowego.
	public Client() {
	}

	// Dodanie konstruktora z parametrami. - Pomaga w tworzeniu obiektów.
	// Wykorzystywany np. w klasie Sample w celu wypełnienia bazy danymi.
	public Client(@NotNull Integer companyClientIdCompany, @NotNull String nameClient, @NotNull String lastNameClient, 
			String mailClient) throws ParseException {
		this.companyClientIdCompany = companyClientIdCompany;
		this.nameClient = nameClient;
		this.lastNameClient = lastNameClient;
		this.mailClient = mailClient;
	}

	// Poniżej znajdują się Gettery oraz Settery pól obiektów.
	// Wykorzystywane do pobierania oraz zapisywania danych z lub do obiektów.

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public Integer getCompanyClientIdCompany() {
		return companyClientIdCompany;
	}

	public void setCompanyClientIdCompany(Integer companyClientIdCompany) {
		this.companyClientIdCompany = companyClientIdCompany;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public String getLastNameClient() {
		return lastNameClient;
	}

	public void setLastNameClient(String lastNameClient) {
		this.lastNameClient = lastNameClient;
	}

	public String getMailClient() {
		return mailClient;
	}

	public void setMailClient(String mailClient) {
		this.mailClient = mailClient;
	}
}