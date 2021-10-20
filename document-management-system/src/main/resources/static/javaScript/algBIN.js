function algBIN() {
	
	//Funkcja ignoruje użycie klawiszy, kolejno CapsLock, Alt, Ctrl, Shift.
	var key = event.keyCode || event.charCode;
	if (key === 20 || key === 18 || key === 17 || key === 16); else {
		
		// Rozpoczęcie rejestracji czasu wykonania kodu w konsoli przeglądarki.
		console.time('algBIN');
		
		// pattern - zawartość tekstowa inputa do filtrowania danych opartego o algorytm binarny.
		// table - zawartość tabeli. - Lokalizowana po id w documents.html.
		// tr, td - odpowiednio wiersze i komórki tabeli.
		// tdString - zawartość tekstowa konkretnych komórek tabeli.
		var pattern, table, tr, td, tdString;
		
		// Pobranie tekstu filtrowanej frazy oraz zamiana liter na duże.
		pattern = document.getElementById("inputAlgBIN").value.toUpperCase();
		
		// Pobranie zawartości tabeli.
		table = document.getElementById("table");
		
		// Z pobranej tablicy wyszczególnienie wierszy tabeli.
		tr = table.tBodies[0].getElementsByTagName("tr");

		// Przejście po wierszach tabeli.
		for (var w = 0; w < tr.length; w++) {
			
			// Wyszczególnienie komórek tabeli z wierszy.
			td = tr[w].getElementsByTagName("td");

			// Wyświetlenie wszystkich wierszy tabeli. - Wiersze niepasujące do filtra będą następnie ukrywane.
			tr[w].style.display = "";
			
			// Kod wykonywany, jeśli istnieją komórki tabeli
			// oraz usunięto backspacem wszystkie znaki w inpucie do filtrowania danych.
			if ((td && pattern) != "") {

				// Wyciągnięcie tekstu z komórek tabeli oraz dodanie ich do tablicy.
				tdString = [ 
						td[1].textContent.toUpperCase(),
						td[2].textContent.toUpperCase(),
						td[3].textContent.toUpperCase(),
						td[4].textContent.toUpperCase(),
						td[5].textContent.toUpperCase(),
						td[6].textContent.toUpperCase(),
						td[7].textContent.toUpperCase()
						]

				// Sortowanie tabeli.
				var sortedTdString = tdString.sort();

				// Wywołanie funkcji filtrowania binarnego. 
				// Podanie w argumencie posortowanej tabeli oraz poszukiwanego elementu.
				binaryFilter(sortedTdString, pattern);

				// Funkcja filtrowania binarnego.
				function binaryFilter(sortedTdString, pattern) {
					
					// Ustawienie początkowej wartości najniższego indeksu tablicy na zero.
					var lowIndex = 0;
					
					// Ustawienie początkowej wartości najwyższego indeksu tablicy na ostatni element tablicy.
					var highIndex = sortedTdString.length - 1;
					
					// Pętla jest wykonywana dopóki indeks dolny nie przekroczy wartości indeksu górnego.
					while (lowIndex <= highIndex) {
						
						// Obliczenie indeksu środkowego tablicy na podstawie średniej arytmetycznej.
						var middleIndex = Math.floor((lowIndex + highIndex) / 2);
						
						// Jeśli pod inkedsem środkowym posortowanej tablicy elementów znajduje się wzorzec, to wyświetl ten rekord w tabeli.
						if (sortedTdString[middleIndex] == pattern) {
							
							// Wyświetlenie wiersza w tabeli.
							return tr[w].style.display = "";
							
						// Przeciwny przypadek.
						// Jeśli element środkowy posortowanej tablicy jest mniejszy od wzorca,
						// to jako indeks dolny zostaje ustawiona wartość indeksu środkowego powiększonego o jeden.
						} else if (sortedTdString[middleIndex] < pattern) {
							
							lowIndex = middleIndex + 1;
							
						// W przeciwnym przypadku zostaje ustawiony indeks górny jako indeks środkowy, ale pomniejszony o jeden.
						} else {
							
							highIndex = middleIndex - 1;
						}
					}

					// Ukrycie wiersza w tabeli.
					return tr[w].style.display = "none";
				}
			}
		}
		
		// Zakończenie rejestracji czasu wykonania kodu.
		console.timeEnd('algBIN');
		
		// Przekazanie do skryptu pagination.js danych, które powinny zostać wyświetlone w tabeli.
		settingOptions($('#table tr:gt(0)').filter(':visible'));
	}
}