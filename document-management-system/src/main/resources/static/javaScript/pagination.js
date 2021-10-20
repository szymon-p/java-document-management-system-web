// Metoda, która obsługuje zmianę liczby wyświetlanych rekordów w tabeli.
function getPagination() {

	// Uruchomienie funkcji za każdym razem kiedy wartość elementu ulegnie zmianie.
	$('#maxRows').on('change', function(evt) {

		// Wywołanie funkcji z argumentami - pobranie wierszy tabeli bez nagłówka.
		settingOptions($('#table tr:gt(0)'));

		// Wyczyszczenie zawartości inputów do filtrowania danych, 
		// po każdej zmianie liczby wyświetlanych rekordów.
		document.getElementById("inputAlgKMP").value = "";
		document.getElementById("inputAlgBM").value = "";
		document.getElementById("inputAlgKR").value = "";
		document.getElementById("inputAlgBIN").value = "";
		document.getElementById("inputAlgLIN").value = "";
	})
	// Domyślne ustawienia dla liczby wyświetlanych rekordów.
	.val(5)
	// Zaktualizuj liczbę wyświetlanych rekordów w tabeli.
	.change();
}

// Metoda ustawiająca po załadowaniu strony wybranych ustawień użytkownika
// - opcji na liście ilości wyświetlanych rekordów, oblicza ilość stron oraz
// wyświetla podsumowania strony.
function settingOptions(tab) {

	// Inicjalizacja zmiennych wykorzystywanych do wypełnienia celu funkcji
	// opisanego w poprzednim komentarzu.
	// Przechowanie wierszy tabeli w zmiennej.
	var $table = tab;
	// Zmienna przechowująca liczbę wyświetlanych rekordów.
	var totalRows = tab.length;

	// Usuwanie trzech ostatnich stron podczas przechodzenia na kolejną lub
	// poprzednią stronę.
	// Dzięki usunięciu, trzy przyciski nawigacji dla stron nie są dublowane.
	// Poszukiwanie struktury html (li) odbywa się po klasie.
	$('.pagination').find('li')
	// Wybór elementów do usunięcia oraz usunięcie ich.
	.slice(1, -1).remove();

	// Pobranie maksymalnej liczby wierszy z listy, która ma być wyświetlona na
	// stronie w tabeli - zmiana dokonana przez użytkownika.
	var maxRows = parseInt($('#maxRows').val());

	// Inicjalizacja zmiennej "j" będącej iteratorem po wierszach tablicy.
	var j = 0;

	// Funkcja przechodząca po wszystkich elementach (wierszach) tabeli.
	$table.each(function() {

		// Po każdej iteracji następuje zwiększenie licznika o jeden.
		j++;

		// Warunek - jeśli liczba rekordów na stronie (j) jest mniejsza od
		// maksymalnej liczby rekordów ustawionej przez użytkownika,
		// to wyświetl rekordy. W przeciwnym przypadku ukryj.
		if (j > maxRows) $(this).hide();
		if (j <= maxRows) $(this).show();
	});

	// Warunek uruchamiany w przypadku kiedy wszystkie wyfiltrowane rekordy nie mieszczą się na jednej stronie,
	// ze względu na limit wyświetlanych rekordów ustawionych przez użytkownika.
	if (totalRows > maxRows) {

		// Obliczenie i zapisanie do zmiennej liczby stron tabeli na podstawie
		// liczby znalezionych rekordów oraz ustawienia liczby wyświetlanych
		// rekordów na pojedynczej stronie.
		var totalPageNumber = Math.ceil(totalRows / maxRows);

		// Wstrzyknięcie struktury HTML do podstrony /documents na podstawie
		// klasy oraz identyfikatora.
		// Kod HTML dodaje przyciski dla konkretnych stron na podstawie
		// obliczonych wyżej wartości.
		for (var i = 1; i <= totalPageNumber;) {
			$('.pagination #prev').before(
				'<li data-page="'+ i + '">\
				<span>'+ i++
				// Dzięki klasie sr-only numery stron nie są zaznaczane podczas nawigowania.
				+ '<span class="sr-only">(current)</span></span>\
				</li>')
			.show();
		}
	}

	// Wyświetlenie podsumowania strony.
	summary(totalPageNumber, totalRows);

	// Ustawienie dla pierwszej strony klasy active. - Pomaga zlokalizować
	// stronę, na której użytkownik znajduje się.
	$('.pagination [data-page="1"]').addClass('active'); // add active class

	// Kodu jest uruchamiany przy kliknięciu w button strony.
	$('.pagination li').on('click', function(evt) {

				// Pobranie wartości atrybutu - pobranie numeru aktywnej strony.
				var pageNumber = $(this).attr('data-page');

				// Aktualizacja podsumowania strony.
				summary(totalPageNumber, totalRows);

				// Usunięcie z poprzedniej strony klasy active. Klasa active
				// informuje o stronie, na której aktualnie znajduje się użytkownik.
				$('.pagination li').removeClass('active');

				// Dodanie do bieżącej strony klasy active.
				$('.pagination [data-page="' + pageNumber + '"]').addClass('active');

				// Wywołanie funkcji odpowiedzialnej za wyświetlanie ilości
				// stron w panelu nawigacji. Uruchamiane tylko wtedy, kiedy
				// użytkownik przechodzi pomiędzy stronami.
				limitPagging();

				// Zadeklarowanie iteratora, który będzie przechodził po
				// wszystkich wierszach tablicy.
				var trIterator = 0;

				// Przejście po wszystkich wierszach tablicy.
				$table.each(function() {

					trIterator++;

					// Jeśli iterator jest większy od maksymalnej liczby wierszy
					// na stronie, to pozostałe wiersze ukrywa.
					// Analogicznie ukrycie następuje, jeśli wyfiltrowanych
					// rekordów jest mniej niż maksymalna liczba rekordów,
					// która się zmieści na stronie tabeli.
					// Jeśli oba warunki nie są spełnione, to wiersz jest wyświetlany.
					if (trIterator > maxRows * pageNumber || trIterator <= maxRows * pageNumber - maxRows) {
						$(this).hide();
					} else {
						$(this).show();
					}
				});
			});

	// Przeliczenie ilości stron w panelu nawigacji.
	// W przeciwnym przypadku po załadowaniu podstrony, zostałyby wyświetlone
	// wszystkie strony tabeli.
	limitPagging();
}

// Funkcja odpowiedzialna za wyświetlenie podsumowania strony.
function summary(totalPageNumber, totalRows) {

	// Wyświetlenie podsumowania strony.
	// Lokalizowany jest element strony po id, po czym dodawana jest pomiędzy
	// tagi akapitu "p" treść podsumowania.
	document.getElementById("amountOfRows").innerHTML = "Strona 1 z "
		+ totalPageNumber + " (" + totalRows + " rekordów)";
}

// Funkcja odpowiedzialna za wyświetlenie ilości przycisków do nawigacji
// pomiędzy stronami.
function limitPagging() {

	// Warunek dla wyświetlania stron, jeśli aktualna strona jest większa
	// lub równa drugiej.
	if ($('.pagination li.active').attr('data-page') <= 2) {

		// Ukrycie wszystkich stron powyżej strony trzeciej.
		$('.pagination li:gt(3)').hide();

		// Wyświetlenie wszystkich stron poniżej strony trzeciej.
		$('.pagination li:lt(3)').show();
	}

	// Warunek dla wyświetlania stron, jeśli aktualna strona jest większa od drugiej.
	if ($('.pagination li.active').attr('data-page') > 2) {

		// Ukrycie wszystkich stron.
		$('.pagination li:gt(0)').hide();

		// Pętla dbająca o wyświetlanie tylko trzech stron - aktualnej, jednej
		// wstecz oraz jednej do przodu
		for (let i = parseInt($('.pagination li.active').attr('data-page')) - 1; i <= parseInt($(
				'.pagination li.active').attr('data-page')) + 1; i++) {
			$('.pagination [data-page="' + i + '"]').show();
		}
	}
}