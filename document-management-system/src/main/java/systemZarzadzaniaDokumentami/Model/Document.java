package systemZarzadzaniaDokumentami.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Formula;

//Oznaczenie danej klasy jako encji - odwzorowanie na tabelę. - Pola obiektu będą mapowane na pola tabeli w bazie danych.
@Entity

//Mapuje klasę do tabeli w bazie danych.
@Table(name = "document")
public class Document {

	// Definiuje klucz główny tabeli.
	@Id
	// Oznacza, że wartości klucza głównego są generowane automatycznie.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Mapuje kolumnę na pole klasy. Nie pozwala na przyjmowanie przez pole wartości null.
	@Column(nullable = false)
	private Integer idDocument;
	
	// Mapuje kolumny na pola klasy (klucze obce). Nie pozwala na przyjmowanie przez pola wartości null.
	@Column(nullable = false)
	private Integer clientIdClient;
	private Integer statusDocumentIdStatusDocument;
	private Integer typeDocumentIdTypeDocument;
	private Integer userIdUser;
	
	// Mapuje kolejne kolumny w tabeli w bazie danych, z poniższych pól klasy.
	@Column
	private Date openDate;
	private Date endDate;
	private String urlDocument;

	// Adnotacja pozwala na wysłanie zapytania do bazy danych oraz zapis rezultatu do zmiennej typu String. 
	//Pole następnie nie jest automatycznie aktualizowane. Pole jest wykorzystywane przez Thymeleafa w Widoku /documents.
	@Formula("(select st.status from status_document st where st.id_status_document = status_document_id_status_document)")
	private String status;

	// Adnotacja pozwala na wysłanie zapytania do bazy danych oraz zapis rezultatu do zmiennej typu String. 
	//Pole następnie nie jest automatycznie aktualizowane. Pole jest wykorzystywane przez Thymeleafa w Widoku /documents.
	@Formula("(select ty.type from type_document ty where ty.id_type_document = type_document_id_type_document)")
	private String type;

	// Adnotacja pozwala na wysłanie zapytania do bazy danych oraz zapis rezultatu do zmiennej typu String. 
	//Pole następnie nie jest automatycznie aktualizowane. Pole jest wykorzystywane przez Thymeleafa w Widoku /documents.
	@Formula("(select us.last_name_user||' '||us.name_user from user us where us.id_user = user_id_user)")
	private String user;

	// Adnotacja pozwala na wysłanie zapytania do bazy danych oraz zapis rezultatu do zmiennej typu String. 
	//Pole następnie nie jest automatycznie aktualizowane. Pole jest wykorzystywane przez Thymeleafa w Widoku /documents.
	@Formula("(select cl.last_name_client||' '||cl.name_client from client cl where cl.id_client = client_id_client)")
	private String client;

	// Adnotacja pozwala na wysłanie zapytania do bazy danych oraz zapis rezultatu do zmiennej typu String. 
	//Pole następnie nie jest automatycznie aktualizowane. Pole jest wykorzystywane przez Thymeleafa w Widoku /documents.
	@Formula("(select co.name_company from client cl, company_client co "
			+ "where co.id_company = cl.company_client_id_company and client_id_client = cl.id_client)")
	private String company;

	// Adnotacja pozwalająca na pominięcie mapowania kolumny z polem obiektu.
	@Transient
	// Utworzenie obiektu do manipulacji formatem daty.
	private SimpleDateFormat formatter;

	// Dodanie konstruktora bezparametrowego.
	public Document() {
	}

	// Dodanie konstruktora z parametrami. - Pomaga w tworzeniu obiektów.
	// Wykorzystywany np. w klasie Sample w celu wypełnienia bazy danymi.
	public Document(@NotNull Integer clientIdClient, String endDate, String openDate,
			@NotNull Integer statusDocumentIdStatusDocument, @NotNull Integer typeDocumentIdTypeDocument,
			@NotNull Integer userIdUser, String urlDocument) throws ParseException {
		this.clientIdClient = clientIdClient;
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		this.endDate = formatter.parse(endDate);
		this.openDate = formatter.parse(openDate);
		this.statusDocumentIdStatusDocument = statusDocumentIdStatusDocument;
		this.typeDocumentIdTypeDocument = typeDocumentIdTypeDocument;
		this.userIdUser = userIdUser;
		this.urlDocument = urlDocument;
	}

	// Poniżej znajdują się Gettery oraz Settery pól obiektów.
	// Wykorzystywane do pobierania oraz zapisywania danych z lub do obiektów.
	
	public Integer getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(Integer idDocument) {
		this.idDocument = idDocument;
	}

	public Integer getClientIdClient() {
		return clientIdClient;
	}

	public void setClientIdClient(Integer clientIdClient) {
		this.clientIdClient = clientIdClient;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Integer getStatusDocumentIdStatusDocument() {
		return statusDocumentIdStatusDocument;
	}

	public void setStatusDocumentIdStatusDocument(Integer statusDocumentIdStatusDocument) {
		this.statusDocumentIdStatusDocument = statusDocumentIdStatusDocument;
	}

	public Integer getTypeDocumentIdTypeDocument() {
		return typeDocumentIdTypeDocument;
	}

	public void setTypeDocumentIdTypeDocument(Integer typeDocumentIdTypeDocument) {
		this.typeDocumentIdTypeDocument = typeDocumentIdTypeDocument;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getUserIdUser() {
		return userIdUser;
	}

	public void setUserIdUser(Integer userIdUser) {
		this.userIdUser = userIdUser;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getUrlDocument() {
		return urlDocument;
	}

	public void setUrlDocument(String urlDocument) {
		this.urlDocument = urlDocument;
	}
}