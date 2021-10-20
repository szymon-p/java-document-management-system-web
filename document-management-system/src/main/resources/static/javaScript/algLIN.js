function algLIN() {
	
	//Funkcja ignoruje użycie klawiszy, kolejno CapsLock, Alt, Ctrl, Shift.
	var key = event.keyCode || event.charCode;
	if (key === 20 || key === 18 || key === 17 || key === 16); else {
		
		// Rozpoczęcie rejestracji czasu wykonania kodu w konsoli przeglądarki.
		console.time('algLIN');
		
		// pattern - zawartość tekstowa inputa do filtrowania danych opartego o algorytm liniowy.
		// table - zawartość tabeli. - Lokalizowana po id w documents.html.
		// tr, td - odpowiednio wiersze i komórki tabeli.
		// tdString - zawartość tekstowa konkretnych komórek tabeli.
		var pattern, table, tr, td, tdString;

		// Pobranie tekstu filtrowanej frazy oraz zamiana liter na duże.
		pattern = document.getElementById("inputAlgLIN").value.toUpperCase();
		
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

				// Wywołanie funkcji filtrowania liniowego. 
				// Podanie w argumencie tablicy z treścią komórek oraz poszukiwanego elementu.
				linearFilter(tdString, pattern);

				// Funkcja filtrowania liniowego.
				function linearFilter(tdString, pattern) {
					
					// Pętla wykonywana jest po wszystkich elementach tablicy.
					for (var i = 0; i < tdString.length; i++) {
						
						// W trakcie przebiegu pętli porównywane są elementy tablicy ze wzorcem.
						// Jeśli element tablicy jest równy wzorcowi, to następuje wyświetlenie rekordu w tabeli.
						if (tdString[i] == pattern) {
							
							// Wyświetlenie wiersza w tabeli.
							return tr[w].style.display = "";
						}
					}
					
					// Ukrycie wiersza w tabeli.
					return tr[w].style.display = "none";
				}
			}
		}
		
		// Zakończenie rejestracji czasu wykonania kodu.
		console.timeEnd('algLIN');
		
		// Przekazanie do skryptu pagination.js danych, które powinny zostać wyświetlone w tabeli.
		settingOptions($('#table tr:gt(0)').filter(':visible'));
	}
}