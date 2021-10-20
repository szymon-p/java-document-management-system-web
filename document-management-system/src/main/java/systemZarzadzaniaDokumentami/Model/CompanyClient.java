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
@Table(name = "companyClient")
public class CompanyClient {

	// Definiuje klucz główny tabeli.
	@Id
	// Oznacza, że wartości klucza głównego są generowane automatycznie.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Mapuje kolumnę na pole klasy. Nie pozwala na przyjmowanie przez pole wartości null.
	@Column(nullable = false)
	private Integer idCompany;

	// Mapuje kolejne kolumny w tabeli w bazie danych, z poniższych pól klasy.
	// Maksymalna długość tesktu w kolumnie wynosi sto znaków.
	@Column(length = 100)
	private String streetCompany;
	private String apartNumbCompany;
	private String zipCodeCompany;
	private String cityCompany;
	
	// Mapuje kolumnę na pole klasy. Nie pozwala na przyjmowanie przez pole wartości null.
	// Maksymalna długość tesktu w kolumnie wynosi sto znaków.
	@Column(nullable = false, length = 100)
	private String nameCompany;

	// Dodanie konstruktora bezparametrowego.
	public CompanyClient() {
	}

	// Dodanie konstruktora z parametrami. - Pomaga w tworzeniu obiektów.
	// Wykorzystywany np. w klasie Sample w celu wypełnienia bazy danymi.
	public CompanyClient(@NotNull String nameCompany, String streetCompany, String apartNumbCompany,
			String zipCodeCompany, String cityCompany) throws ParseException {
		this.nameCompany = nameCompany;
		this.streetCompany = streetCompany;
		this.apartNumbCompany = apartNumbCompany;
		this.zipCodeCompany = zipCodeCompany;
		this.cityCompany = cityCompany;
	}

	// Poniżej znajdują się Gettery oraz Settery pól obiektów.
	// Wykorzystywane do pobierania oraz zapisywania danych z lub do obiektów.
	
	public Integer getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(Integer idCompany) {
		this.idCompany = idCompany;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public String getStreetCompany() {
		return streetCompany;
	}

	public void setStreetCompany(String streetCompany) {
		this.streetCompany = streetCompany;
	}

	public String getApartNumbCompany() {
		return apartNumbCompany;
	}

	public void setApartNumbCompany(String apartNumbCompany) {
		this.apartNumbCompany = apartNumbCompany;
	}

	public String getZipCodeCompany() {
		return zipCodeCompany;
	}

	public void setZipCodeCompany(String zipCodeCompany) {
		this.zipCodeCompany = zipCodeCompany;
	}

	public String getCityCompany() {
		return cityCompany;
	}

	public void setCityCompany(String cityCompany) {
		this.cityCompany = cityCompany;
	}
}