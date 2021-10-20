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
@Table(name = "user")
public class User {

	// Definiuje klucz główny tabeli.
	@Id
	// Oznacza, że wartości klucza głównego są generowane automatycznie.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Mapuje kolumnę na pole klasy. Nie pozwala na przyjmowanie przez pole wartości null.
	@Column(nullable = false)
	private Integer idUser;
	
	// Mapuje kolumny na pola klasy. Nie pozwala na przyjmowanie przez pola wartości null.
	// Maksymalna długość tesktu w kolumnie wynosi sto znaków.
	@Column(nullable = false, length = 100)
	private String nameUser;
	private String lastNameUser;
	private String loginUser;
	private String passwordUser;

	// Dodanie konstruktora bezparametrowego.
	public User() {
	}

	// Dodanie konstruktora z parametrami. - Pomaga w tworzeniu obiektów.
	// Wykorzystywany np. w klasie Sample w celu wypełnienia bazy danymi.
	public User(@NotNull String nameUser, @NotNull String lastNameUser, @NotNull String loginUser,
			@NotNull String passwordUser) throws ParseException {
		this.nameUser = nameUser;
		this.lastNameUser = lastNameUser;
		this.loginUser = loginUser;
		this.passwordUser = passwordUser;
	}

	// Poniżej znajdują się Gettery oraz Settery pól obiektów.
	// Wykorzystywane do pobierania oraz zapisywania danych z lub do obiektów.
	
	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getLastNameUser() {
		return lastNameUser;
	}

	public void setLastNameUser(String lastNameUser) {
		this.lastNameUser = lastNameUser;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}
}