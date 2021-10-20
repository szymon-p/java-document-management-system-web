package systemZarzadzaniaDokumentami;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import systemZarzadzaniaDokumentami.Model.Client;
import systemZarzadzaniaDokumentami.Model.CompanyClient;
import systemZarzadzaniaDokumentami.Model.Document;
import systemZarzadzaniaDokumentami.Model.StatusDocument;
import systemZarzadzaniaDokumentami.Model.TypeDocument;
import systemZarzadzaniaDokumentami.Model.User;
import systemZarzadzaniaDokumentami.Repository.ClientRepository;
import systemZarzadzaniaDokumentami.Repository.CompanyClientRepository;
import systemZarzadzaniaDokumentami.Repository.DocumentRepository;
import systemZarzadzaniaDokumentami.Repository.Status_documentRepository;
import systemZarzadzaniaDokumentami.Repository.Type_documentRepository;
import systemZarzadzaniaDokumentami.Repository.UserRepository;

// Adnostacja @Component zapewnia, że podczas skanowania ścieżek klas zostaną one automatycznie zarejestrowane i przygotowane do użycia.
@Component
public class Sample implements CommandLineRunner {

	// Wstrzyknięcie obiektów Repository odpowiednich klas poprzez @Autowired w celu
	// późniejszego zapisu danych do bazy.
	@Autowired
	DocumentRepository documentRepository;
	@Autowired
	Status_documentRepository statusDocumentRepository;
	@Autowired
	Type_documentRepository typeDocumentRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	CompanyClientRepository companyClientRepository;

	// pozwala na załadowanie zawartości metody przed zakończeniem wykonywania
	// metody SpringApplication.run oraz po ukończeniu ładowania ApplicationContext.
	// W rezultacie baza jest wypełniona danymi do pracy, po załadowaniu aplikacji.
	@Override
	public void run(String... args) throws Exception {

		// Załadowanie danych do encji StatusDocument
		StatusDocument statusDocument1 = new StatusDocument("zakończony");
		statusDocumentRepository.save(statusDocument1);
		StatusDocument statusDocument2 = new StatusDocument("otwarty");
		statusDocumentRepository.save(statusDocument2);
		StatusDocument statusDocument3 = new StatusDocument("nowy");
		statusDocumentRepository.save(statusDocument3);
		StatusDocument statusDocument4 = new StatusDocument("w toku");
		statusDocumentRepository.save(statusDocument4);
		StatusDocument statusDocument5 = new StatusDocument("wstrzymany");
		statusDocumentRepository.save(statusDocument5);

		// Załadowanie danych do encji TypeDocument
		TypeDocument typeDocument1 = new TypeDocument("wniosek");
		typeDocumentRepository.save(typeDocument1);
		TypeDocument typeDocument2 = new TypeDocument("reklamacja");
		typeDocumentRepository.save(typeDocument2);
		TypeDocument typeDocument3 = new TypeDocument("wezwanie");
		typeDocumentRepository.save(typeDocument3);
		TypeDocument typeDocument4 = new TypeDocument("upomnienie");
		typeDocumentRepository.save(typeDocument4);
		TypeDocument typeDocument5 = new TypeDocument("skarga");
		typeDocumentRepository.save(typeDocument5);

		// Załadowanie danych do encji User
		User user1 = new User("Szymon", "Przybysławski", "PSZYMON", "123456");
		userRepository.save(user1);
		User user2 = new User("Bartłomiej", "Mucha", "MBARTŁOMIEJ", "123456");
		userRepository.save(user2);
		User user3 = new User("Dawid", "Skoczylas", "SDAWID", "123456");
		userRepository.save(user3);
		User user4 = new User("Anna", "Wielogórka", "WANNA", "123456");
		userRepository.save(user4);
		User user5 = new User("Katarzyna", "Cerwińska", "CKATARZYNA", "123456");
		userRepository.save(user5);

		// Załadowanie danych do encji Document
		Document document1 = new Document(64, "2019-12-12 02:20", "2019-06-29 11:32", 1, 4, 1, null);
		documentRepository.save(document1);
		Document document2 = new Document(94, "2019-09-12 17:29", "2019-06-11 19:13", 4, 4, 4, null);
		documentRepository.save(document2);
		Document document3 = new Document(48, "2019-11-23 10:09", "2019-03-27 01:23", 2, 5, 2, null);
		documentRepository.save(document3);
		Document document4 = new Document(23, "2019-10-13 13:32", "2019-02-21 18:24", 4, 4, 4, null);
		documentRepository.save(document4);
		Document document5 = new Document(55, "2019-09-08 00:52", "2019-03-03 10:17", 4, 5, 1, null);
		documentRepository.save(document5);
		Document document6 = new Document(62, "2019-11-12 23:50", "2019-04-10 12:28", 5, 2, 5, null);
		documentRepository.save(document6);
		Document document7 = new Document(88, "2019-12-30 13:08", "2019-01-22 11:29", 1, 3, 3, null);
		documentRepository.save(document7);
		Document document8 = new Document(40, "2019-12-31 13:18", "2019-05-15 21:39", 3, 5, 4, null);
		documentRepository.save(document8);
		Document document9 = new Document(97, "2019-08-05 21:44", "2019-05-01 08:20", 5, 4, 2, null);
		documentRepository.save(document9);
		Document document10 = new Document(25, "2019-10-20 10:40", "2019-02-16 10:38", 2, 5, 4, null);
		documentRepository.save(document10);
		Document document11 = new Document(85, "2019-11-18 13:26", "2019-05-12 11:54", 1, 2, 4, null);
		documentRepository.save(document11);
		Document document12 = new Document(50, "2019-10-22 19:43", "2019-01-26 23:29", 5, 2, 1, null);
		documentRepository.save(document12);
		Document document13 = new Document(36, "2019-09-30 01:05", "2019-04-23 15:10", 2, 3, 4, null);
		documentRepository.save(document13);
		Document document14 = new Document(68, "2019-07-12 09:15", "2019-01-14 09:56", 1, 5, 3, null);
		documentRepository.save(document14);
		Document document15 = new Document(61, "2019-07-14 17:13", "2019-04-26 02:12", 4, 2, 2, null);
		documentRepository.save(document15);
		Document document16 = new Document(67, "2019-09-16 03:25", "2019-01-20 13:57", 1, 1, 4, null);
		documentRepository.save(document16);
		Document document17 = new Document(84, "2019-11-29 04:41", "2019-01-09 15:19", 2, 3, 5, null);
		documentRepository.save(document17);
		Document document18 = new Document(71, "2019-12-29 11:56", "2019-04-02 09:43", 3, 5, 4, null);
		documentRepository.save(document18);
		Document document19 = new Document(18, "2019-07-04 15:21", "2019-03-04 13:04", 5, 2, 1, null);
		documentRepository.save(document19);
		Document document20 = new Document(35, "2019-12-22 17:10", "2019-05-09 12:03", 4, 4, 4, null);
		documentRepository.save(document20);
		Document document21 = new Document(17, "2019-10-31 06:52", "2019-06-10 11:07", 3, 2, 2, null);
		documentRepository.save(document21);
		Document document22 = new Document(90, "2019-10-15 00:00", "2019-06-18 04:23", 4, 1, 3, null);
		documentRepository.save(document22);
		Document document23 = new Document(86, "2019-07-03 20:32", "2019-03-31 21:28", 1, 1, 2, null);
		documentRepository.save(document23);
		Document document24 = new Document(63, "2019-09-16 06:43", "2019-02-15 12:51", 4, 3, 5, null);
		documentRepository.save(document24);
		Document document25 = new Document(81, "2019-12-15 12:37", "2019-03-06 21:44", 5, 2, 1, null);
		documentRepository.save(document25);
		Document document26 = new Document(26, "2019-11-01 22:54", "2019-06-10 07:03", 5, 2, 4, null);
		documentRepository.save(document26);
		Document document27 = new Document(39, "2019-10-21 05:18", "2019-05-30 07:14", 5, 1, 3, null);
		documentRepository.save(document27);
		Document document28 = new Document(78, "2019-07-01 09:46", "2019-02-14 17:05", 3, 4, 3, null);
		documentRepository.save(document28);
		Document document29 = new Document(44, "2019-08-02 20:04", "2019-02-07 07:15", 5, 3, 3, null);
		documentRepository.save(document29);
		Document document30 = new Document(54, "2019-11-01 04:22", "2019-06-25 05:08", 1, 2, 4, null);
		documentRepository.save(document30);
		Document document31 = new Document(37, "2019-09-14 14:44", "2019-06-01 22:21", 1, 5, 1, null);
		documentRepository.save(document31);
		Document document32 = new Document(21, "2019-08-16 00:44", "2019-06-19 05:10", 3, 2, 2, null);
		documentRepository.save(document32);
		Document document33 = new Document(100, "2019-08-31 21:34", "2019-02-25 14:12", 4, 2, 4, null);
		documentRepository.save(document33);
		Document document34 = new Document(10, "2019-08-09 22:46", "2019-02-13 13:55", 5, 1, 4, null);
		documentRepository.save(document34);
		Document document35 = new Document(13, "2019-11-03 06:16", "2019-05-24 05:06", 2, 5, 4, null);
		documentRepository.save(document35);
		Document document36 = new Document(92, "2019-08-09 20:07", "2019-04-20 23:14", 5, 3, 3, null);
		documentRepository.save(document36);
		Document document37 = new Document(22, "2019-08-18 01:06", "2019-06-02 02:47", 2, 3, 3, null);
		documentRepository.save(document37);
		Document document38 = new Document(87, "2019-09-17 12:18", "2019-04-03 07:44", 3, 2, 5, null);
		documentRepository.save(document38);
		Document document39 = new Document(12, "2019-10-23 23:08", "2019-02-22 13:11", 3, 3, 1, null);
		documentRepository.save(document39);
		Document document40 = new Document(7, "2019-11-15 18:14", "2019-05-14 18:04", 1, 5, 3, null);
		documentRepository.save(document40);
		Document document41 = new Document(29, "2019-12-07 18:26", "2019-05-30 08:06", 2, 3, 2, null);
		documentRepository.save(document41);
		Document document42 = new Document(53, "2019-12-31 01:36", "2019-01-12 08:02", 3, 3, 3, null);
		documentRepository.save(document42);
		Document document43 = new Document(76, "2019-07-13 05:00", "2019-06-12 05:32", 1, 5, 3, null);
		documentRepository.save(document43);
		Document document44 = new Document(95, "2019-07-02 12:41", "2019-06-30 09:02", 1, 2, 4, null);
		documentRepository.save(document44);
		Document document45 = new Document(80, "2019-07-31 04:02", "2019-05-30 00:17", 5, 5, 4, null);
		documentRepository.save(document45);
		Document document46 = new Document(79, "2019-12-12 14:29", "2019-06-19 07:41", 1, 1, 3, null);
		documentRepository.save(document46);
		Document document47 = new Document(59, "2019-10-17 18:50", "2019-02-14 23:06", 4, 2, 2, null);
		documentRepository.save(document47);
		Document document48 = new Document(9, "2019-07-02 08:09", "2019-01-20 11:37", 5, 1, 5, null);
		documentRepository.save(document48);
		Document document49 = new Document(27, "2019-10-11 03:09", "2019-02-27 16:29", 1, 5, 2, null);
		documentRepository.save(document49);
		Document document50 = new Document(33, "2019-11-10 09:28", "2019-01-07 03:12", 4, 2, 3, null);
		documentRepository.save(document50);
		Document document51 = new Document(20, "2019-07-21 21:03", "2019-01-25 05:10", 5, 2, 5, null);
		documentRepository.save(document51);
		Document document52 = new Document(4, "2019-08-02 11:27", "2019-01-29 16:44", 4, 4, 2, null);
		documentRepository.save(document52);
		Document document53 = new Document(8, "2019-07-16 08:46", "2019-03-31 07:53", 2, 4, 1, null);
		documentRepository.save(document53);
		Document document54 = new Document(96, "2019-09-18 20:00", "2019-06-02 10:09", 4, 3, 3, null);
		documentRepository.save(document54);
		Document document55 = new Document(49, "2019-12-08 08:39", "2019-05-18 01:45", 5, 4, 2, null);
		documentRepository.save(document55);
		Document document56 = new Document(15, "2019-11-10 05:34", "2019-03-02 22:47", 2, 4, 2, null);
		documentRepository.save(document56);
		Document document57 = new Document(58, "2019-12-10 15:13", "2019-06-06 19:53", 3, 4, 5, null);
		documentRepository.save(document57);
		Document document58 = new Document(77, "2019-11-07 03:39", "2019-02-06 00:39", 4, 1, 3, null);
		documentRepository.save(document58);
		Document document59 = new Document(30, "2019-12-28 05:59", "2019-02-24 20:06", 4, 2, 1, null);
		documentRepository.save(document59);
		Document document60 = new Document(2, "2019-12-28 04:49", "2019-05-03 23:25", 1, 3, 2, null);
		documentRepository.save(document60);
		Document document61 = new Document(5, "2019-08-10 17:20", "2019-03-06 23:56", 2, 2, 4, null);
		documentRepository.save(document61);
		Document document62 = new Document(93, "2019-12-01 19:42", "2019-06-23 08:29", 2, 3, 5, null);
		documentRepository.save(document62);
		Document document63 = new Document(41, "2019-09-17 08:17", "2019-02-27 19:13", 1, 5, 3, null);
		documentRepository.save(document63);
		Document document64 = new Document(31, "2019-12-15 06:31", "2019-06-12 12:03", 3, 3, 2, null);
		documentRepository.save(document64);
		Document document65 = new Document(42, "2019-09-26 11:44", "2019-01-16 15:09", 5, 1, 1, null);
		documentRepository.save(document65);
		Document document66 = new Document(16, "2019-09-21 02:20", "2019-04-24 18:10", 4, 5, 4, null);
		documentRepository.save(document66);
		Document document67 = new Document(32, "2019-10-24 13:28", "2019-04-05 05:29", 3, 4, 2, null);
		documentRepository.save(document67);
		Document document68 = new Document(1, "2019-10-05 17:23", "2019-04-29 12:57", 3, 4, 1, null);
		documentRepository.save(document68);
		Document document69 = new Document(45, "2019-11-29 06:28", "2019-06-29 03:32", 2, 5, 4, null);
		documentRepository.save(document69);
		Document document70 = new Document(11, "2019-12-21 05:11", "2019-04-13 20:43", 3, 3, 3, null);
		documentRepository.save(document70);
		Document document71 = new Document(65, "2019-10-11 16:02", "2019-04-12 03:56", 5, 1, 4, null);
		documentRepository.save(document71);
		Document document72 = new Document(56, "2019-08-15 20:05", "2019-06-26 19:43", 2, 5, 5, null);
		documentRepository.save(document72);
		Document document73 = new Document(91, "2019-09-16 18:30", "2019-05-04 00:46", 2, 3, 2, null);
		documentRepository.save(document73);
		Document document74 = new Document(66, "2019-11-08 09:07", "2019-05-17 14:02", 5, 4, 2, null);
		documentRepository.save(document74);
		Document document75 = new Document(28, "2019-08-01 17:48", "2019-01-25 18:40", 4, 3, 2, null);
		documentRepository.save(document75);
		Document document76 = new Document(72, "2019-07-12 03:51", "2019-01-06 10:40", 5, 3, 2, null);
		documentRepository.save(document76);
		Document document77 = new Document(82, "2019-10-20 11:42", "2019-02-24 18:05", 3, 1, 2, null);
		documentRepository.save(document77);
		Document document78 = new Document(69, "2019-10-08 01:57", "2019-05-18 19:21", 5, 4, 4, null);
		documentRepository.save(document78);
		Document document79 = new Document(3, "2019-07-23 17:07", "2019-03-19 06:22", 5, 5, 4, null);
		documentRepository.save(document79);
		Document document80 = new Document(75, "2019-12-26 08:59", "2019-03-04 13:04", 3, 5, 3, null);
		documentRepository.save(document80);
		Document document81 = new Document(99, "2019-12-01 08:34", "2019-05-27 05:41", 3, 2, 2, null);
		documentRepository.save(document81);
		Document document82 = new Document(46, "2019-11-25 14:00", "2019-02-24 05:28", 1, 5, 1, null);
		documentRepository.save(document82);
		Document document83 = new Document(89, "2019-12-05 15:42", "2019-02-19 07:36", 1, 4, 1, null);
		documentRepository.save(document83);
		Document document84 = new Document(60, "2019-11-09 17:24", "2019-05-13 00:46", 2, 1, 1, null);
		documentRepository.save(document84);
		Document document85 = new Document(70, "2019-12-14 07:09", "2019-01-21 04:16", 2, 1, 1, null);
		documentRepository.save(document85);
		Document document86 = new Document(52, "2019-10-22 02:53", "2019-06-15 05:23", 1, 1, 3, null);
		documentRepository.save(document86);
		Document document87 = new Document(57, "2019-07-24 17:49", "2019-03-14 20:47", 3, 4, 5, null);
		documentRepository.save(document87);
		Document document88 = new Document(74, "2019-10-18 10:16", "2019-04-18 12:46", 2, 2, 2, null);
		documentRepository.save(document88);
		Document document89 = new Document(47, "2019-12-25 02:14", "2019-06-21 04:29", 1, 4, 3, null);
		documentRepository.save(document89);
		Document document90 = new Document(14, "2019-11-26 15:32", "2019-03-05 15:01", 1, 1, 2, null);
		documentRepository.save(document90);
		Document document91 = new Document(19, "2019-07-11 06:17", "2019-06-15 15:04", 3, 3, 3, null);
		documentRepository.save(document91);
		Document document92 = new Document(43, "2019-08-06 11:06", "2019-05-18 01:46", 1, 2, 5, null);
		documentRepository.save(document92);
		Document document93 = new Document(73, "2019-10-11 08:59", "2019-02-15 16:26", 4, 2, 2, null);
		documentRepository.save(document93);
		Document document94 = new Document(6, "2019-08-12 08:33", "2019-03-14 12:31", 4, 4, 3, null);
		documentRepository.save(document94);
		Document document95 = new Document(24, "2019-10-13 19:25", "2019-05-20 06:03", 2, 3, 5, null);
		documentRepository.save(document95);
		Document document96 = new Document(83, "2019-11-14 06:36", "2019-04-13 14:19", 2, 1, 5, null);
		documentRepository.save(document96);
		Document document97 = new Document(38, "2019-09-25 13:46", "2019-02-05 05:53", 4, 4, 4, null);
		documentRepository.save(document97);
		Document document98 = new Document(34, "2019-10-14 14:40", "2019-02-24 15:18", 4, 4, 2, null);
		documentRepository.save(document98);
		Document document99 = new Document(98, "2019-11-12 11:31", "2019-03-10 18:20", 5, 5, 2, null);
		documentRepository.save(document99);
		Document document100 = new Document(51, "2019-10-12 20:18", "2019-05-28 11:36", 3, 5, 4, null);
		documentRepository.save(document100);

		// Załadowanie danych do encji Client
		Client client1 = new Client(55, "Alberto", "Good", "bmidd@sbcglobal.net");
		clientRepository.save(client1);
		Client client2 = new Client(23, "Leonardo", "Chaney", "mosses@aol.com");
		clientRepository.save(client2);
		Client client3 = new Client(39, "Bobby", "Holland", "amaranth@me.com");
		clientRepository.save(client3);
		Client client4 = new Client(33, "Salvador", "Buck", "eegsa@optonline.net");
		clientRepository.save(client4);
		Client client5 = new Client(36, "Jakobe", "Wall", "openldap@att.net");
		clientRepository.save(client5);
		Client client6 = new Client(3, "Jasiah", "Herrera", "sacraver@optonline.net");
		clientRepository.save(client6);
		Client client7 = new Client(56, "Israel", "Herring", "roesch@icloud.com");
		clientRepository.save(client7);
		Client client8 = new Client(46, "Beckham", "Lamb", "mmccool@comcast.net");
		clientRepository.save(client8);
		Client client9 = new Client(66, "Arnav", "Nash", "heroine@gmail.com");
		clientRepository.save(client9);
		Client client10 = new Client(71, "Jaylan", "Mckee", "quinn@gmail.com");
		clientRepository.save(client10);
		Client client11 = new Client(100, "Zane", "Banks", "dhwon@verizon.net");
		clientRepository.save(client11);
		Client client12 = new Client(76, "Carlos", "Middleton", "jfreedma@optonline.net");
		clientRepository.save(client12);
		Client client13 = new Client(7, "Rodrigo", "Weiss", "ducasse@yahoo.com");
		clientRepository.save(client13);
		Client client14 = new Client(79, "Lorenzo", "Hamilton", "jtorkbob@me.com");
		clientRepository.save(client14);
		Client client15 = new Client(28, "Yosef", "Moss", "tedrlord@comcast.net");
		clientRepository.save(client15);
		Client client16 = new Client(94, "Markus", "Zavala", "temmink@me.com");
		clientRepository.save(client16);
		Client client17 = new Client(89, "Marley", "Grant", "jkegl@aol.com");
		clientRepository.save(client17);
		Client client18 = new Client(25, "Myles", "Pugh", "rhialto@att.net");
		clientRepository.save(client18);
		Client client19 = new Client(34, "Houston", "Walsh", "kostas@live.com");
		clientRepository.save(client19);
		Client client20 = new Client(48, "Immanuel", "Stewart", "uncle@att.net");
		clientRepository.save(client20);
		Client client21 = new Client(13, "Dane", "Terry", "pmint@live.com");
		clientRepository.save(client21);
		Client client22 = new Client(20, "Kameron", "Barnes", "jmmuller@me.com");
		clientRepository.save(client22);
		Client client23 = new Client(92, "Enzo", "Tucker", "brbarret@sbcglobal.net");
		clientRepository.save(client23);
		Client client24 = new Client(14, "Shaun", "Pearson", "crimsane@yahoo.ca");
		clientRepository.save(client24);
		Client client25 = new Client(63, "Nathen", "Lee", "kronvold@mac.com");
		clientRepository.save(client25);
		Client client26 = new Client(47, "Deven", "Cameron", "intlprog@icloud.com");
		clientRepository.save(client26);
		Client client27 = new Client(53, "Humberto", "Trujillo", "scottlee@sbcglobal.net");
		clientRepository.save(client27);
		Client client28 = new Client(60, "Gilbert", "Vasquez", "zeller@optonline.net");
		clientRepository.save(client28);
		Client client29 = new Client(91, "Ernest", "Warren", "stellaau@att.net");
		clientRepository.save(client29);
		Client client30 = new Client(27, "Erick", "Perkins", "bancboy@hotmail.com");
		clientRepository.save(client30);
		Client client31 = new Client(75, "Muhammad", "Wise", "heckerman@live.com");
		clientRepository.save(client31);
		Client client32 = new Client(2, "Bailey", "Mckay", "dsugal@mac.com");
		clientRepository.save(client32);
		Client client33 = new Client(10, "Walter", "Coffey", "bmorrow@icloud.com");
		clientRepository.save(client33);
		Client client34 = new Client(49, "Holden", "Mayo", "kiddailey@me.com");
		clientRepository.save(client34);
		Client client35 = new Client(1, "James", "Trevino", "biglou@me.com");
		clientRepository.save(client35);
		Client client36 = new Client(96, "Nico", "Carey", "maikelnai@icloud.com");
		clientRepository.save(client36);
		Client client37 = new Client(32, "Callum", "Mcguire", "burns@icloud.com");
		clientRepository.save(client37);
		Client client38 = new Client(72, "Ace", "Guerra", "aukjan@mac.com");
		clientRepository.save(client38);
		Client client39 = new Client(83, "Toby", "Carrillo", "salesgeek@sbcglobal.net");
		clientRepository.save(client39);
		Client client40 = new Client(98, "Kendrick", "Huffman", "murty@me.com");
		clientRepository.save(client40);
		Client client41 = new Client(99, "Sergio", "Rowe", "padme@aol.com");
		clientRepository.save(client41);
		Client client42 = new Client(69, "Colt", "Maddox", "cisugrad@icloud.com");
		clientRepository.save(client42);
		Client client43 = new Client(85, "Tyler", "Tyler", "joehall@me.com");
		clientRepository.save(client43);
		Client client44 = new Client(90, "Rogelio", "Johnson", "bwcarty@outlook.com");
		clientRepository.save(client44);
		Client client45 = new Client(11, "Dereon", "Walter", "pmint@verizon.net");
		clientRepository.save(client45);
		Client client46 = new Client(24, "Aron", "Bowman", "thurston@me.com");
		clientRepository.save(client46);
		Client client47 = new Client(61, "Terrell", "Haynes", "curly@hotmail.com");
		clientRepository.save(client47);
		Client client48 = new Client(81, "Jeffery", "Nelson", "shaffei@outlook.com");
		clientRepository.save(client48);
		Client client49 = new Client(35, "Grady", "Neal", "hoangle@optonline.net");
		clientRepository.save(client49);
		Client client50 = new Client(65, "Yael", "Hines", "leslie@att.net");
		clientRepository.save(client50);
		Client client51 = new Client(19, "Cameron", "Clayton", "malattia@icloud.com");
		clientRepository.save(client51);
		Client client52 = new Client(18, "Everett", "Garrison", "citizenl@icloud.com");
		clientRepository.save(client52);
		Client client53 = new Client(37, "Tony", "Frank", "mschilli@yahoo.ca");
		clientRepository.save(client53);
		Client client54 = new Client(84, "Jaeden", "Archer", "dwsauder@outlook.com");
		clientRepository.save(client54);
		Client client55 = new Client(97, "Sullivan", "Kelley", "hellfire@hotmail.com");
		clientRepository.save(client55);
		Client client56 = new Client(12, "Nickolas", "Peters", "noticias@comcast.net");
		clientRepository.save(client56);
		Client client57 = new Client(78, "Kyler", "Hart", "boftx@outlook.com");
		clientRepository.save(client57);
		Client client58 = new Client(59, "Tyrone", "Chambers", "jaffe@icloud.com");
		clientRepository.save(client58);
		Client client59 = new Client(68, "Marquis", "Patton", "draper@aol.com");
		clientRepository.save(client59);
		Client client60 = new Client(38, "Kayden", "Reese", "bester@comcast.net");
		clientRepository.save(client60);
		Client client61 = new Client(93, "Ayden", "Sanchez", "sekiya@icloud.com");
		clientRepository.save(client61);
		Client client62 = new Client(87, "Hugo", "Wilson", "andersbr@me.com");
		clientRepository.save(client62);
		Client client63 = new Client(95, "Keenan", "Velez", "jfreedma@icloud.com");
		clientRepository.save(client63);
		Client client64 = new Client(73, "Leo", "Farley", "claypool@sbcglobal.net");
		clientRepository.save(client64);
		Client client65 = new Client(42, "Alejandro", "Washington", "brbarret@me.com");
		clientRepository.save(client65);
		Client client66 = new Client(57, "Skyler", "Sandoval", "brickbat@att.net");
		clientRepository.save(client66);
		Client client67 = new Client(21, "Jayden", "Fleming", "amimojo@gmail.com");
		clientRepository.save(client67);
		Client client68 = new Client(44, "Luka", "Huerta", "offthelip@aol.com");
		clientRepository.save(client68);
		Client client69 = new Client(30, "Julien", "Kaufman", "devphil@optonline.net");
		clientRepository.save(client69);
		Client client70 = new Client(52, "Tristin", "Luna", "lishoy@yahoo.ca");
		clientRepository.save(client70);
		Client client71 = new Client(5, "Jack", "Mullins", "mahbub@live.com");
		clientRepository.save(client71);
		Client client72 = new Client(70, "Jett", "Mcintosh", "lamprecht@me.com");
		clientRepository.save(client72);
		Client client73 = new Client(16, "Dax", "Higgins", "openldap@outlook.com");
		clientRepository.save(client73);
		Client client74 = new Client(64, "Maxwell", "Barron", "fangorn@att.net");
		clientRepository.save(client74);
		Client client75 = new Client(31, "Drake", "Schultz", "hoyer@comcast.net");
		clientRepository.save(client75);
		Client client76 = new Client(29, "Jonathan", "Zuniga", "gerlo@gmail.com");
		clientRepository.save(client76);
		Client client77 = new Client(17, "Jaydin", "Griffin", "padme@me.com");
		clientRepository.save(client77);
		Client client78 = new Client(40, "Alvaro", "Everett", "mosses@yahoo.com");
		clientRepository.save(client78);
		Client client79 = new Client(50, "Nikolai", "Ponce", "gtewari@gmail.com");
		clientRepository.save(client79);
		Client client80 = new Client(43, "Kyle", "Simpson", "bsikdar@optonline.net");
		clientRepository.save(client80);
		Client client81 = new Client(15, "Cody", "Santana", "itstatus@msn.com");
		clientRepository.save(client81);
		Client client82 = new Client(6, "Tommy", "Mays", "janusfury@hotmail.com");
		clientRepository.save(client82);
		Client client83 = new Client(26, "Brandon", "Kidd", "xtang@mac.com");
		clientRepository.save(client83);
		Client client84 = new Client(58, "Jagger", "Maldonado", "stecoop@gmail.com");
		clientRepository.save(client84);
		Client client85 = new Client(22, "Jamarcus", "Little", "ntegrity@yahoo.com");
		clientRepository.save(client85);
		Client client86 = new Client(9, "Ryder", "Oconnell", "mnemonic@icloud.com");
		clientRepository.save(client86);
		Client client87 = new Client(4, "London", "Suarez", "world@icloud.com");
		clientRepository.save(client87);
		Client client88 = new Client(45, "Jadiel", "Joseph", "frosal@att.net");
		clientRepository.save(client88);
		Client client89 = new Client(51, "Kenneth", "Logan", "webinc@sbcglobal.net");
		clientRepository.save(client89);
		Client client90 = new Client(88, "Damari", "Fowler", "fallorn@comcast.net");
		clientRepository.save(client90);
		Client client91 = new Client(41, "Devan", "Mills", "dobey@sbcglobal.net");
		clientRepository.save(client91);
		Client client92 = new Client(80, "Yusuf", "Rose", "kobayasi@gmail.com");
		clientRepository.save(client92);
		Client client93 = new Client(82, "Brayden", "Moyer", "amichalo@msn.com");
		clientRepository.save(client93);
		Client client94 = new Client(62, "Brendan", "Waters", "ajohnson@msn.com");
		clientRepository.save(client94);
		Client client95 = new Client(86, "Royce", "Reynolds", "louise@aol.com");
		clientRepository.save(client95);
		Client client96 = new Client(67, "Kamari", "Brown", "hutton@gmail.com");
		clientRepository.save(client96);
		Client client97 = new Client(54, "Elian", "Howe", "jacks@gmail.com");
		clientRepository.save(client97);
		Client client98 = new Client(77, "Kolton", "Conner", "petersen@hotmail.com");
		clientRepository.save(client98);
		Client client99 = new Client(74, "Rylan", "Best", "nogin@mac.com");
		clientRepository.save(client99);
		Client client100 = new Client(8, "Rudy", "Landry", "danny@live.com");
		clientRepository.save(client100);

		// Załadowanie danych do encji CompanyClient
		CompanyClient companyClient1 = new CompanyClient("Hanesbrands", "Myrtle Avenue", "941", "34-869", "Massley");
		companyClientRepository.save(companyClient1);
		CompanyClient companyClient2 = new CompanyClient("New York Life Insurance", "11th Street", "114", "23-660",
				"Farmingworth");
		companyClientRepository.save(companyClient2);
		CompanyClient companyClient3 = new CompanyClient("Netflix", "Howard Street", "477", "60-400", "South Bellley");
		companyClientRepository.save(companyClient3);
		CompanyClient companyClient4 = new CompanyClient("Marsh & McLennan", "Arlington Avenue", "908", "75-386",
				"Fishby");
		companyClientRepository.save(companyClient4);
		CompanyClient companyClient5 = new CompanyClient("Motorola Solutions", "Cooper Street", "269", "57-778",
				"Northside");
		companyClientRepository.save(companyClient5);
		CompanyClient companyClient6 = new CompanyClient("WellCare Health Plans", "4th Street South", "112A", "69-226",
				"Passford");
		companyClientRepository.save(companyClient6);
		CompanyClient companyClient7 = new CompanyClient("PREVIO", "Forest Drive", "95B", "26-858", "Bannkarta");
		companyClientRepository.save(companyClient7);
		CompanyClient companyClient8 = new CompanyClient("General Electric", "Laurel Drive", "217C", "94-271",
				"Holtsborough");
		companyClientRepository.save(companyClient8);
		CompanyClient companyClient9 = new CompanyClient("Intercontinental Exchange", "Fawn Court", "337A", "79-228",
				"Passcester");
		companyClientRepository.save(companyClient9);
		CompanyClient companyClient10 = new CompanyClient("Freddie Mac", "Orchard Lane", "433C", "83-019",
				"Sagecaster");
		companyClientRepository.save(companyClient10);
		CompanyClient companyClient11 = new CompanyClient("PPG Industries", "Monroe Drive", "54A", "39-824",
				"Dodgepool");
		companyClientRepository.save(companyClient11);
		CompanyClient companyClient12 = new CompanyClient("Graphic Packaging Holding", "13th Street", "492C", "70-685",
				"Dodgeland");
		companyClientRepository.save(companyClient12);
		CompanyClient companyClient13 = new CompanyClient("Unum Group", "Bay Street", "319B", "84-400", "Fauxham City");
		companyClientRepository.save(companyClient13);
		CompanyClient companyClient14 = new CompanyClient("American Family Insurance Group", "Heather Court", "357B",
				"75-952", "Angerkarta");
		companyClientRepository.save(companyClient14);
		CompanyClient companyClient15 = new CompanyClient("Franklin Resources", "Linda Lane", "352C", "73-661",
				"Norburg");
		companyClientRepository.save(companyClient15);
		CompanyClient companyClient16 = new CompanyClient("PBF Energy", "Schoolhouse Lane", "461B", "13-972",
				"Fairmouth");
		companyClientRepository.save(companyClient16);
		CompanyClient companyClient17 = new CompanyClient("Old Republic International", "Bridle Court", "277B",
				"62-834", "Snowhampton");
		companyClientRepository.save(companyClient17);
		CompanyClient companyClient18 = new CompanyClient("GameStop", "Pennsylvania Avenue", "436C", "62-169",
				"Clamgrad");
		companyClientRepository.save(companyClient18);
		CompanyClient companyClient19 = new CompanyClient("KeyCorp", "Circle Drive", "354B", "50-088", "Emercester");
		companyClientRepository.save(companyClient19);
		CompanyClient companyClient20 = new CompanyClient("BJ's Wholesale Club", "Queen Street", "177B", "61-003",
				"Medfield");
		companyClientRepository.save(companyClient20);
		CompanyClient companyClient21 = new CompanyClient("PVH", "Holly Court", "209B", "27-581", "Chatborough");
		companyClientRepository.save(companyClient21);
		CompanyClient companyClient22 = new CompanyClient("Murphy USA", "Ridge Road", "239C", "33-753", "Parkburgh");
		companyClientRepository.save(companyClient22);
		CompanyClient companyClient23 = new CompanyClient("Polaris Industries", "Devonshire Drive", "224A", "65-429",
				"Salttown");
		companyClientRepository.save(companyClient23);
		CompanyClient companyClient24 = new CompanyClient("McDonald's", "Cypress Court", "328A", "81-198",
				"Jamesstead");
		companyClientRepository.save(companyClient24);
		CompanyClient companyClient25 = new CompanyClient("Steel Dynamics", "Willow Street", "367B", "44-199",
				"South Freegrad");
		companyClientRepository.save(companyClient25);
		CompanyClient companyClient26 = new CompanyClient("Costco Wholesale", "Lincoln Avenue", "292A", "77-065",
				"Cloudstead Falls");
		companyClientRepository.save(companyClient26);
		CompanyClient companyClient27 = new CompanyClient("Ingredion", "Magnolia Avenue", "183B", "83-555", "Eggford");
		companyClientRepository.save(companyClient27);
		CompanyClient companyClient28 = new CompanyClient("Cintas", "Aspen Drive", "303A", "87-175", "Bannby");
		companyClientRepository.save(companyClient28);
		CompanyClient companyClient29 = new CompanyClient("Enterprise Products Partners", "Buckingham Drive", "250B",
				"75-057", "East Freebury");
		companyClientRepository.save(companyClient29);
		CompanyClient companyClient30 = new CompanyClient("Expeditors Intl. of Washington", "Westminster Drive", "199B",
				"85-243", "Starcaster");
		companyClientRepository.save(companyClient30);
		CompanyClient companyClient31 = new CompanyClient("Cigna", "Eagle Street", "30A", "74-006", "Emerness");
		companyClientRepository.save(companyClient31);
		CompanyClient companyClient32 = new CompanyClient("Discovery", "Overlook Circle", "252B", "18-540", "Bellby");
		companyClientRepository.save(companyClient32);
		CompanyClient companyClient33 = new CompanyClient("Cisco Systems", "Fairway Drive", "225A", "77-736",
				"Rivermouth");
		companyClientRepository.save(companyClient33);
		CompanyClient companyClient34 = new CompanyClient("Constellation Brands", "Bridle Lane", "123A", "35-072",
				"Lunside");
		companyClientRepository.save(companyClient34);
		CompanyClient companyClient35 = new CompanyClient("Public Service Enterprise Group", "Inverness Drive", "288B",
				"54-657", "Postport");
		companyClientRepository.save(companyClient35);
		CompanyClient companyClient36 = new CompanyClient("Chevron", "Ivy Lane", "114/42", "13-446", "Buoyworth");
		companyClientRepository.save(companyClient36);
		CompanyClient companyClient37 = new CompanyClient("Sherwin-Williams", "Sunset Avenue", "190/50", "73-693",
				"Farmland");
		companyClientRepository.save(companyClient37);
		CompanyClient companyClient38 = new CompanyClient("MGM Resorts International", "1st Avenue", "91/32", "87-072",
				"Northport");
		companyClientRepository.save(companyClient38);
		CompanyClient companyClient39 = new CompanyClient("ManpowerGroup", "9th Street", "233/30", "54-676", "Millton");
		companyClientRepository.save(companyClient39);
		CompanyClient companyClient40 = new CompanyClient("Voya Financial", "Route 27", "72/33", "58-285",
				"Costsstead");
		companyClientRepository.save(companyClient40);
		CompanyClient companyClient41 = new CompanyClient("Rite Aid", "Cambridge Drive", "337/8", "62-282",
				"Springside Beach");
		companyClientRepository.save(companyClient41);
		CompanyClient companyClient42 = new CompanyClient("Broadcom", "Edgewood Road", "243/22", "49-928", "Sandstead");
		companyClientRepository.save(companyClient42);
		CompanyClient companyClient43 = new CompanyClient("Genuine Parts", "Henry Street", "249/11", "48-896",
				"Gilport");
		companyClientRepository.save(companyClient43);
		CompanyClient companyClient44 = new CompanyClient("AutoZone", "Hamilton Street", "231/3", "37-704",
				"Mannorfolk");
		companyClientRepository.save(companyClient44);
		CompanyClient companyClient45 = new CompanyClient("Lennar", "Elm Avenue", "129/37", "67-785", "Hoscester");
		companyClientRepository.save(companyClient45);
		CompanyClient companyClient46 = new CompanyClient("Aflac", "8th Avenue", "275/25", "19-768", "Farmingworth");
		companyClientRepository.save(companyClient46);
		CompanyClient companyClient47 = new CompanyClient("Applied Materials", "Grand Avenue", "219/20", "70-874",
				"North Winport");
		companyClientRepository.save(companyClient47);
		CompanyClient companyClient48 = new CompanyClient("United Natural Foods", "Orchard Avenue", "24/28", "76-780",
				"Snowhampton");
		companyClientRepository.save(companyClient48);
		CompanyClient companyClient49 = new CompanyClient("Sanmina", "Route 17", "156/37", "37-844", "New Hosburgh");
		companyClientRepository.save(companyClient49);
		CompanyClient companyClient50 = new CompanyClient("Occidental Petroleum", "2nd Avenue", "492/37", "75-530",
				"Hamness");
		companyClientRepository.save(companyClient50);
		CompanyClient companyClient51 = new CompanyClient("Celanese", "Evergreen Lane", "347/2", "36-512",
				"Bellhampton City");
		companyClientRepository.save(companyClient51);
		CompanyClient companyClient52 = new CompanyClient("Peabody Energy", "Myrtle Street", "453/20", "40-473",
				"Foxbury");
		companyClientRepository.save(companyClient52);
		CompanyClient companyClient53 = new CompanyClient("NextEra Energy", "Academy Street", "378/3", "20-253",
				"Transcaster Beach");
		companyClientRepository.save(companyClient53);
		CompanyClient companyClient54 = new CompanyClient("Boeing", "Creek Road", "334/44", "92-069", "Kingborough");
		companyClientRepository.save(companyClient54);
		CompanyClient companyClient55 = new CompanyClient("Olin", "West Street", "256/15", "67-006",
				"West Westborough");
		companyClientRepository.save(companyClient55);
		CompanyClient companyClient56 = new CompanyClient("AECOM", "Bank Street", "139/33", "12-665", "New Middleford");
		companyClientRepository.save(companyClient56);
		CompanyClient companyClient57 = new CompanyClient("Qualcomm", "Pheasant Run", "486/38", "36-474",
				"Farmingkarta");
		companyClientRepository.save(companyClient57);
		CompanyClient companyClient58 = new CompanyClient("Philip Morris International", "4th Avenue", "145/3",
				"25-874", "Bannton");
		companyClientRepository.save(companyClient58);
		CompanyClient companyClient59 = new CompanyClient("Mosaic", "Maple Lane", "38/29", "64-806", "Lunness");
		companyClientRepository.save(companyClient59);
		CompanyClient companyClient60 = new CompanyClient("Raymond James Financial", "Fulton Street", "108/8", "92-008",
				"Fishborough");
		companyClientRepository.save(companyClient60);
		CompanyClient companyClient61 = new CompanyClient("Boston Scientific", "1st Street", "19/35", "29-598",
				"Aelness");
		companyClientRepository.save(companyClient61);
		CompanyClient companyClient62 = new CompanyClient("Marathon Oil", "Jefferson Street", "248/39", "95-261",
				"Sandburgh");
		companyClientRepository.save(companyClient62);
		CompanyClient companyClient63 = new CompanyClient("Western & Southern Financial Group", "Evergreen Drive",
				"153/25", "34-898", "East Richfolk");
		companyClientRepository.save(companyClient63);
		CompanyClient companyClient64 = new CompanyClient("Crown Holdings", "Willow Drive", "111/20", "50-002",
				"South Cloudfolk");
		companyClientRepository.save(companyClient64);
		CompanyClient companyClient65 = new CompanyClient("Spirit AeroSystems Holdings", "Ashley Court", "396/21",
				"24-288", "East Applecester");
		companyClientRepository.save(companyClient65);
		CompanyClient companyClient66 = new CompanyClient("J.M. Smucker", "5th Street North", "754", "36-792",
				"Stronggrad");
		companyClientRepository.save(companyClient66);
		CompanyClient companyClient67 = new CompanyClient("Harley-Davidson", "Bridge Street", "986", "79-859",
				"Lunstead");
		companyClientRepository.save(companyClient67);
		CompanyClient companyClient68 = new CompanyClient("Mohawk Industries", "Primrose Lane", "550", "16-166",
				"Backpool");
		companyClientRepository.save(companyClient68);
		CompanyClient companyClient69 = new CompanyClient("Altria Group", "Highland Avenue", "591", "36-829",
				"Duckstead");
		companyClientRepository.save(companyClient69);
		CompanyClient companyClient70 = new CompanyClient("Altice USA", "Cottage Street", "366", "63-984",
				"South Oaktown");
		companyClientRepository.save(companyClient70);
		CompanyClient companyClient71 = new CompanyClient("Lithia Motors", "Hillcrest Drive", "397", "43-459",
				"Passside");
		companyClientRepository.save(companyClient71);
		CompanyClient companyClient72 = new CompanyClient("Estee Lauder", "Oak Avenue", "698", "16-646", "Sandgrad");
		companyClientRepository.save(companyClient72);
		CompanyClient companyClient73 = new CompanyClient("Freeport-McMoRan", "Brookside Drive", "18", "77-759",
				"Medbury");
		companyClientRepository.save(companyClient73);
		CompanyClient companyClient74 = new CompanyClient("Calpine", "Olive Street", "579", "70-694",
				"Tallmouth Island");
		companyClientRepository.save(companyClient74);
		CompanyClient companyClient75 = new CompanyClient("Fiserv", "Roberts Road", "880", "60-669", "Saltdale");
		companyClientRepository.save(companyClient75);
		CompanyClient companyClient76 = new CompanyClient("Toll Brothers", "Church Road", "303", "90-603",
				"West Bellstead");
		companyClientRepository.save(companyClient76);
		CompanyClient companyClient77 = new CompanyClient("Performance Food Group", "Oak Street", "911", "81-288",
				"Southingview");
		companyClientRepository.save(companyClient77);
		CompanyClient companyClient78 = new CompanyClient("Parker-Hannifin", "Broad Street", "274", "76-379",
				"Winside");
		companyClientRepository.save(companyClient78);
		CompanyClient companyClient79 = new CompanyClient("Lincoln National", "Walnut Avenue", "774", "50-048",
				"Dodgefolk Falls");
		companyClientRepository.save(companyClient79);
		CompanyClient companyClient80 = new CompanyClient("J.B. Hunt Transport Services", "Mulberry Lane", "562",
				"22-151", "North Winburg");
		companyClientRepository.save(companyClient80);
		CompanyClient companyClient81 = new CompanyClient("Analog Devices", "Victoria Court", "652", "53-392",
				"Skilldol");
		companyClientRepository.save(companyClient81);
		CompanyClient companyClient82 = new CompanyClient("Omnicom Group", "New Street", "394", "52-360", "Wingpool");
		companyClientRepository.save(companyClient82);
		CompanyClient companyClient83 = new CompanyClient("Kraft Heinz", "Rosewood Drive", "388", "28-729",
				"Hosview City");
		companyClientRepository.save(companyClient83);
		CompanyClient companyClient84 = new CompanyClient("Hormel Foods", "Country Club Road", "238", "67-332",
				"Fairford");
		companyClientRepository.save(companyClient84);
		CompanyClient companyClient85 = new CompanyClient("Publix Super Markets", "Berkshire Drive", "340", "76-252",
				"Fauxburg");
		companyClientRepository.save(companyClient85);
		CompanyClient companyClient86 = new CompanyClient("UGI", "Clinton Street", "614", "35-589", "Norkarta");
		companyClientRepository.save(companyClient86);
		CompanyClient companyClient87 = new CompanyClient("Duke Energy", "College Street", "475", "55-662", "Stoneby");
		companyClientRepository.save(companyClient87);
		CompanyClient companyClient88 = new CompanyClient("Supervalu", "Euclid Avenue", "883", "92-547",
				"Foxdale Hills");
		companyClientRepository.save(companyClient88);
		CompanyClient companyClient89 = new CompanyClient("Arconic", "Hill Street", "193", "59-852",
				"Great Southingfolk");
		companyClientRepository.save(companyClient89);
		CompanyClient companyClient90 = new CompanyClient("Target", "9th Street West", "897", "21-566",
				"Lunaworth Island");
		companyClientRepository.save(companyClient90);
		CompanyClient companyClient91 = new CompanyClient("FirstEnergy", "Woodland Avenue", "566", "86-504", "Snowdol");
		companyClientRepository.save(companyClient91);
		CompanyClient companyClient92 = new CompanyClient("Anadarko Petroleum", "Eagle Road", "583", "54-744",
				"Readingkarta Island");
		companyClientRepository.save(companyClient92);
		CompanyClient companyClient93 = new CompanyClient("Exxon Mobil", "Redwood Drive", "383", "80-274",
				"Casterton Park");
		companyClientRepository.save(companyClient93);
		CompanyClient companyClient94 = new CompanyClient("SpartanNash", "Sherman Street", "582", "81-165", "Waterdol");
		companyClientRepository.save(companyClient94);
		CompanyClient companyClient95 = new CompanyClient("W.W. Grainger", "Canal Street", "739", "85-190",
				"Factside Beach");
		companyClientRepository.save(companyClient95);
		CompanyClient companyClient96 = new CompanyClient("Keurig Dr Pepper", "Summit Avenue", "795", "76-706",
				"West Saltcaster");
		companyClientRepository.save(companyClient96);
		CompanyClient companyClient97 = new CompanyClient("A-Mark Precious Metals", "Cleveland Street", "606", "19-938",
				"Holtsport");
		companyClientRepository.save(companyClient97);
		CompanyClient companyClient98 = new CompanyClient("Dillard's", "Jones Street", "230", "87-257", "Freeness");
		companyClientRepository.save(companyClient98);
		CompanyClient companyClient99 = new CompanyClient("Bank of America", "Briarwood Drive", "492", "90-268",
				"Bridgepool");
		companyClientRepository.save(companyClient99);
		CompanyClient companyClient100 = new CompanyClient("NCR", "10th Street", "895", "36-097", "Griffinville");
		companyClientRepository.save(companyClient100);
	}
}